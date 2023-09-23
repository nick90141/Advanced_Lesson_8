package task_5;

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
    public synchronized void methodA() {
        System.out.println("MethodA в ClassA запущен");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("MethodB в ClassA запущен");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    class ClassO {
    public synchronized void methodC() {
        System.out.println("MethodС в ClassO запущен");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodD() {
        System.out.println("MethodD в ClassO запущен");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

