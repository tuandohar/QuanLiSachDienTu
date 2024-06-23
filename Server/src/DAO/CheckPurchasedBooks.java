package DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DataBase.ConectDataBase;
import MODEL.SanPhamMD;

public class CheckPurchasedBooks implements Serializable {

	private static final long serialVersionUID = 1L;

	public void updateDatabase(int userid, int bookid) throws SQLException {
		try (Connection connection = ConectDataBase.getConnection()) {

			String insertQuery = "INSERT INTO nguoidungdamua(IdUser,IdSach) VALUES(?,?)";
			try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

				insertStatement.setInt(1, userid);
				insertStatement.setInt(2, bookid);

				insertStatement.executeUpdate();
			}
		}

	}

}
