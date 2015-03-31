package stack;

public class Sqstack implements IStack {
	private Object[] stackElem;
	private int top;
	public Sqstack(int maxsize){
		stackElem=new Object[maxsize];
		top=0;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return top;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
		return stackElem[top-1];
		}else
			return null;
	}

	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		if(top>=stackElem.length)
			throw new Exception("栈满");
		else
			stackElem[top++]=x;
	}

	@Override
	public Object pop()  {
		// TODO Auto-generated method stub
		if(!isEmpty()){
		return stackElem[--top];
		}else
			return null;
	}
	public void display(){
		for(int i=0;i<top;i++)
		{
			System.out.print(stackElem[i]);
			System.out.print(" ");
		}
	}

}
