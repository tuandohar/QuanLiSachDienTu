/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.ConectDataBase;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingWorker;

/**
 *
 * @author ANH TUAN
 */
public class CheckInformation {
    private String name;
    private int id;
    private int numbersOfBook;
    private double balance;
    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    public static SwingWorker<Void, Void> getWorker() {
        return worker;
    }

    public static void setWorker(SwingWorker<Void, Void> worker) {
        CheckInformation.worker = worker;
    }
    
    public static SwingWorker<Void, Void> worker;
    public void checkInformation(int id){
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (java.sql.Connection com = ConectDataBase.getConnection()){
                    String sql = "SELECT * FROM taikhoan WHERE IdUser=?";
                     try (PreparedStatement ps = com.prepareStatement(sql)){
                         ps.setInt(1, id);
                         try(ResultSet rs = ps.executeQuery()){
                             if(rs.next()){
                                 check=true;
                                 name = rs.getString("TenDangNhap");
                                 numbersOfBook = rs.getInt("BookNumbers");
                                 balance = rs.getDouble("BalanceUser");
                                 
                             }
                             else{
                                 check = false;
                             }
                         }
                     }
                } catch (Exception e) {
                     e.printStackTrace();
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        worker.execute();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumbersOfBook() {
        return numbersOfBook;
    }

    public void setNumbersOfBook(int numbersOfBook) {
        this.numbersOfBook = numbersOfBook;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
