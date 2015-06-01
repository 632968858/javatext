package concurrent;
class Repertory{
	private final int maxsize=5;
	private int current;
	public Repertory(){
		this.current=0;
	}
	public synchronized void produce() {
		while(true){
		System.out.println(Thread.currentThread().getName()+" produce:");
		System.out.println("库存为:"+current);
		
		while(current>=maxsize){                ///////此处应该为while
			try{
				wait();                                ///////////////
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
			current++;
		System.out.println("生产后库存为:"+current);
		notifyAll();                         /////////////////////////////
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public synchronized void consume() {
		while(true){
		System.out.println(Thread.currentThread().getName()+" consume:");
		System.out.println("库存为:"+current);
		while(current<=0){                             ///////此处应该为while
			try{
				wait();                              ////////////////////
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
			current--;
		System.out.println("消费后库存为:"+current);
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();                    ///////////////////
	} 
	}
}
class Consumer implements Runnable{
	private Repertory r;
	public Consumer(Repertory r){
		this.r=r;
	}
	public void run(){
		r.consume();
	}
}
class Procucer implements Runnable{
	private Repertory r;
	public Procucer(Repertory r){
		this.r=r;
	}
	public void run(){
		r.produce();
	}
}
public class ProducerAndConsumer {
	public static void main(String[] args) {
		Repertory r =new Repertory();
			Thread p1= new Thread(new Procucer(r));
			Thread p2 =new Thread(new Procucer(r));
			Thread c1=new Thread(new Consumer(r));
			Thread c2=new Thread(new Consumer(r));
			p1.start();
			p2.start();
			c1.start();
			c2.start();
	}
}
