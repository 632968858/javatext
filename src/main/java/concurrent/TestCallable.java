package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String>{
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName();
	}
}
public class TestCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es=Executors.newFixedThreadPool(2);
		Future<String> f1=es.submit(new MyCallable());
		Future<String> f2 =es.submit(new MyCallable());
		System.out.println(f1.get());
		System.out.println(f2.get());
		es.shutdown();
	}
	
}
