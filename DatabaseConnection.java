package com.sachin;

import java.sql.*;

public class DatabaseConnection {
	static final String DB_URL = "jdbc:mysql://localhost/ibank";
	static final String USERNAME = "root";
	static final String PASSWORD = "Sachinsoam@1999";
	Connection connection = null;

	public String[] getCustomerDetails(String query) {
		ResultSet rs;
		String[] details = null;
		try {
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {

				details = new String[13];
				details[0] = rs.getString("full_name");
				details[1] = rs.getString("email");
				details[2] = rs.getString("address");
				details[3] = rs.getString("phone_num");
				details[4] = rs.getString("gender");
				details[5] = rs.getString("account_num");
				details[6] = rs.getString("account_type");
				details[7] = rs.getString("dob");
				details[8] = rs.getString("adhaar_num");
				details[9] = rs.getString("pan");
				details[10] = rs.getString("balance");
				details[11] = rs.getString("last_login_date");
				details[12] = rs.getString("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return details;
	}

	public int update(String query) {
		int updateCount = 0;
		try {
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			updateCount = stmt.getUpdateCount();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCount;
	}

	public String[][] getTransactionHistory(String query) {
		ResultSet rs;
		String[][] transactionHistory = null;
		try {
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(query);
			rs.last();
			if (rs.getRow() != 0) {
				transactionHistory = new String[rs.getRow()][4];
				rs.beforeFirst();
				while (rs.next()) {
					String[] data = {
							rs.getString("id"),
							rs.getString("date"),
							rs.getString("amount"),
							rs.getString("type")
					};
					transactionHistory[rs.getRow() - 1] = data;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transactionHistory;
	}

}
