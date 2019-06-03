package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import to.DatabaseConnection;
import to.SuccessResponse;
import to.bank_account;
import to.credit_card;

public class CreditCardRestfulServices {

	
	DatabaseConnection dataCon = new DatabaseConnection();
	
	@RequestMapping (method=RequestMethod.POST,value ="/add_Account",consumes="/application/json",produces="application/json")
	public ResponseEntity<String> add_Account(@RequestBody credit_card cc)
	{
	Connection connection=null;
	Gson gson=new Gson();
	SuccessResponse sr= new SuccessResponse();
	String msg = null;
	String name=cc.getName();
	String cc_no=cc.getCc_no();
	String cc_type=cc.getCc_type();
	float credit_limit=cc.getCredit_limit();
	float cash_limit = cc.getCash_limit();
	float available_limit = cc.getAvailable_limit()  ;
	String ssn =cc.getSsn();
	String cvv = cc.getCvv();
	String expiry_date = cc.getExpiry_date();
	String account_type = cc.getAccount_type();
    String created_date =cc.getCreated_date();
    String last_modified_date=cc.getLast_modified_date();
	String status=cc.getStatus();
	int user_id=cc.getUser_id();
	try
	{
		connection = dataCon.getConnection();
	PreparedStatement prep = connection.prepareStatement("insert into credit_card(name,ssn,cc_no,cc_type,ccv,expiry_date,credit_limit,cash_limit,available_limit,account_type,created_date,last_modified_date,status,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	prep.setString(1, name);
	prep.setString(2, ssn);
	prep.setString(3, cc_no);
	prep.setString(4, cc_type);
	prep.setString(5, cvv);
	prep.setString(6, expiry_date);
	prep.setFloat(7, credit_limit);
	prep.setFloat(8, cash_limit);
	prep.setFloat(9, available_limit);
	prep.setString(10, account_type);
	prep.setString(11, created_date);
	prep.setString(12, last_modified_date);
	prep.setString(13, status);
	prep.setInt(14, user_id);
	prep.executeUpdate();
	
	sr.setStatus("informations are inserted successfully");

	}
	catch(ClassNotFoundException e)
	{
e.printStackTrace();
msg="failure";
	}
catch(SQLException e)
	{
e.printStackTrace();
msg="failure";

	}
finally
{
	try
	{
		connection.close();
	}
	catch(SQLException e)
	{
e.printStackTrace();
msg="failure";
	}
}
	
		return new ResponseEntity<> (gson.toJson(sr),HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value = "/get_Account/{ssn}",produces="application/json")
	public ResponseEntity<String> get_Account(@PathVariable ("ssn") String ssn) throws ClassNotFoundException
	{
		
		Gson gson =new Gson();
		Connection connection =null;
		SuccessResponse sr;
		String msg;
		credit_card cc =new credit_card();
		try
		{
			connection = dataCon.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select name,cc_type,cc_no,available_limit from credit_card where ssn="+ssn);
			
		while(rs.next())
		{
		String	name=rs.getString("name");
		String cc_type=rs.getString("cc_type");
		String cc_no=rs.getString("cc_no");
		float available_limit=rs.getFloat("available_limit");
		
		
		cc.setName(name);
		cc.setCc_type(cc_type);
		cc.setCc_no(cc_no);
		cc.setAvailable_limit(available_limit);
		
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			msg="Failure";
			
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				msg="Failure";
				
			}
		}
		
		return new ResponseEntity<> (gson.toJson(cc),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value ="/validate_Account",consumes="application/json",produces="application/json")
	public ResponseEntity<String> validate_Account(@RequestBody credit_card cc) throws ClassNotFoundException
	{
		
		Connection connection= null;
		Gson gson=new Gson();
		SuccessResponse sr;
		String msg;
		String name = cc.getName();
		String cc_no=cc.getCc_no();
		String cc_type=cc.getCc_type();
		String result = null;
		try{
			
			connection=dataCon.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select name,cc_no,cc_type, from credit_card");
		
		while(rs.next())
		{
			String name1 = rs.getString("name");
			String cc_no1=rs.getString("cc_no");
			String cc_type1=rs.getString("cc_type");
			if(name.equals(name1) && cc_no.equals(cc_no1) && cc_type.equals(cc_type1))
			{
				result = "validated successfully";
			}
		}
		
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			msg ="failure";
			
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				msg ="failure";
			}
		}
		
		return new ResponseEntity<> (result,HttpStatus.OK);
		
		
	}
	
}
