package lr6;

/**
 * Поток выводит числа от 1 до 10 с задержкой в 1 секунду
 */
public class Example2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        t.start();
        t.join();
    }
}
