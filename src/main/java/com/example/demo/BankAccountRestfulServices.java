package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import to.*;

import com.google.gson.Gson;

@RestController
public class BankAccountRestfulServices {
	
	DatabaseConnection dataCon = new DatabaseConnection();
	
	@RequestMapping(method=RequestMethod.POST,value="/addAccount",consumes="application/json",produces="application/json")
public ResponseEntity<String> addAccount(@RequestBody bank_account bank)
{
		Gson gson=new Gson();
		SuccessResponse sr= new SuccessResponse();
		Connection connection=null;
		String msg;
		String name = bank.getName();
		String ssn = bank.getSsn();
		String account_no = bank.getAccount_no();
		String account_type = bank.getAccount_type();
		String routing_no = bank.getRouting_no();
		String status = bank.getStatus();
		float amount = bank.getAmount();
		
		try
		{
			connection = dataCon.getConnection();
			PreparedStatement prep = connection.prepareStatement("insert into bank_account(name,ssn,account_no,routing_no,account_type,status,amount) values(?,?,?,?,?,?,?)");
		prep.setString(1, name);
		prep.setString(2, ssn);
		prep.setString(3, account_no);
		prep.setString(4, routing_no);
		prep.setString(5, account_type);
		prep.setString(6, status);
		prep.setFloat(7, amount);
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
		
		return new ResponseEntity<>(gson.toJson(sr),HttpStatus.OK);
}
	
	@RequestMapping(method=RequestMethod.GET,value = "/getAccount/{account_no}",produces="application/json")
	public ResponseEntity<String> getAccount(@PathVariable ("account_no") String account_no) throws ClassNotFoundException
	{
		
		Gson gson =new Gson();
		Connection connection =null;
		SuccessResponse sr;
		String msg;
		bank_account bank= new bank_account();
		try
		{
			connection = dataCon.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select name,ssn,account_type,routing_no,amount from bank_account where account_no="+account_no);
			
		while(rs.next())
		{
		String	name=rs.getString("name");
		String ssn =rs.getString("ssn");
		String account_type=rs.getString("account_type");
		String routing_no=rs.getString("routing_no");
		float amount=rs.getFloat("amount");
		
		
		bank.setName(name);
		bank.setAccount_type(account_type);
		bank.setSsn(ssn);
		bank.setRouting_no(routing_no);
		bank.setAmount(amount);
		
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
		
		return new ResponseEntity<> (gson.toJson(bank),HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value ="/validateAccount",consumes="application/json",produces="application/json")
	public ResponseEntity<String> validateAccount(@RequestBody bank_account bank) throws ClassNotFoundException
	{
		
		Connection connection= null;
		Gson gson=new Gson();
		SuccessResponse sr;
		String msg;
		String name = bank.getName();
		String account_no=bank.getAccount_no();
		String routing_no=bank.getRouting_no();
		String result = null;
		try{
			
			connection=dataCon.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select name,account_no,routing_no from bank_account");
		
		while(rs.next())
		{
			String name1 = rs.getString("name");
			String account_no1=rs.getString("account_no");
			String routing_no1=rs.getString("routing_no");
			if(name.equals(name1) && account_no.equals(account_no1) && routing_no.equals(routing_no1))
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
	@RequestMapping(method=RequestMethod.PUT,value ="/validateAccountAmount",consumes="application/json",produces="application/json")
	public ResponseEntity<String> validateAccountAmount(@RequestBody bank_account bank) throws ClassNotFoundException
	{
		
		Connection connection= null;
		Gson gson=new Gson();
		SuccessResponse sr;
		String msg;
		String name = bank.getName();
		String account_no=bank.getAccount_no();
		String routing_no=bank.getRouting_no();
		float amount =bank.getAmount();
		String result = null;
		try{
			
			connection=dataCon.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select name,account_no,routing_no,amount from bank_account");
		
		while(rs.next())
		{
			String name1 = rs.getString("name");
			String account_no1=rs.getString("account_no");
			String routing_no1=rs.getString("routing_no");
			float amount1=rs.getFloat("amount");
			if(name.equals(name1) && account_no.equals(account_no1) && routing_no.equals(routing_no1))  
			{
				if(amount<=amount1)
				{
				result = "validated the amount successfully";
				}
				else
				{
					result="Account is not having sufficient amount";
				}
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
	
	@RequestMapping(method=RequestMethod.PUT,value ="/debitAmount",consumes="application/json",produces="application/json")
	public ResponseEntity<String> debitAmount(@RequestBody bank_account bank) throws ClassNotFoundException
	{
		
		Connection connection= null;
		Gson gson=new Gson();
		SuccessResponse sr;
		String msg;
		String name = bank.getName();
		String account_no=bank.getAccount_no();
		String routing_no=bank.getRouting_no();
		float amount1=bank.getAmount();
		String result = null;
		float amount = 0;
		try{
			
			connection=dataCon.getConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs = stmt.executeQuery("select amount from bank_account");
		while(rs.next())
		{
			float amount2=rs.getFloat("amount");
			if(amount2 != 0)
			{
				amount=amount2-amount1;
			}
		PreparedStatement prep = connection.prepareStatement("update bank_account set amount=? where name =?");	
		prep.setFloat(1, amount);
		prep.setString(2, name);
		prep.executeUpdate();
				result = "Amount is debited successfully";
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

	@RequestMapping(method=RequestMethod.PUT,value ="/depositAmount",consumes="application/json",produces="application/json")
	public ResponseEntity<String> depositAmount(@RequestBody bank_account bank) throws ClassNotFoundException
	{
		
		Connection connection= null;
		Gson gson=new Gson();
		SuccessResponse sr;
		String msg;
		String name = bank.getName();
		String account_no=bank.getAccount_no();
		String routing_no=bank.getRouting_no();
		float amount1=bank.getAmount();
		String result = null;
		float amount = 0;
		try{
			
			connection=dataCon.getConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs = stmt.executeQuery("select amount from bank_account");
		while(rs.next())
		{
			float amount2=rs.getFloat("amount");
			if(amount2 != 0)
			{
				amount=amount1+amount2;
			}
		PreparedStatement prep = connection.prepareStatement("update bank_account set amount=? where name =?");	
		prep.setFloat(1, amount);
		prep.setString(2, name);
		prep.executeUpdate();
				result = "Amount is deposited successfully";
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
