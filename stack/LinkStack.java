package stack;
import list.Node;

public class LinkStack implements IStack {
	private Node top;
	public LinkStack(){
		top=null;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top=null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		int i=0;
		Node p=top;
		while(p!=null){
			i++;
			p=p.getnext();
		}
		return i;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(!isEmpty())
			return top.getdata();
		else 
			return null;
	}

	@Override
	public void push(Object x) {
		// TODO Auto-generated method stub
		Node p=new Node(x);
		p.setnext(top);
		top=p;
		
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(!isEmpty())
			{
			Node p=top;
				top=top.getnext();
				return p.getdata();
			}
		else
			return null;
	}

}
