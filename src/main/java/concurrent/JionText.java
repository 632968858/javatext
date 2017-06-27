package concurrent;

class MyThread extends Thread {
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

public class JionText {
    public static void main(String[] args) {
        MyThread my = new MyThread();
        my.start();
        try {
            my.join(2000);              //等待my完成然后执行main后续的，或者在2000后执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mainover");
    }
}
