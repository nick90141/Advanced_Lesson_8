package task_7;

public class Main {
    public static void main(String[] args) {
        Thread exampleDaemon = new Thread(new ExampleDaemon());

        exampleDaemon.setDaemon(true);

        exampleDaemon.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isDaemon = exampleDaemon.isDaemon();
        System.out.println("Является ли демоном: " + isDaemon);

    }
}
class ExampleDaemon extends Thread {
    @Override
    public void run() {
        System.out.println("Поток \"ExampleDaemon\"");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершение \"ExampleDaemon\"");

    }
}