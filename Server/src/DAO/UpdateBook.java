
package DAO;

import DataBase.ConectDataBase;
import MODEL.ModelUser;
import MODEL.SanPhamMD;
import java.awt.image.SampleModel;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class UpdateBook implements Serializable{

    private static final long serialVersionUID = 1L;
     public void updateDatabase(ArrayList<SanPhamMD> spmdt) throws SQLException {
        try (Connection connection = ConectDataBase.getConnection()) {
            // Xóa hết dữ liệu từ bảng
            String deleteQuery = "DELETE FROM product";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.executeUpdate();
            }

            // Thêm lại dữ liệu từ danh sách ModelUser và pass vào bảng
            String insertQuery = "INSERT INTO product(ProductID, BookName, Description, Type, Price, image, author) VALUES(?,?,?,?,?,?,?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                for (int i = 0; i < spmdt.size(); i++) {
                    SanPhamMD spl = spmdt.get(i);
                    

                    insertStatement.setInt(1, spl.getItemID());
                    insertStatement.setString(2, spl.getItemName());
                    insertStatement.setString(3, spl.getDescription());
                    insertStatement.setString(4, spl.getBrandName());
                    insertStatement.setDouble(5, spl.getPrice());
                    insertStatement.setString(6, spl.getImage());
                    insertStatement.setString(7, spl.getAuthor());
                    insertStatement.setString(7, spl.getContent());

                    insertStatement.executeUpdate();
                }
            }
        }
    }
    
}
