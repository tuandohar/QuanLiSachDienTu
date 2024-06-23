/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.ConectDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ANH TUAN
 */
public class delete {
    public static void deleteFromTaikhoan(int id) throws SQLException {
        try(Connection com = ConectDataBase.getConnection()) {
            String sql = "DELETE FROM taikhoan WHERE IdUser = ?";
            try(PreparedStatement ps = com.prepareStatement(sql)) {
               ps.setInt(1, id);
            // Thực thi câu lệnh xóa
            int rowsAffected = ps.executeUpdate();
            // Kiểm tra xem có hàng nào bị xóa không
            if (rowsAffected > 0) {
                System.out.println("Đã xóa hàng có id = " + id);
            } else {
                System.out.println("Không tìm thấy hàng nào có id = " + id);
            } 
            } 
        } catch (Exception e) {
        }
       
    }

  
}
