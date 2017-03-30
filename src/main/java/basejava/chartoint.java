package basejava;

public class chartoint {
public static void main(String[] args) {
	char c= 'A';
	int [] a =new int [256];
	a[c]=1;
	for(int i=0; i<256;i++)
		if(a[i]==1)
			System.out.print((char)i);
	System.out.println((int)c);
}
}
