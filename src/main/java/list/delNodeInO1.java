package list;
/**
 * 
 * @author xiaoyu
 *		在O(1)时间内删除节点
 *		该节点必在该链表中
 */

public class delNodeInO1 {
	public void deleNode(Linklist ll,Node target){
		Node head = ll.getHead();
		
		if(head==null&&target==null){
			return ;
		}
		
		if(target.getnext()!=null){       //不是尾
			Node temp=target.getnext();
			target.setdata(temp.getdata());
			target.setnext(temp.getnext());
			temp=null;
		}else if(head.equals(target)){  //是尾部且为头时
			head=null;
			target=null;
		}else{   //尾部非头节点
			Node temp=head;
			while(temp.getnext()!=target){//直到尾部前一个节点
				temp=temp.getnext();
			}
			temp.setnext(null);
			target=null;
			
			
			
		}
		
		
	}
}
