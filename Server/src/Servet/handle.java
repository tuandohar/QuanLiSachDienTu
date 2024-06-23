package Servet;
import DAO.CheckPurchasedBooks;
import DAO.UploadBook;
import DataBase.ConectDataBase;
import MODEL.ModelUser;
import MODEL.SanPhamMD;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import Chay.Chay;

public class handle implements Runnable, Serializable {

    private static final long serialVersionUID = 1L;
    private Socket clientSocket;
    private Chay chayInstance; // Reference to the Chay instance

    public handle(Socket clientSocket, Chay chayInstance) {
        this.clientSocket = clientSocket;
        this.chayInstance = chayInstance;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {

            String action = (String) inputStream.readObject();
            String userName = (String) inputStream.readObject();
            String pass = (String) inputStream.readObject();
            String BookId = (String) inputStream.readObject();

            if ("login".equalsIgnoreCase(action) && BookId == null) {
                ModelUser user = checkUserFromDatabase(userName, pass);
                if (user != null) {
                    outputStream.writeObject("Login success");
                    outputStream.writeObject(user);

                    UploadBook upbook = new UploadBook();
                    upbook.CheckU();
                    try {
                        upbook.worker.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    ArrayList<SanPhamMD> sp = upbook.getSp();
                    outputStream.writeObject(sp); // Gửi danh sách sản phẩm về client
                } else {
                    outputStream.writeObject("Login failed"); // Thêm thông báo đăng nhập thất bại
                }
            } else if ("register".equalsIgnoreCase(action) && BookId == null) {
                boolean isRegistered = register(userName, pass);
                if (isRegistered) {
                    outputStream.writeObject("Register success");
                } else {
                    outputStream.writeObject("Register failed");
                }
            } else if ("update".equalsIgnoreCase(action) && BookId != null) {
                try {
                    int bookId = Integer.parseInt(BookId);
                    int userId = Integer.parseInt(userName);
                    double balance = Double.parseDouble(pass);

                    boolean buyNumberUpdated = updateBookBuyNumber(bookId);

                    CheckPurchasedBooks checkPurchasedBooks = new CheckPurchasedBooks();
                    try {
                        checkPurchasedBooks.updateDatabase(userId, bookId);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    boolean balanceUpdated = updateBalance(userId, balance);

                    if (buyNumberUpdated) {
                        System.out.println("BuyNumber updated successfully for ProductID " + bookId);
                    } else {
                        System.out.println("Failed to update BuyNumber for ProductID " + bookId);
                    }

                    if (balanceUpdated) {
                        System.out.println("Balance updated successfully for UserID " + userId);
                    } else {
                        System.out.println("Failed to update balance for UserID " + userId);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format for BookId, UserName, or Balance.");
                    e.printStackTrace();
                }
            } else if ("help".equalsIgnoreCase(action) && BookId == null) {
                // Pass userName and pass to Chay instance
                chayInstance.setClientID(userName);
                chayInstance.setClientText(pass);
                chayInstance.updateForm5();
                // You can add any additional handling here
            } else if ("getPurchasedBooks".equalsIgnoreCase(action) && userName != null && pass == null && BookId == null) {
                int userId = Integer.parseInt(userName);
                ArrayList<Integer> purchasedBooks = getPurchasedBooksFromDatabase(userId);
                outputStream.writeObject(purchasedBooks);
                System.out.println(purchasedBooks.get(0));
            }

            outputStream.flush(); // Ensure all data is sent before closing

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close(); // Ensure the socket is closed
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<Integer> getPurchasedBooksFromDatabase(int userId) {
        ArrayList<Integer> purchasedBooks = new ArrayList<>();
        try (Connection con = ConectDataBase.getConnection()) {
            String sql = "SELECT * FROM nguoidungdamua WHERE IdUser = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int itemId = rs.getInt("IdSach");
                        purchasedBooks.add(itemId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchasedBooks;
    }

    private ModelUser checkUserFromDatabase(String name, String pass) {
        ModelUser user = null;
        try (Connection com = ConectDataBase.getConnection()) {
            String sql = "SELECT * FROM taikhoan WHERE TenDangNhap = ? AND pass = ?";
            try (PreparedStatement ps = com.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, pass);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("IdUser");
                        String names = rs.getString("TenDangNhap");
                        int numbers = rs.getInt("BookNumbers");
                        double balance = rs.getDouble("BalanceUser");
                        String passs = rs.getString("pass");
                        user = new ModelUser(id, names, numbers, balance, passs);
                    } else {
                        user = null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateBalance(int id, double balance) {
        String sql = "UPDATE taikhoan SET BalanceUser = ? WHERE IdUser = ?";

        try (Connection com = ConectDataBase.getConnection(); PreparedStatement pstmt = com.prepareStatement(sql)) {

            pstmt.setDouble(1, balance);
            pstmt.setInt(2, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBookBuyNumber(int productId) {
        String sql = "UPDATE product SET BuyNumber = BuyNumber + 1 WHERE ProductID = ?";

        try (Connection com = ConectDataBase.getConnection(); PreparedStatement pstmt = com.prepareStatement(sql)) {

            pstmt.setInt(1, productId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean register(String user, String pass) {
        try (Connection com = ConectDataBase.getConnection()) {
            String sql = "INSERT INTO taikhoan (IdUser, TenDangNhap, pass, BalanceUser, BookNumbers) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = com.prepareStatement(sql)) {
                Random random = new Random();
                int randomnumber = random.nextInt(9000) + 1000;
                pstmt.setInt(1, randomnumber);
                pstmt.setString(2, user);
                pstmt.setString(3, pass);
                pstmt.setDouble(4, 0);
                pstmt.setInt(5, 0);
                pstmt.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
