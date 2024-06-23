/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.ConectDataBase;
import MODEL.ModelUser;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author ANH TUAN
 */
public class CheckTable implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<ModelUser> data;
    private int id;
    private String name;
    private double balance;
    private int numbersOfBook;
    public static SwingWorker<Void, Void> worker;
    private String passs;
    
    public String getPasss() {
		return passs;
	}

	public void setPasss(String passs) {
		this.passs = passs;
	}

	public CheckTable() {
    }

    public ArrayList<ModelUser> getData() {
        return data;
    }

    public void setData(ArrayList<ModelUser> data) {
        this.data = data;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumbersOfBook() {
        return numbersOfBook;
    }

    public void setNumbersOfBook(int numbersOfBook) {
        this.numbersOfBook = numbersOfBook;
    }

    public static SwingWorker<Void, Void> getWorker() {
        return worker;
    }

    public static void setWorker(SwingWorker<Void, Void> worker) {
        CheckTable.worker = worker;
    }
    public void addDataInTable() throws InterruptedException, ExecutionException{
        data = new ArrayList<>();
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try(Connection com = ConectDataBase.getConnection()) {
                    String sql = "SELECT *FROM taikhoan";
                    try(PreparedStatement st = com.prepareStatement(sql)){
                        try(ResultSet rs = st.executeQuery() ){
                            while (rs.next()){
                               id = rs.getInt("IdUser");
                               name = rs.getString("TenDangNhap");
                               numbersOfBook = rs.getInt("BookNumbers");
                               balance = rs.getDouble("BalanceUser");
                               passs= rs.getString("pass");
                               data.add(new ModelUser(id, name, numbersOfBook, balance,passs));
                               
                            }
                        }
                        
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        worker.get();
    }
    
}
