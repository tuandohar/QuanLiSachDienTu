
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

public class uploadUser implements Serializable {

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

	public uploadUser() {

	}

	public void CheckU() {
		user = new ArrayList<>();
		
		worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				try (Connection connection = ConectDataBase.getConnection()) {
					String query = "SELECT IdUser, TenDangNhap, BookNumbers, pass, BalanceUser FROM taikhoan";
					try (PreparedStatement statement = connection.prepareStatement(query);
							ResultSet resultSet = statement.executeQuery()) {
						while (resultSet.next()) {
							id = resultSet.getInt("IdUser");
							name = resultSet.getString("TenDangNhap");
							numbers = resultSet.getInt("BookNumbers");
							balance = resultSet.getDouble("BalanceUser");
							String passs = resultSet.getString("pass");

							ModelUser user1 = new ModelUser(id, name, numbers, balance, passs);
							user.add(user1);

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
