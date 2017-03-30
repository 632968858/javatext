package list;

public class ReplaceBlank {
	
	public void replaceblank(char[] s,int max){
		if(s==null&&max<=0)
			return;
		int length,count =0;
		for(length=0;s[length]!='\0';length++){
			if(s[length]==' '){
				count++;
			}
		}
		System.out.println("count:"+count);
		System.out.println("length:"+length);
		int p=length;
		int q=length+count*2;
		if(q>max)
			return;
		
		while(p>=0&&q>p){
			if(s[p]==' '){
				s[q--]='0';
				s[q--]='2';
				s[q--]='%';
				p--;
			}else{
				s[q--]=s[p--];
			}
			
		}
		
		/*for(int i=0;i<s.length;i++){
			
		}
	
		System.out.println(count);
		for(int i=size,j=size+2*count;i>=0;i--,j--){   /////////   /0  i--和j--此处的问题要注意，此处出错
			if(s[i]==' '){
				s[j--]='0';
				s[j--]='2';
				s[j--]='%';
				i--;      /////////////////////填充完之后指向非空
			}else{
				s[j]=s[i];
				//System.out.println(s[j]);
			}
		}*/
		
	}
	public static void main(String[] args) {
		int max=100;
		char [] s=new char[max];
		 char[] s1 = " we have a dream ".toCharArray();
		 int size=0;
		 for(char c : s1){
			 s[size++]=c ;
		 }
		 System.out.println("size:"+size);
		ReplaceBlank rb= new ReplaceBlank();
		rb.replaceblank(s,max);
		System.out.println(s);
		
	}
}
