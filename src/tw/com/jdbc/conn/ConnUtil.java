package tw.com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtil {
	
	private Connection conn;

	public Connection createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=Pets;user=watcher;password=p@ssw0rd;encrypt=true;trustServerCertificate=true";
		conn = DriverManager.getConnection(urlstr);
		System.out.println("FileInput Connection Status:" + !conn.isClosed());
		return conn;
	}
	
	public void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		System.out.println("FileInput Connection1 Closed");
	}
	
	
}
