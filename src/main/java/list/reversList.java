package list;

public class reversList {
	public static void main(String[] args) throws Exception {
		Linklist ll =new Linklist(5,true);
		ll.display();
		reverList(ll);
		System.out.println("hello");
		ll.display();
	}
	public static void reverList(Linklist ll){
		if(ll==null){
			return;
		}
		Node current =ll.getHead().getnext();
		Node pre =null;
		Node next=null;
		
		while(current!=null){
			
			next =current.getnext();
			current.setnext(pre);
			pre=current;
			current=next;
		}
		ll.getHead().setnext(pre);
	}
	
}
