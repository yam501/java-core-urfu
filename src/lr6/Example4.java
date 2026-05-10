package lr6;

/**
 * 10 потоков, каждый выводит на экран свой номер
 */
public class Example4 {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int num = i + 1;
            threads[i] = new Thread(() -> System.out.println("Поток №" + num));
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
    }
}
