package lr6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Два потока выводят своё имя и текущее время в течение 10 секунд
 */
public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10_000) {
                System.out.println(name + " — " + LocalTime.now().format(fmt));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };

        Thread t1 = new Thread(task, "Поток-1");
        Thread t2 = new Thread(task, "Поток-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
