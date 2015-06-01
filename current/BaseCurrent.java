package current;

class Thread1 extends Thread{
	public Thread1(String name){
		super(name);
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+"开始执行");
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			try {
				sleep((int)Math.random()*10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束");
	}
	
}
public class BaseCurrent {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"开始执行");
		Thread t1=new Thread1("th1");
		Thread t2=new Thread1("th2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(Thread.currentThread().getName()+"结束");
	}
}
