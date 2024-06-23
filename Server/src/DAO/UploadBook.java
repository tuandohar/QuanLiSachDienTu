package DAO;

import DataBase.ConectDataBase;
import MODEL.ModelUser;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import DataBase.ConectDataBase;
import MODEL.ModelUser;
import MODEL.SanPhamMD;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadBook implements Serializable{

    private static final long serialVersionUID = 1L;

    private int bookId;
    private String bookName;
    private String description;
    private String type;
    private double price;
    private String authorName;
    private String link;
    private String content;
    
    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static SwingWorker<Void, Void> worker;
    private ArrayList<SanPhamMD> sp;

    public UploadBook() {

    }

    public void CheckU() {
        sp = new ArrayList<>();

        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (Connection connection = ConectDataBase.getConnection()) {
                    String query = "SELECT ProductID, BookName, Description, Type, Price,image, author, content FROM product";
                    try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            bookId = resultSet.getInt("ProductID");
                            bookName = resultSet.getString("BookName");
                            description = resultSet.getString("Description");
                            type = resultSet.getString("Type");
                            price = resultSet.getDouble("Price");
                            link = resultSet.getString("image");
                            authorName = resultSet.getString("author");
                            content = resultSet.getString("content");
                            SanPhamMD sp1 = new SanPhamMD(bookId, bookName, description, price, type, link, authorName,content);
                            sp.add(sp1);
                            
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null; // Trả về null nếu không có lỗi
            }
        };
        worker.execute();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static SwingWorker<Void, Void> getWorker() {
        return worker;
    }

    public static void setWorker(SwingWorker<Void, Void> worker) {
        UploadBook.worker = worker;
    }

    public ArrayList<SanPhamMD> getSp() {
        return sp;
    }

    public void setSp(ArrayList<SanPhamMD> sp) {
        this.sp = sp;
    }

}
