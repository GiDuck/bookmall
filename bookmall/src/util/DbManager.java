package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

	private static volatile DbManager dbManaer = new DbManager();

	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookmall";
	private final String DB_ID = "bookmall";
	private final String DB_PWD = "bookmall";

	public Connection conn;

	private DbManager() {
		super();
		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_ID, DB_PWD);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static DbManager getInstance() {

		if (dbManaer == null) {

			synchronized (DbManager.class) {

				if (dbManaer == null) {
					dbManaer = new DbManager();
				}

			}

		}

		return dbManaer;

	}

	public Connection getConnection() {

		try {
			return DriverManager.getConnection(JDBC_URL, DB_ID, DB_PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
