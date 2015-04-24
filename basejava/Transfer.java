package basejava;

public class Transfer {
	public int transfer(String s){
		int sum=0;
		int count=1;
		System.out.println(s.length());
		for(int i=s.length()-1;i>=0;i--)
		{
			
			char c =s.charAt(i);
			if(c>='a'&&c<='f')
			{
				sum+=((c-'a')+10)*count;
			}
			if(c>='A'&&c<='F')
			{
				sum+=((c-'A')+10)*count;
			}
			if(c>='0'&&c<='9')
			{
				sum+=((c-'0'))*count;
			}
			count*=16;
		}
		return sum;
	}
	public static void main(String[] args) {
		String s ="119";
		Transfer t =new Transfer();
		System.out.println(t.transfer(s));
		
	}

}
