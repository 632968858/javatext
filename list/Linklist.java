package list;

import java.util.Scanner;

public class Linklist implements IList{
	private Node head;
	public Linklist() {
		// TODO Auto-generated constructor stub
		head=new Node(); //初始化头空节点
		
	}
	public Linklist(int n,boolean order) throws Exception{
		this();
		if(order){
			create1(n);  //尾插法
		}else{
			create2(n);
		}
	}
	public Node getHead(){
		return head;
	}
	public void create1(int n) throws Exception{  //n个节点尾插法
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++){
			insert(length(), sc.next());
			
		}
		sc.close();
		
	}
public void create2(int n) throws Exception{
	Scanner sc = new Scanner(System.in);
	for(int i=0;i<n;i++){
		insert(0, sc.next());
		
	}
	sc.close();
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.setdata(null);
		head.setnext(null);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.getnext()==null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		Node p=head.getnext();
		int curLen=0;
		while(p!=null){
			curLen++;
			p=p.getnext();
		}
		return curLen;
	}

	@Override
	public Object get(int i) throws Exception {  //注意i小于0的判断
		// TODO Auto-generated method stub
		Node p=head.getnext();
		int j=0;
		while(j<i&&p!=null){
			j++;
			p=p.getnext();
		}
		/*if(p!=null)
			return p.getdata();
		else
			throw new Exception("位置错误");*/
		if(j>i||p==null)//i小于0或者p已经为空
			throw new Exception("位置不对");
		return p.getdata();
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
	/*	
	 * 带头节点的插入
	 * 
	 * 
	 * */
		Node p=head;//////////////////////////////////////////
		int j=-1;//////////////////////////////////////////////////
		while (j<i-1&&p!=null){  //注意是查找插入位置的前驱节点
			p=p.getnext();
			j++;
		}
		if(j>i||p==null)
		{
			throw new Exception("插入位置不对");
		}
/*
*注意此次不是插入尾节点
*
*
*
*/
		Node q =new Node (x);
		q.setnext(p.getnext());
		p.setnext(q);
	}

	@Override
	public void remove(int i) throws Exception {//注意判断i的位置合法性
		// TODO Auto-generated method stub
		Node p=head;/////////////////////////////
		int j=-1;
		while(j<i-1&&p.getnext()!=null){   //前驱 p.getnext
			j++;
			p=p.getnext();
		}
		if(j>i-1||p.getnext()==null)//注意判断i的位置合法性
		{
			throw new Exception("删除位置不对");
		}
		Node q=p.getnext();
		p.setnext(q.getnext());
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		Node p=head.getnext();
		int i=0;
		while(p!=null){
			
			if(p.getdata().equals(x))
				return i;
			i++;
			p=p.getnext();
		}
		return -1;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		Node p=head.getnext();
		while(p!=null){
			System.out.print(p.getdata()+" ");
			p=p.getnext();
		}
			
	}

}
