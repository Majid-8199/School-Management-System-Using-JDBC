package dbconnnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	String driver="com.mysql.cj.jdbc.Driver";
	String username="root";
	String password="root";
	String url="jdbc:mysql://localhost:3306/school_management_system";
	Connection connection;
	
	public DBConnection() {
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public Connection getConnection() {
        return connection;
    }
}
