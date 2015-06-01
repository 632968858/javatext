package printn;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 打印从1到最大的n位十进制数
 * 
 */
public class PrintN {
	public static boolean increment(char[] num){
		int len =num.length;
		boolean overflow =false;   //是否溢出
		int takeover =0 ;  //是否进位
		int sum =0;
		for(int i =len-1;i>=0;i--){   //每一位的进位
			sum = num[i]-'0'+takeover;
			if(i==len-1)
				sum ++;
			if(sum>=10){  //有进位
				if(i==0){   //是否溢出
					overflow=true;
				}else{     
					takeover=1;
					sum =sum -10;
					num[i]=(char)('0'+sum);
				}
			}
			else{     //无进位跳出
				num[i]=(char)('0'+sum);
				break;
				
			}
		}
		return overflow;
	}
	public static void print(char[] num){
		boolean isbegin0=true;
		for(int i=0;i<num.length;i++){
			if(isbegin0&&num[i]!='0'){
				isbegin0=false;
			}
			if(!isbegin0){
				System.out.print(num[i]);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("n:"+n);
		if(n<=0){
			sc.close();
			return;
		}
	/*	char[] a ={'0','0','0','1','2','3'};
		print(a);*/
		char[] num =new char[n];
		Arrays.fill(num, 0, n, '0');
		while(!increment(num)){
			print(num);
			System.out.println("");
		}
		sc.close();
	}
}
