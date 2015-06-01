package basejava;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*测试java语法*/
public class BaseJava {
	static {
		System.out.println("basejava");
	}
	public static void test(String s) {
		s = "no";

	}

	public static void main(String[] args) throws IOException {
		/*
		 * 
		 * 
		 * Integer 缓存池 -128--127
		 * 
		 */
		Integer i1=127;
		Integer i2=127;
		System.out.println(i1==i2);
		
		Integer i3=128;
		Integer i4=128;
		System.out.println(i3==i4);
		/*
		 * scanner 输完int，再输String 出现问题
		 */
		Scanner sc1 =new Scanner (System.in);
		String is=sc1.nextLine();
		String s21=sc1.nextLine();
		
		System.out.println(Integer.parseInt(is));
		System.out.println(s21);
		
		System.out.println("------------------------------------------------------");
		
		//int------String
		//String-----int
		String s1 ="100";
		int i = 10;
		String stringtoint=String.valueOf(i);
		int inttoString=Integer.parseInt(s1);
		
		char [] c=s1.toCharArray();
		for(char c1:c){
			if(Character.isLowerCase(c1))
				System.out.println("low2"+c1);
			else if(Character.isUpperCase(c1))
				System.out.println("up"+c1);
			else if(Character.isDigit(c1))
				System.out.println("num"+c1);
		}
		
		
		
		
		String s = "hello string ";
		System.out.println(s);
		test(s);
		System.out.println(s);
		System.out.println((int) 'a');
		System.out.println((int) 'A');
		
		Scanner sc =new Scanner(System.in);
		String sr=sc.nextLine();
		//sc.close();
		System.out.println("scnner"+sr);
		BufferedReader bfr =new BufferedReader(new InputStreamReader(System.in));
		s=bfr.readLine();
		System.out.println("BufferedReader"+s);
	//	bfr.close();
	/*	BufferedInputStream bfi=new BufferedInputStream(System.in);
		InputStream is=new InputStream(System.in);
		is.re*/
		
		
	}
}
