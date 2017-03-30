package queue;

import list.Node;

public class LinkQueue implements IQueue {
	private Node front; // //////////////////
	private Node rear; // /////////////////////

	public LinkQueue() {
		front = rear = null;
	}

	public void clear() {
		// TODO Auto-generated method stub
		front = rear = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		Node p = front;
		int i = 0;
		while (p != null) {
			i++;
			p = p.getnext();
		}
		return i;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		// ////////////////////////////非空判断
		if (!isEmpty())
			return front.getdata();
		else
			return null;
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		// ////////////////////////////////////非空判断
		Node p = new Node(x);
		if (!isEmpty()) {
			rear.setnext(p);
			rear = p;
		} else {
			front=rear=p;              //////////////////////////////////
		}
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		else {
			Object x = front.getdata();
			front = front.getnext();
			return x;
		}
	}

}
