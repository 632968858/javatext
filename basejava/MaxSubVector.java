package basejava;

import java.util.Scanner;
/*最大子数组
 * 
 * */

public class MaxSubVector {
	public static int  sub(int [] a){
		int b=0;
		int sum=0;
		int i=0;
		while(i<a.length){
			if(b<=0){
				b=a[i];
			}else
				b+=a[i];
			if(sum<b)
				{sum=b;
				
				System.out.print(sum+" ");
				}
			i++;
		}
		return sum;
	}
	
	public static void main(String[] args) {
	//	Scanner sc = new Scanner(System.in);
		//int n=sc.nextInt();
		int []a={1,-8,6,3,-1,5,7,-2,0,1};
		/*for(int i =0;i<n;i++){
			a[i]=sc.nextInt();
		}*/
		System.out.println(sub(a));
		//sc.close();
	}

}
