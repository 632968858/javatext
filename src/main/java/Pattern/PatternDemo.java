package Pattern;

import java.util.Scanner;

/*
 * 判断手机号码
 * .表示本点\.
 */
public class PatternDemo {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s=sc.nextLine();
		String regex="[1-9]\\d{10}";//号码
		String regex2="\\w+@\\w+(\\.\\w+)+";
		System.out.println(s.matches(regex2));
	}
}
