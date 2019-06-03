package to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class java_example {
	public static void main(String[] args) {
		
		// ArrayList 
		ArrayList assList = new ArrayList();
		
		SSNDetails ssn1 = new SSNDetails();
		ssn1.setFirst_name("chithra");
		ssn1.setId(1);
		
		SSNDetails ssn2 = new SSNDetails();
		ssn2.setFirst_name("kalaiselvan");
		ssn2.setId(2);

		assList.add(ssn1.toString());
		assList.add(ssn2.toString());
		
		System.out.println("ArrayList"+ assList);
		
		for (int i = 0; i < assList.size(); i++) {
			System.out.println("for loop"+ assList.get(i));
		}
		
		for (Object object : assList) {
			System.out.println("For Each::"+ object);
		}
		
		assList.stream().forEach(x-> System.out.println("stream and lamda ::"+ x));
		
		
		
		// HashMap (key, value)
		
		SSNDetails ssn4 = new SSNDetails();
		ssn4.setFirst_name("chithra");
		ssn4.setId(4);
		
		SSNDetails ssn3 = new SSNDetails();
		ssn3.setFirst_name("kalaiselvan");
		ssn3.setId(3);
		
		HashMap hashMap = new HashMap();
		hashMap.put("primarykey1", ssn4);
		
		hashMap.put("primaryKey2", ssn3);
		
		System.out.println("HashMap:::" + hashMap.get("primarykey1"));
	
		hashMap.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		Iterator iterator = hashMap.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String,SSNDetails> entry = (Entry<String, SSNDetails>) iterator.next();
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }
		
		
	}

}
