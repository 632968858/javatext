package reflect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Property {
public static void main(String[] args) throws IOException, Exception {
	Properties p=new Properties();
	BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream("config.txt")));
	p.load(reader);
	
	String className =p.getProperty("ClassName");
	String method =p.getProperty("Method");
	
	Class c =Class.forName(className);
	
	Object object =c.getDeclaredConstructor().newInstance();
	
	Method m1 =c.getDeclaredMethod(method);
	m1.invoke(object);
	
	
}
}
