package task_2;

public class Example {
    public static void main(String[] args) {
        Thread main = new Thread(new Main ());
        Thread firstThread = new Thread(new First ());
        Thread secondThread = new Thread(new Second ());

        main.start();
        firstThread.start();
        secondThread.start();

        try {
            main.join();
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершение \"main\"");
        System.out.println("Завершение \"first\"");
        System.out.println("Завершение \"second\"");

    }
}

class Main extends Thread {
    @Override
    public void run() {
        System.out.println("Поток \"main\"");
    }
}
class First extends Thread {
    @Override
    public void run() {
        System.out.println("Поток \"first\"");
    }
}

class Second extends Thread {
    @Override
    public void run() {
        System.out.println("Поток \"second\"");
    }
}

