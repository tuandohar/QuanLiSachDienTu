/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.ConectDataBase;
import MODEL.ModelUser;

import java.awt.Frame;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class CheckU implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int numbers;
    private double balance = 0.0;
    private boolean checkk;
    public static SwingWorker<Void, Void> worker;
    private ArrayList<ModelUser> user;
    private String passs;
    
    
    public String getPasss() {
		return passs;
	}

	public void setPasss(String passs) {
		this.passs = passs;
	}

	public CheckU() {

    }

    public void CheckU(JPanel j, String userName, String pass) {
        user = new ArrayList<>();
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (Connection com = ConectDataBase.getConnection()) {
                    String sql = "SELECT * FROM taikhoan WHERE TenDangNhap=? and pass=?";
                    try (PreparedStatement ps = com.prepareStatement(sql)) {
                        ps.setString(1, userName);
                        ps.setString(2, pass);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                checkk = true;
                                id = rs.getInt("IdUser");
                                name = rs.getString("TenDangNhap");
                                numbers = rs .getInt("BookNumbers");
                                balance = rs.getDouble("BalanceUser");
                                passs = rs.getString("pass");
                                ModelUser us = new ModelUser(id, name, numbers, balance,passs);
                                user.add(us);
                            } else {
                                checkk = false;
                            }
                        }
                    }
                } catch (Exception e) {
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        worker.execute();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<ModelUser> getUser() {
        return user;
    }

    public void setUser(ArrayList<ModelUser> user) {
        this.user = user;
    }

    public static SwingWorker<Void, Void> getWorker() {
        return worker;
    }

    public static void setWorker(SwingWorker<Void, Void> worker) {
        CheckU.worker = worker;
    }
    
    
    public boolean isCheckk() {
        return checkk;
    }

    public void setCheckk(boolean checkk) {
        this.checkk = checkk;
    }

}
