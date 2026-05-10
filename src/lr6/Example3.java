package lr6;

/**
 * Два потока выводят числа от 1 до 10: один — чётные, другой — нечётные
 */
public class Example3 {

    private static final Object lock = new Object();
    private static volatile int number = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread evenThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {
                    while (number % 2 != 0 && number <= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if (number <= 10) {
                        System.out.println("Чётный:   " + number++);
                        lock.notifyAll();
                    }
                }
            }
        }, "Чётный поток");

        Thread oddThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {
                    while (number % 2 == 0 && number <= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if (number <= 10) {
                        System.out.println("Нечётный: " + number++);
                        lock.notifyAll();
                    }
                }
            }
        }, "Нечётный поток");

        oddThread.start();
        evenThread.start();
        oddThread.join();
        evenThread.join();
    }
}
