package basejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



	class TestThread implements Runnable
	 {
	          public void run()
	         {
	              for(int i=0;i<50;i++)
	              {
	                  System.out.println(Thread.currentThread().getName()+"---"+i);
	              }
	         }
	 }
	 public class TestMain
	 {
	 
	     public static void main(String[] args)
	    {
	         // TODO 自动生成的方法存根
	         TestThread t=new TestThread();
	         ExecutorService pool=Executors.newFixedThreadPool(6);
	         pool.submit(new Thread(t));
	         pool.submit(new Thread(t));
	         pool.shutdown();
	     }
	 
	 }
	
	
