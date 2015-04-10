package basejava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class TestHashSet {
	 public static void main(String[] args) {  
	        Set<String> set = new HashSet<String>();  
	        set.add("one");  
	        set.add("two");  
	        set.add("three");  
	        set.add("four");  
	        set.add("five");  
	        for (Iterator<String> it = set.iterator(); it.hasNext();) {  
	            System.err.println(it.next());  
	        }  
	    }  
}
