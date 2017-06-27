package concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author liuxiaoyu
 * @Date 17/6/3.
 */
class MyRunnable implements Runnable{
    private int number = 0;
    private Thread t1;
    public MyRunnable(int number,Thread t){
        this.number = number;
        this.t1 = t;
    }
    public MyRunnable(int number){
        this.number = number;
    }
    @Override
    public void run() {
        if(t1!=null){
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(number);
    }
}
public class ThreadRank {

    public static void main(String[] args){
        Thread t1 = new Thread(new MyRunnable(1));
        Thread t2 = new Thread(new MyRunnable(2,t1));
        Thread t3 = new Thread(new MyRunnable(3,t2));
        t1.start();
        t2.start();
        t3.start();

        ConcurrentHashMap map = new ConcurrentHashMap();
        StringBuffer sb = new StringBuffer();
    }

}
