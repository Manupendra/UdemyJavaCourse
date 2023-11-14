package s21.ThreadChallenge;

/**
 * Your task is to create two threads.
 * You should make one thread subclass the java.lang.Thread class.
 * The other should be created using a Runnable, which you can pass to the Thread constructor.
 * This can be any class that implements Runnable,or a lambda expression.
 * Each thread should have a run methodThe first thread's code should print 5 even numbers,
 * and the second thread should print 5 odd numbers.
 * You should execute them asynchronously, calling the start method on each,
 * in two consecutive statements, in your main code.
 * Have your main method after these threads run a few seconds, interrupt one or both of these threads.
 */
class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println("OddThread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("OddThread interrupted!");
                break;
            }
        }
    }
}

class EvenRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i < 10; i += 2) {
            System.out.println("EvenRunnable: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("OddRunnable interrupted!");
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        Runnable newRunnable = () -> {
            for (int i = 2; i < 10; i += 2) {
                System.out.println("EvenRunnable: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("OddRunnable interrupted!");
                    break;
                }
            }
        };
        Thread evenThread = new Thread(newRunnable);
        oddThread.start();
        evenThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        oddThread.interrupt();
    }
}
