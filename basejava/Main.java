package basejava;

import java.util.Scanner;

public class Main {
	public static String toMoreLowCase(String s){
		
		int max=s.length();
		int j=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
				max++;
		}
		char [] c =new char [max];
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
			{
				c[j++]=(char)((int)s.charAt(i)+32);
				c[j++]=(char)((int)s.charAt(i)+32);
			}else{
				c[j++]=s.charAt(i);
			}
		}
		String s1= new String (c);
		return s1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] s = new String[t];
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			s[i] = sc.nextLine();
		}
		System.out.println("输入为：");
		for(String s3 :s){
			System.out.println(s3);
		}
		for (int j = 0; j < t; j++) {
			System.out.println("变化为：");
			String s1 = toMoreLowCase(s[j]); // 变小
			System.out.println(s1);
			System.out.println(s1.length());
			int i=0;
			int temp=1;
			int sum = 0;
			while(i<s1.length()-1){
				if((i+1)<s1.length()-1){
					if(s1.charAt(i)==s1.charAt(i+1)){
						temp++;
						System.out.println("temp："+temp);
					}else{
						sum+=((int)s1.charAt(i)-'a'+1)*Math.pow(temp,temp);
						temp=1;
					}
			
				}else{
					if(s1.charAt(i)==s1.charAt(i+1))
						{
							temp++;
							sum+=((int)s1.charAt(i)-'a'+1)*Math.pow(temp,temp);
						}
						else{
							sum+=((int)s1.charAt(i)-'a'+1)*Math.pow(temp,temp)+((int)s1.charAt(i+1)-'a'+1);
							}
					System.out.println(sum);
						}
				i++;	
			}
			}
		sc.close();
		}
}