package concurrent;
class User{
	private String name;
	private int count;
	public User(String name,int count){
		this.name=name;
		this.count=count;
	}
	public synchronized void oper(int num) {
		count +=num;
		System.out.println(Thread.currentThread().getName());
		System.out.println("余额："+count);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class MyThreadb implements Runnable{
	private User user;
	public MyThreadb(User user){
		this.user=user;
		
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+"start");
		for(int i=0;i<5;i++){
			user.oper(1);
		}
	}
}
public class BankTest {
	public static void main(String[] args) {
		User user =new User("xiaoyu",100);
		 new Thread(new MyThreadb(user)).start();
		 new Thread(new MyThreadb(user)).start();
	}
}