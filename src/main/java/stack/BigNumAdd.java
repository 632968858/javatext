package stack;

public class BigNumAdd {
	public LinkStack numsplit(String s) throws Exception {
		if (s != null) {
			LinkStack ls = new LinkStack();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == ' ') {
					continue;
				} else if (c > '9' || c < '0') {                 
					throw new Exception("输入错误1");
				} else
					ls.push(Integer.valueOf(String.valueOf(c)));   /////////////Integer
			}
			return ls;
		}else
			throw new Exception("输入错误2");

	}
	public void add(String s1,String s2)throws Exception{
		LinkStack l1=numsplit(s1);
		LinkStack l2=numsplit(s2);
		LinkStack l=new LinkStack();
		boolean flag=false; //进位标志
		while(!l1.isEmpty()&&!l2.isEmpty())
		{
			int i1=Integer.valueOf(l1.pop().toString());
			int i2=Integer.valueOf(l2.pop().toString());
			int sum=i1+i2;
			if(flag){
				sum++;
				flag=false; //////////////////////////注意置进位为0
			}
			if(sum>=10){  /////////////////////////还有等于
			sum=sum%10;
			flag=true;
			}
			l.push(sum);
		}
		LinkStack temp=!l1.isEmpty()?l1:l2;
		while(!temp.isEmpty()){
			int i1=Integer.valueOf(temp.pop().toString());
			if(flag){
					i1++;
					flag=false; ///////进位之后置0
			}
			if(i1>=10){  /////////////////////////还有等于
				i1=i1%10;
				flag=true;
			}
			l.push(i1);
		}
		
		if(flag){
			l.push(String.valueOf(1));
		}
		while(!l.isEmpty()){
			System.out.print(l.pop()+" ");
		}
	}

	public static void main(String[] args) throws Exception {
		BigNumAdd bna = new BigNumAdd();
		System.out.println("两个大数相加为" );
		bna.add("18 452 543 389 943 209 752 345 473","8 123 542 678 432 986 899 334");
	}
}
