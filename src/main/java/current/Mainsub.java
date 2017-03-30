package current;

/*
 * 子线程循环10次，接着主线程执行循环100次，接着又回到子线程循环10次，接着再回到主线程100次，如此50次
 */

class ThreadText {
    private boolean isSub = true;

    public synchronized void sub() {
        if (!isSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " ： " + i);
        }
        isSub = false;
        this.notify();

    }

    public synchronized void maint() {
        if (isSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " ： " + i);
        }

        isSub = true;
        this.notify();
    }
}

public class Mainsub {

    public static void main(String[] args) {
        final ThreadText tt = new ThreadText();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) { //////////////////////////////////在run 里面
                    tt.sub();
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            tt.maint();
        }
    }
}

