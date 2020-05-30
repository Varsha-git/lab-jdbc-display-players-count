package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager
{
	
	public static Connection getConnection() throws Exception 
	{
		//System.out.println("into get connection");
		Properties properties;
		properties = loadPropertiesFile();
		final String driver=properties.getProperty("driver");
		final String url=properties.getProperty("url");
		final String username=properties.getProperty("username");
		final String password=properties.getProperty("password");
		//System.out.println(username);
		//System.out.println(password);
		Class.forName(driver);
		Connection con = null;
		//System.out.println("bfore driver manager");
		con = DriverManager.getConnection(url, username, password);
		
		if(con != null)
			System.out.println("Connection Established");
		else
			System.out.println("check again");
		return con;
}
	
	 public static Properties loadPropertiesFile() throws Exception
	 {
		 Properties prop = new Properties();
		 InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		 prop.load(in);
		 in.close();
		 return prop; 
	} 
}
