package BinaryDemo;

import java.util.Scanner;

/*
 * 测试整数二进制表示时1出现的次数
 */
public class CountOne {
	public int count(int target){
		int count=0;
		while(target!=0){
			count ++;
			target =(target-1)&target;
		}
		return count;
	}
	//判断一个整数是不是2的整数次方
	public boolean isTwoPower(int n){
		n = (n-1)&n;
		return (n!=0)?false:true;
	}
	//输入两个数m,n计算需要改变m的二进制表示中的多少位才能得到n
	public int chage(int m,int n){
		int temp = m^n;     //异或，同0反1 ，得到不同位数
		return count(temp);  //求有多少个1 ，即为需要改变的位数
	}
	public static void main(String[] args) {
		CountOne co =new CountOne();
		Scanner sc =new Scanner (System.in);
		int target = sc.nextInt();
		int count =co.count(target);
		System.out.println("target的整数二进制表示时1出现的次数:"+count);
		System.out.println("target是2的整数次方:"+co.isTwoPower(target));
		
		sc.close();
	}
	
}
