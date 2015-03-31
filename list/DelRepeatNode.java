package list;

public class DelRepeatNode {
/*
 * 
 * 删除链表中相同的元素
 * 
 * 
 * */
	public static void delrep(Linklist ll) throws Exception{//删除重复节点
		/*Node p= ll.getHead(); 
		for(int i=0;i<ll.length();i++)   //不能用length
		{
			p=p.getnext();
			int j=i+1;//下个位置
			Node q= p.getnext();   //第一个开始
			//System.out.println("p节点值： "+p.getdata());
			while(q!=null){
				if(p.getdata().equals(q.getdata()))
				{	
					ll.remove(j);  //
					System.out.println("删除第"+j+"个节点");
				}
				q=q.getnext();
				j++;
			}
			
		}*/
		Node p=ll.getHead().getnext();
		while(p!=null){
			int index = ll.indexOf(p.getdata());
			Node q= p.getnext();
			while(q!=null){
				if(p.getdata().equals(q.getdata()))
				{
					ll.remove(index+1);
				//	System.out.println("删除：" +q.getdata().toString());
				}
				else	index++;     ////注意
				q=q.getnext();
			}
			p=p.getnext();
		}
	}
	public static void main(String[] args) throws Exception {
		Linklist ll= new Linklist(10,true);//构造一个链表
	//	ll.display();
	//	System.out.println("");
		delrep(ll);
		ll.display();
	}
}
