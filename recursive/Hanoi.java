package recursive;
/*递归应用汉诺塔
 * */
public class Hanoi {
	private int count=0;
	public void hanoi(int n, char x,char y,char z)// n个盘从x移动到z，y为辅助
	{
		if(n==1)
		{
			move(1,x,z);
		}else
		{
			hanoi(n-1,x,z,y);
			move(n,x,z);
			hanoi(n-1,y,x,z);
		}
	}
	public void move(int n,char x,char y) //编号为n的从x到z
	{
		System.out.println("第"+(++count)+"次："+"    "+n+"号"+"从"+x+"->"+y);
	}
	public static void main(String[] args) {
		Hanoi h=new Hanoi();
		h.hanoi(3,'x','y','z');
	}
}
