package com.hundsun.elearning;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private List<Connection> connectionPool;
	private int MAX_POOL_SIZE = 10;
	private String connectionString;
	private String username;
	private String password;

	public ConnectionPool(String connectionString, String username, String password) {
		this.connectionString = connectionString;
		this.username = username;
		this.password = password;
		connectionPool = new ArrayList<>();
	}

	public synchronized Connection getConnection() throws SQLException {
		if (connectionPool.size() > 0) {
			return connectionPool.remove(0);
		}
		return createConnection();
	}

	public synchronized void releaseConnection(Connection connection) throws SQLException {
		if (connectionPool.size() < MAX_POOL_SIZE) {
			connectionPool.add(connection);
		} else {
			connection.close();
		}
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(connectionString, username, password);
	}

	public static void main(String strings[]) {
		ConnectionPool pool = new ConnectionPool("jdbc:mysql://106.52.36.171:3306/zky", "zky", "XSHx4bLCaxsj5WCc");

		try (Connection connection = pool.getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM mytable WHERE id = ?");) {
			statement.setInt(1, 123);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// do something with the result
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
