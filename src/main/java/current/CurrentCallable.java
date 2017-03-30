package current;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Call implements Callable<String>{
	public String call() throws InterruptedException{
		Thread.sleep(1000);
		return  Thread.currentThread().getName();
	}
}
public class CurrentCallable {
	public static void main(String[] args) {
		List<Future<String>> list =new ArrayList<Future<String>>();
		Callable<String> ca= new Call();
		ExecutorService ex = Executors.newFixedThreadPool(10);
		for(int i=0;i<100;i++){
			Future <String> fu= ex.submit(ca);
			list.add(fu);
		}
		for(Future<String> fu :list){
			try {
				System.out.println(fu.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ex.shutdown();
		
	}
}
