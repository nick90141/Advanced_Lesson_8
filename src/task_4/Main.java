package task_4;


public class Main {
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass();
        SecondClass secondClass = new SecondClass();

        Thread thread1 = new Thread(() -> firstClass.printFirst());
        Thread thread2 = new Thread(() -> secondClass.printSecond());

        thread1.start();
        thread2.start();
    }
}
class FirstClass {
    synchronized void printFirst() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " из класса 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondClass {
    synchronized void printSecond() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " из класса 2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

