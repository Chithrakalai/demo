package to;

	import java.util.Date;
	import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonInclude;

	//@XmlRootElement       //only needed if we also want to generate XML
	public class Message {
	    
		
		
	   private String firstName;
	    
	    private String lastName;
	    
	   
	    
	 
	    public String getFirstName() {
	        return firstName;
	    }
	 
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	 
	    public String getLastName() {
	        return lastName;
	    }
	 
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	 
	    
	    
	}


