package current;

/**
 * @Author liuxiaoyu
 * @Date 17/3/31.
 */

class VolatileResource {
    private volatile int status = 1;

    public void printA() {
        while (status != 1) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("a");
        status = 2;
    }

    public void printB() {
        while (status != 2) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("b");
        status = 3;
    }

    public void printC() {
        while (status != 3) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("c");
        status = 1;
    }
}

class ThreadRunA extends Thread {
    private VolatileResource volataileResource;

    public ThreadRunA(VolatileResource volataileResource) {
        this.volataileResource = volataileResource;
    }

    public void run() {
        while (true) {
            volataileResource.printA();
        }
    }
}

class ThreadRunB extends Thread {
    private VolatileResource volatailResource;

    public ThreadRunB(VolatileResource volatailResource) {
        this.volatailResource = volatailResource;
    }

    public void run() {
        while (true) {
            volatailResource.printB();
        }
    }
}

class ThreadRunC extends Thread {
    private VolatileResource volatailResource;

    public ThreadRunC(VolatileResource volatailResource) {
        this.volatailResource = volatailResource;
    }

    public void run() {
        while (true) {
            volatailResource.printC();
        }

    }
}

public class RunInOrderSencond {
    public static void main(String[] args) {
        VolatileResource volatileResource = new VolatileResource();
        ThreadRunA ta = new ThreadRunA(volatileResource);
        ThreadRunB tb = new ThreadRunB(volatileResource);
        ThreadRunC tc = new ThreadRunC(volatileResource);
        ta.start();
        tb.start();
        tc.start();
    }
}
