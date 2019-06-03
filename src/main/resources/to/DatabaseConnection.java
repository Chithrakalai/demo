package to;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	
	public Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/mortgage","root","admin");  
			
             return con;
			}catch(SQLException e){ System.out.println(e);
			
			}  
			
	 
	       return con;
	}

}
