package DAO;

import DataBase.ConectDataBase;
import MODEL.ModelUser;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateUser implements Serializable{

    private static final long serialVersionUID = 1L;

    public void updateDatabase(ArrayList<ModelUser> userList) throws SQLException {
        try (Connection connection = ConectDataBase.getConnection()) {
            // Xóa hết dữ liệu từ bảng
            String deleteQuery = "DELETE FROM taikhoan";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.executeUpdate();
            }

            // Thêm lại dữ liệu từ danh sách ModelUser và pass vào bảng
            String insertQuery = "INSERT INTO taikhoan(IdUser, TenDangNhap, BookNumbers, pass, BalanceUser) VALUES(?,?,?,?,?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                for (int i = 0; i < userList.size(); i++) {
                    ModelUser user = userList.get(i);
                   

                    insertStatement.setInt(1, user.getId());
                    insertStatement.setString(2, user.getName());
                    insertStatement.setInt(3, user.getNumbersOfBook());
                    insertStatement.setString(4, user.getPass());
                    insertStatement.setDouble(5, user.getBalance());

                    insertStatement.executeUpdate();
                }
            }
        }
    }
}
