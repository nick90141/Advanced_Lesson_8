package task_6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassO classO = new ClassO();

        Thread thread1 = new Thread(() -> {
            classA.methodA();
            classO.methodC();
        });

        Thread thread2 = new Thread(() -> {
            classO.methodD();
            classA.methodB();
        });

        thread1.start();
        thread2.start();
    }
}

class ClassA {
    private final Lock lockA = new ReentrantLock();

    public void methodA() {
        lockA.lock();
        try {
            System.out.println("MethodA в ClassA запущен");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockA.unlock();
        }
    }

    public void methodB() {
        lockA.lock();
        try {
            System.out.println("MethodB в ClassA запущен");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockA.unlock();
        }
    }
}

class ClassO {
    private final Lock lockO = new ReentrantLock();

    public void methodC() {
        lockO.lock();
        try {
            System.out.println("MethodС в ClassO запущен");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockO.unlock();
        }
    }

    public void methodD() {
        lockO.lock();
        try {
            System.out.println("MethodD в ClassO запущен");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockO.unlock();
        }
    }
}
