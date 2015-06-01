package MathDemo;

import java.util.Scanner;

/*
 * 任意数之间的随机数
 * 
 */
public class RandomDemo {
	public static int getRandom(int start,int end){
		return (int)(Math.random()*(end-start+1))+start;
		
	}
	public static void main(String[] args) {
	Scanner sc =new Scanner (System.in);
	int start =sc.nextInt();
	int end =sc.nextInt();
	for(int i=0;i<10;i++){
	System.out.println(getRandom(start,end));
}
	}
}

