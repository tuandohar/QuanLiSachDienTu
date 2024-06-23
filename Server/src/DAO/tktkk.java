package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.ConectDataBase;

public class tktkk {

    private static final long serialVersionUID = 1L;

    public void updateDatabase(int j) throws SQLException {
        try (Connection com = ConectDataBase.getConnection()) {
            String sql = "SELECT IdSach FROM nguoidungdamua WHERE IdUser=?";
            try (PreparedStatement ps = com.prepareStatement(sql)) {
                ps.setInt(1, j);
                
                try (ResultSet rs = ps.executeQuery()) {
                    // Sử dụng while thay vì if để in ra tất cả các giá trị
                    while (rs.next()) {
                        int k = rs.getInt("IdSach");
                        System.out.println(k);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        tktkk l = new tktkk();
        try {
            l.updateDatabase(123);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
