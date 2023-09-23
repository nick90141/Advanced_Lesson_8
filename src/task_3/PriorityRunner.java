package task_3;

class PriorityRunner {
    public static void main(String[] args) {
        PriorityThread minPriorityThread = new PriorityThread("Min", Thread.MIN_PRIORITY);
        PriorityThread maxPriorityThread = new PriorityThread("Max", Thread.MAX_PRIORITY);
        PriorityThread normPriorityThread = new PriorityThread("Norm", Thread.NORM_PRIORITY);

        minPriorityThread.start();
        maxPriorityThread.start();
        normPriorityThread.start();
    }
}

class PriorityThread extends Thread {
    public PriorityThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(getName() + " поток запущен, значение: " + i);
        }
    }
}