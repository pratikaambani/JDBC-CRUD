package dbconnection;

import java.sql.*;

public class ConnectionProvider	{
	private static Connection con = null;
	
	public static Connection getConnection() {
		if (con != null) {
			return con;
		}
		
		try	{
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@192.168.106.87:1521:ORA11G";
			String user = "pratik";
			String password = "pratik";
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch (SQLException sqle) {
			System.out.println(sqle);
		}
		return con;
	}
}