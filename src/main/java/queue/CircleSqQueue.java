package queue;
/*
 * 
 * 循环顺序队列
 * 空一个表示满 空
 * 
 * 
 * */
public class CircleSqQueue implements IQueue{
	private Object[] queueElem;
	private int front;
	private int rear;
	public CircleSqQueue(int maxsize) {
		// TODO Auto-generated constructor stub
		queueElem=new Object[maxsize];
		front=rear=0;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front=rear;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==rear;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return (rear-front+queueElem.length)%queueElem.length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		//注意空的情况
		if(isEmpty())
		{
			return null;
		}else
		return queueElem[front];
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		if((rear+1)%queueElem.length==front)
			throw new Exception("满");
		else
			{queueElem[rear]=x;
			rear=(rear+1)%queueElem.length;
			}
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			return null;
		}else
			{Object t=queueElem[front];
			front=(front+1)%queueElem.length;
			return t;
			}
		
	}
	public void display(){
		if(!isEmpty()){           ///////////////////////////////////
		for(int i=front;i!=rear;i=(i+1)%queueElem.length){///////////////////////////////////////
			System.out.print(queueElem[i].toString()+" ");
		}
		}else{
			System.out.println("空");
		}
	}

}
