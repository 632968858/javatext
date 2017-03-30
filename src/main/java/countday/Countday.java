package countday;

import java.util.Scanner;

public class Countday {
	public static void main(String[] args) {
		int year;
		int month;
		int day;
		int sum=0;
		Scanner sc=new Scanner(System.in);
		int [][] dayofmonth={
				{31,28,31,30,31,30,31,31,30,31,30,31}, //闰月 
				{31,29,31,30,31,30,31,31,30,31,30,31}
				};
		System.out.println("input like 1990 7 23");
		year=sc.nextInt();
		month=sc.nextInt();
		day=sc.nextInt();
		int [] dayofm=dayofmonth[((year%4==0&&year%100!=0)||year%400==0)?0:1];//闰月为0
		for(int i=0;i<month-1;i++){
		 sum += dayofm[i];
		}
		sum+=day;
		System.out.println(sum);
		sc.close();
		
		
	}
}
