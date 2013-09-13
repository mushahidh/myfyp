package database;

import java.io.FileInputStream;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Database {
private Connection connection;

public Connection connection()  {

	String url="jdbc:mysql://localhost:3306/fyp";
	String uName="root";
	String pwd="root";
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection=DriverManager.getConnection(url,uName,pwd);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return connection;

/*



	Properties prop = new Properties();
    System.out.println("test");
    try {
		prop.load(new FileInputStream(System.getProperty("user.home") + "/mydb.cfg"));
	    System.out.println("user.home: "+System.getProperty("user.home"));
	    String host = prop.getProperty("host").toString();
	    String username = prop.getProperty("username").toString();
	    String password = prop.getProperty("password").toString();
	    String driver = prop.getProperty("driver").toString();

	   

	    Class.forName(driver);
	    System.out.println("--------------------------");
	    System.out.println("DRIVER: " + driver);
	    connection = DriverManager.getConnection(host, username, password);
	    System.out.println("CONNECTION: " + connection);
    }
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


return connection;
*/


}

public void getResource()
	{
		 try {
				connection.close();
			} catch (SQLException e) {
				
				
			}
	}

}