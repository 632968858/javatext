package stackqueuetransfer;

import java.util.LinkedList;
/*
 * 两个队列实现一个
 * 
 * 
 */
public class QueueToStack {
	private LinkedList queue1;
	private LinkedList queue2;
	public QueueToStack() {
		this.queue1 = new LinkedList();
		this.queue2 = new LinkedList();
	}
	public Object pop() throws Exception{
		LinkedList popqueue = (queue1.size()!=0)?queue1:queue2;//不为空为出栈队列
		LinkedList emptyqueue= (queue1.size()==0)?queue1:queue2;//辅助队列
		if(popqueue.size()==0){
			throw new Exception("stack is empty");
		}
		while(popqueue.size()>1){
			emptyqueue.addLast(popqueue.poll());
		}
		return popqueue.poll();
	}	
	public void push(Object o){
		LinkedList pushqueue = (queue1.size()!=0)?queue1:queue2;//不为空为入栈队列
		pushqueue.addLast(o);
	}
	public static void main(String[] args) throws Exception {
		QueueToStack qts = new QueueToStack();
		int [] a ={1,2,3,4,5};
		for(int temp :a ){
			qts.push(temp);
		}
		for(int temp :a ){
			System.out.println(qts.pop());
		}
	}
}
