/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.ConectDataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


/**
 *
 * @author ANH TUAN
 */
public class CreateAccount {
    public CreateAccount(){
    }
    public void NewUser(String tentaikhoan, String pass) throws SQLException{
        try (Connection con = ConectDataBase.getConnection() ){
            String sql = "INSERT INTO taikhoan (TenDangNhap, pass) VALUE (?,?)";
            try(PreparedStatement st = con.prepareStatement(sql)){
                st.setString(1, tentaikhoan);
                st.setString(2, pass);
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Dữ liệu đã được chèn thành công!");
                } else {
                    System.out.println("Không thể chèn dữ liệu.");
                }

            }
        } catch (Exception e) {
        }
    }
}
