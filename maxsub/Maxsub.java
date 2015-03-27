package maxsub;
import java.util.Scanner;
public class Maxsub {
	public static int max_sub(int[] a){
		int b=0;
		int sum=0;
		for(int i=0;i<a.length;i++){
			b+=a[i];
			if(sum<b){
				sum=b;
			}
			else if(b<0){
				b=0;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int [] a=new int[10];
		Scanner sc =new Scanner(System.in);
		for(int i=0;i<a.length;i++){
			a[i]=sc.nextInt();
		}
		System.out.print(max_sub(a));
		sc.close();
	}
}
