package com.booksLandApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserOperation {
	DBConnectivity db = new DBConnectivity();
	Connection conn = db.dbconnection();

	public boolean signUp(String us, String pass, String name, String address, String lm, long mob, String em)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into user_details values(?,?,?,?,?,?,?)");
		ps.setString(1, us);
		ps.setString(2, pass);
		ps.setString(3, name);
		ps.setString(4, address);
		ps.setString(5, lm);
		ps.setLong(6, mob);
		ps.setString(7, em);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;

	}

	public boolean login(String username, String password) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from user_details where user_name=? && password=?");
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


	public boolean buyNow(String bc, String bn, int qty, String address) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into order_details values(?,?,?,?)");
		ps.setString(1, bc);
		ps.setString(2, bn);
		ps.setInt(3, qty);
		ps.setString(4, address);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;
	}

	public boolean profileSetting(String us, String pass, String name, String add, String lm, long num, String em)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into user_details values(?,?,?,?,?,?,?)");
		ps.setString(1, us);
		ps.setString(2, pass);
		ps.setString(3, name);
		ps.setString(4, add);
		ps.setString(5, lm);
		ps.setLong(6, num);
		ps.setString(7, em);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;
	}
public void orederStatus() throws SQLException {
	PreparedStatement ps = conn.prepareStatement("select * from order_details");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		System.out.println();
		System.out.println(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "+ rs.getInt(4));
}
}
	public boolean logout() throws SQLException {
		conn.close();
		return true;
	}
}
