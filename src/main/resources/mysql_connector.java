

import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class mysql_connector {
	
	public static void main(String args[]) throws ClassNotFoundException{  
	try{  
	Class.forName("com.mysql.cj.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/mortgage","root","admin");  
	
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from mortgage.address");  
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	con.close();  
	}catch(SQLException e){ System.out.println(e);}  
	}  
	}  

