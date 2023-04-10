package in.astro.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	static {
		// Step 1: load and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws IOException, SQLException {
		FileInputStream fis = new FileInputStream("C:\\Users\\pande\\Documents\\eclipse-workspace\\servletprgms\\LibraryManagementSystem\\src\\main\\java\\in\\astro\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
}
