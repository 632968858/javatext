package current;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liuxiaoyu
 * @Date 17/3/30.
 */
class CriticalResource {
    private ReentrantLock reentrantLock;
    private Condition condition1;
    private Condition condition2;
    private Condition condition3;

    private volatile int status = 1;

    public CriticalResource() {
        this.reentrantLock = new ReentrantLock();
        this.condition1 = reentrantLock.newCondition();
        this.condition2 = reentrantLock.newCondition();
        this.condition3 = reentrantLock.newCondition();
    }

    public void printA() {

        reentrantLock.lock();
        try {
            if (status != 1) {
                condition1.await();
            }
            System.out.println("a");
            status = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    public void printB() {

        reentrantLock.lock();
        try {
            if (status != 2) {
                condition2.await();
            }
            System.out.println("b");
            status = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    public void printC() {
        reentrantLock.lock();
        try {
            if (status != 3) {
                condition3.await();
            }
            System.out.println("c");
            status = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}

class RunTheadPrintA extends Thread {
    private CriticalResource criticalResource;

    public RunTheadPrintA(CriticalResource criticalResource) {
        this.criticalResource = criticalResource;
    }

    @Override
    public void run() {
        while (true) {
            criticalResource.printA();
        }
    }
}

class RunTheadPrintB extends Thread {
    private CriticalResource criticalResource;

    public RunTheadPrintB(CriticalResource criticalResource) {
        this.criticalResource = criticalResource;
    }

    @Override
    public void run() {
        while (true) {
            criticalResource.printB();
        }
    }
}

class RunTheadPrintC extends Thread {
    private CriticalResource criticalResource;

    public RunTheadPrintC(CriticalResource criticalResource) {
        this.criticalResource = criticalResource;
    }

    @Override
    public void run() {
        while (true) {
            criticalResource.printC();
        }
    }
}

public class RunInOrder {

    public static void main(String[] args) {
        CriticalResource criticalResource = new CriticalResource();

        RunTheadPrintC runTheadPrintC = new RunTheadPrintC(criticalResource);
        RunTheadPrintB runTheadPrintB = new RunTheadPrintB(criticalResource);
        RunTheadPrintA runTheadPrintA = new RunTheadPrintA(criticalResource);

        runTheadPrintC.start();
        runTheadPrintB.start();
        runTheadPrintA.start();
    }

}
