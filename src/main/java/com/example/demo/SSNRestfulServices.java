package com.example.demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import to.DatabaseConnection;
import to.Greeting;
import to.Message;
import to.SSNDetails;
import to.SuccessResponse;
import to.address;

@RestController
public class SSNRestfulServices {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    DatabaseConnection dataCon = new DatabaseConnection();

    @RequestMapping("/good_greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(method=RequestMethod.GET,value ="/getssn",produces="application/json")
    public ResponseEntity<String> SSNDetails(){
 
    	Gson gson = new Gson();
    	Connection connection = null;
    	ArrayList arr = new ArrayList();
    	try {
    		connection = dataCon.getConnection();
			Statement stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select  * from mortgage.ssn");  
			
			while(rs.next())  
		{	int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
		 String last_name= rs.getString("last_name");
		 String created_date= rs.getString("created_date");
		 String email= rs.getString("email");
		 String last_modified_date= rs.getString("last_modified_date");
		 String license= rs.getString("license");
		 String mobile_number= rs.getString("mobile_number");
		 String ssn= rs.getString("ssn");
		 int score_equifax= rs.getInt("score_equifax");
		 int score_experian= rs.getInt("score_experian");
		 int score_transunion= rs.getInt("score_transunion");
    	SSNDetails ssnd =new SSNDetails();
    	ssnd.setId(id);
    	ssnd.setCreated_date(created_date);
    	ssnd.setEmail(email);
    	ssnd.setFirst_name(first_name);
    	ssnd.setLast_modified_date(last_modified_date);
    	ssnd.setLast_name(last_name);
    	ssnd.setLicense(license);
    	ssnd.setMobile_number(mobile_number);
    	ssnd.setScore_equifax(score_equifax);
    	ssnd.setScore_experian(score_experian);
    	ssnd.setScore_transunion(score_transunion);
    	ssnd.setSsn(ssn);
		arr.add(ssnd);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
       
    	
        
    	return new ResponseEntity<> (gson.toJson(arr),HttpStatus.OK);
    }
    
   
   /* @RequestMapping(method=RequestMethod.POST, 
    value ="/postexample",consumes="application/json",produces="application/json")
    public ResponseEntity<String> postexample(@RequestBody Message msg) throws Exception{
    	Gson gson = new Gson();
        System.out.println("First Name = "+msg.getFirstName());
        System.out.println("Last Name  = "+msg.getLastName());
        //insert into tables
       
        
        return new ResponseEntity<> (gson.toJson(msg),HttpStatus.OK);
    }
   */
    
   @RequestMapping(method=RequestMethod.POST, value ="/registerssn",consumes="application/json",produces="application/json")
    public ResponseEntity<String> registerssn(@RequestBody SSNDetails ssnd)
    {
    	Gson gson = new Gson();
    	Connection connection = null;
    	String msg = null;
    	 int id=ssnd.getId();
    	String first_name = ssnd.getFirst_name();
    	 String last_name = ssnd.getLast_name();
    	 String created_date=ssnd.getCreated_date();
    	 String email=ssnd.getEmail();
    	 String last_modified_date=ssnd.getLast_modified_date();
    	 String license =ssnd.getLicense();
    	 String mobile_number=ssnd.getMobile_number();
    	 String ssn=ssnd.getSsn();
    	 int score_equifax=ssnd.getScore_equifax();
    	 int score_experian=ssnd.getScore_experian();
    	 int score_transunion=ssnd.getScore_transunion();
    	 
    	 System.out.println("values:::: "+ id+"::::"+first_name+"::::"+last_name+"::::"+created_date+"::::"+last_modified_date+"::::"+email+"::::"+license+"::::"
    	 +mobile_number+"::::"+ssn+"::::"+score_experian+"::::"+score_equifax+"::::"+score_transunion);
    	try
    	{
    	connection = dataCon.getConnection();
    	PreparedStatement prep = connection.prepareStatement("insert into ssn(id,first_name,last_name,created_date,last_modified_date,email,license,mobile_number,ssn,score_experian,score_equifax,score_transunion) values(?,?,?,?,?,?,?,?,?,?,?,?)");
       prep.setInt(1, id);
       prep.setString(2,first_name );
       prep.setString(3,last_name );
       prep.setString(4,created_date );
       prep.setString(5,last_modified_date );
       prep.setString(6,email );
       prep.setString(7,license );
       prep.setString(8,mobile_number );
       prep.setString(9,ssn );
       prep.setInt(10, score_experian);
       prep.setInt(11, score_equifax);
       prep.setInt(12, score_transunion);
       prep.executeUpdate();
    	msg = "registered successfully";
        }
   
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    		msg = "failure";
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		msg = "failure";
    	}
    	finally
    	{
    		try{
    			connection.close();
    			}
    		catch(SQLException e)
    		{
    		e.printStackTrace();
    		msg = "failure";
    		}
    		}
    		
    	
        return new ResponseEntity<> (msg,HttpStatus.OK);
}
   
   @RequestMapping(method = RequestMethod.GET, value ="/get_ssn/{id}" ,produces="application/json")
   public ResponseEntity<String> get_score(@PathVariable("id") int id)
   {
	   SSNDetails ssnd = new SSNDetails();
	   
	   Gson gson = new Gson();
	   String msg=null;
	   Connection connection = null;
	   
	   try
	   {
		   connection=dataCon.getConnection();
		   Statement stmt = connection.createStatement();
		   ResultSet rs = stmt.executeQuery("select first_name,last_name,ssn,email,score_experian,score_equifax,score_transunion from ssn where id =" +id );
		  
		  
		   while(rs.next())
		 {
			    
			   String first_name = rs.getString("first_name");
			   String last_name=rs.getString("last_name");
			   String ssn=rs.getString("ssn");
			   String email=rs.getString("email");
			   int score_transunion=rs.getInt("score_transunion");
			   int score_experian=rs.getInt("score_experian");
			   int score_equifax=   rs.getInt("score_equifax");
			  
			   ssnd.setFirst_name(first_name);
			   ssnd.setLast_name(last_name);
			   ssnd.setEmail(email);
			   ssnd.setSsn(ssn);
			   ssnd.setScore_equifax(score_equifax);
			   ssnd.setScore_experian(score_experian);
			   ssnd.setScore_transunion(score_transunion);
			   ssnd.setId(id);
			   msg = "SUCCESS";
		   }
		   
		 
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
	   return new ResponseEntity<> (gson.toJson(ssnd),HttpStatus.OK);
   }
    

   
@RequestMapping(method = RequestMethod.GET, value ="/validate/{ssn}" ,produces="application/json")
public ResponseEntity<String> get_score(@PathVariable("ssn") String ssn)
{
	   SSNDetails ssnd = new SSNDetails();
	   Gson gson = new Gson();
	   String msg=null;
	   Connection connection = null;
	   SuccessResponse sr = new SuccessResponse();
	   try
	   {
		   connection=dataCon.getConnection();
		   Statement stmt = connection.createStatement();
		   ResultSet rs = stmt.executeQuery("select * from ssn where ssn =" +ssn );
		  
		  
		   while(rs.next())
		 {
			    
			   String first_name = rs.getString("first_name");
			   String last_name=rs.getString("last_name");
			
			   String email=rs.getString("email");
			   int score_transunion=rs.getInt("score_transunion");
			   int score_experian=rs.getInt("score_experian");
			   int score_equifax=   rs.getInt("score_equifax");
			  
			   ssnd.setFirst_name(first_name);
			   ssnd.setLast_name(last_name);
			   ssnd.setEmail(email);
			   ssnd.setSsn(ssn);
			   ssnd.setScore_equifax(score_equifax);
			   ssnd.setScore_experian(score_experian);
			   ssnd.setScore_transunion(score_transunion);
			   
			   sr.setStatus("SUCCESS");;
			   sr.setSsndetails(ssnd);
		   }
		   
		 
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
 
@RequestMapping (method=RequestMethod.GET,produces="application/json",value="/update_ssn")
public ResponseEntity<String> update_ssn()
{
	SSNDetails ssnd=new SSNDetails();
	Gson gson=new Gson();
	String msg=null;
	Connection connection=null;
	try
	{
		
		connection = dataCon.getConnection();
		PreparedStatement prep = connection.prepareStatement("update ssn set score_transunion=? where id = ?");
		prep.setInt(1,770);
		prep.setInt(2,2);
		prep.executeUpdate();
		msg="ssn table is successfully updated";
		
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

	
	return new ResponseEntity<> (gson.toJson(msg),HttpStatus.OK); 
}


//Collection Example
@RequestMapping(method=RequestMethod.GET,value ="/getArray",produces="application/json")
public ResponseEntity<String> getArrayDetails(){

	Gson gson = new Gson();
	ArrayList arr = new ArrayList();
	arr.add("Hellow");
	arr.add("world");
	arr.add("chithra");
	arr.add("collection");
	//arr.stream().sorted().forEach(x->System.out.println(x)); // Or use Comparator
    return new ResponseEntity<> (gson.toJson(arr),HttpStatus.OK);
}

@RequestMapping(method=RequestMethod.GET,value ="/getHashSet",produces="application/json")
public ResponseEntity<String> getHashSetDetails(){

	Gson gson = new Gson();
	HashSet<String> hashSet = new  HashSet();
	hashSet.add("name");
	hashSet.add("name");
	hashSet.add("employer");
	hashSet.add("department");
    return new ResponseEntity<> (gson.toJson(hashSet),HttpStatus.OK);
}

@RequestMapping(method=RequestMethod.GET,value ="/getHashMap",produces="application/json")
public ResponseEntity<String> getHashMapDetails(){

	Gson gson = new Gson();
	Connection connection = null;
	HashMap<String, String> hashMap = new HashMap();
	hashMap.put("name","chithra");
	hashMap.put("employer","homedepot");
	hashMap.put("department","store");
    return new ResponseEntity<> (gson.toJson(hashMap),HttpStatus.OK);
}




@RequestMapping(method=RequestMethod.GET,value ="/getHashTable",produces="application/json")
public ResponseEntity<String> getHashTableDetails(){

	Gson gson = new Gson();
	Hashtable<String,String> hastable = new Hashtable();
	hastable.put("name","Selvan");
	hastable.put("employer","HD");
	hastable.put("department","Store");
    return new ResponseEntity<> (gson.toJson(hastable),HttpStatus.OK);
}


}