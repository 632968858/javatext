package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadc extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在运行");
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Thread t1 = new MyThreadc();
        Thread t2 = new MyThreadc();
        Thread t3 = new MyThreadc();
        Thread t4 = new MyThreadc();
        Thread t5 = new MyThreadc();
        es.execute(t1);
        es.execute(t2);
        es.execute(t3);
        es.execute(t4);
        es.execute(t5);

        es.shutdown();
    }
}
