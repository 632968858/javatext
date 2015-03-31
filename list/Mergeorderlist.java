package list;

import java.util.Scanner;

/*合并有序链表
 * 
 * 
 * */

public class Mergeorderlist {
	public static void merge(Linklist l1,Linklist l2){
		Node l=l1.getHead();
		Node p=l1.getHead().getnext();
		Node q=l2.getHead().getnext();
		while(p!=null&&q!=null){
			if(Integer.valueOf(p.getdata().toString())<Integer.valueOf(q.getdata().toString())){
				l.setnext(p);
				p=p.getnext();
			}
			else{
				l.setnext(q);
				q=q.getnext();
			}
			l=l.getnext();
		}
		l.setnext((p!=null)?p:q);
	}
	
	
public static void main(String[] args) throws Exception {
	int n=0,m=0;
	System.out.print("输入一个列表个数：");
	Scanner sc=new Scanner(System.in);
	n=sc.nextInt();
	System.out.println("升序输入"+n+"一个列表：");
	Linklist l1=new Linklist(n,true);
	System.out.print("输入一个列表个数：");
  m=sc.nextInt();
	System.out.println("升序输入"+m+"一个列表：");
	Linklist l2=new Linklist(m,true);
	 merge(l1,l2);
	l1.display();
	sc.close();
}
}
