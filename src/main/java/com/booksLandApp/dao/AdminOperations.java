package com.booksLandApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminOperations {
	DBConnectivity db = new DBConnectivity();
	Connection conn = db.dbconnection();

	public boolean login(String username, String password) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from admin_details where user_name=? && password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet result = ps.executeQuery();

		if (result.next()) {
			return true;
		} else {
			return false;
		}

	}

	public void showBooks() throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from books");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println();
			System.out.println(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
					+ rs.getInt(4) + " " + rs.getDouble(5) + " " + rs.getInt(6));
		}
	}

	public boolean AddBook(String bc, String bname, String authorname, int pg, double price, int qty)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into books values(?,?,?,?,?,?)");
		ps.setString(1, bc);
		ps.setString(2, bname);
		ps.setString(3, authorname);
		ps.setInt(4, pg);
		ps.setDouble(5, price);
		ps.setInt(6, qty);

		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;
	}

	public boolean removeBooks(String bc) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from books where Book_Code = ?");
		ps.setString(1, bc);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0) {
			return true;
		} else {
			return false;
		}
	}

	

	public boolean logout() throws SQLException {
		conn.close();
		return true;
	}

}
