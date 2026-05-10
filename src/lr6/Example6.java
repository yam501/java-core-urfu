package lr6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Суммирование элементов массива при помощи многопоточности
 * Количество потоков равно количеству ядер процессора
 */
public class Example6 {

    static long parallelSum(int[] arr) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int chunkSize = (arr.length + cores - 1) / cores;
        long[] partialSums = new long[cores];

        Thread[] threads = new Thread[cores];
        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, arr.length);
            final int idx = i;
            if (start >= arr.length) break;
            threads[i] = new Thread(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) sum += arr[j];
                partialSums[idx] = sum;
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            if (t != null) t.join();
        }

        long total = 0;
        for (long s : partialSums) total += s;
        return total;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("Ядер процессора: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Сумма: " + parallelSum(arr));
    }
}
