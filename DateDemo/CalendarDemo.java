package DateDemo;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 给定年份求该年份的二月有多少天
 */
public class CalendarDemo {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int year=Integer.parseInt(sc.nextLine());
	Calendar cl =Calendar.getInstance();
	cl.set(year, 2, 1);
	cl.add(Calendar.DATE, -1);
	System.out.println(cl.get(Calendar.DATE));
	sc.close();
	
}
}
