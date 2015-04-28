package basejava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	  String s1 = new StringBuilder("计算机").append("软件").toString();
	  System.out.println("s1"+s1.intern()==s1);
	  String s2 =new StringBuilder("ja").append("va").toString();
	  System.out.println(s2.intern()==s2);
	  List<String> list = new ArrayList<String>();
	  int i=0;
	  while(true){
		  list.add(String.valueOf(i++).intern());
	  }
	        		
	 }
	 
}
