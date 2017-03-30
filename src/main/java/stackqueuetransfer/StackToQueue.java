package stackqueuetransfer;

import java.util.LinkedList;

/*
 * 两个栈实现一个队列
 * 
 */
public class StackToQueue {
	private LinkedList stack1;
	private LinkedList stack2;
	public StackToQueue(){
		this.stack1=new LinkedList();
		this.stack2=new LinkedList();
	}
	public void enQueue(Object target){      //入栈
		stack1.push(target);
	}
	public Object deQueue() throws Exception{ //出栈
		if(stack2.size()==0){
			while(stack1.size()!=0)
				stack2.push(stack1.pop());
		}
		////////////////////////////////
		if(stack2.size()==0){
			throw new Exception("is empty");
		}
		////////////
		return stack2.pop();
	}
	public static void main(String[] args) throws Exception {
		StackToQueue sd =new StackToQueue();
		int [] a ={1,2,3,4,5};
		for(int temp : a){
			sd.enQueue(temp);
		}
		for(int i :a){
		System.out.println(sd.deQueue());
		}
	}
}
