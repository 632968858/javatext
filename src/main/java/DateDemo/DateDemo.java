package DateDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class DateDemo {
public static void main(String[] args) throws ParseException {
	Date d=new Date();
	long now =d.getTime();
	Scanner sc =new Scanner(System.in);
	String my=sc.nextLine();
	SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
	Date myd =df.parse(my);
	long myt =myd.getTime();
	System.out.println((now-myt)/1000/60/60/24);
	sc.close();
}
}
