package huiwensushu;

public class Huiwensushu {
/*
 *	判断11到999的回文素数
 **/
	public static boolean isPrime(int n){
		for (int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	public static boolean isHuiwen(int n){
		int temp=n;
		int sum=0;
		int b=0;
		while(temp!=0){
			b=temp%10;
			temp=temp/10;
			sum=sum*10+b;
		}
		return sum==n;
	}
	public static void main(String[] args) {
	for(int i=11; i<999;i++)
	{
		if(isPrime(i)&&isHuiwen(i))
			System.out.print(" "+i);
	}
}
}
