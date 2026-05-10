package lr6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Нахождение максимального элемента массива при помощи многопоточности
 * Количество потоков равно количеству ядер процессора
 */
public class Example5 {

    static int parallelMax(int[] arr) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int chunkSize = (arr.length + cores - 1) / cores;
        int[] partialMaxes = new int[cores];
        Arrays.fill(partialMaxes, Integer.MIN_VALUE);

        Thread[] threads = new Thread[cores];
        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, arr.length);
            final int idx = i;
            if (start >= arr.length) break;
            threads[i] = new Thread(() -> {
                int max = arr[start];
                for (int j = start + 1; j < end; j++) {
                    if (arr[j] > max) max = arr[j];
                }
                partialMaxes[idx] = max;
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            if (t != null) t.join();
        }

        int max = partialMaxes[0];
        for (int v : partialMaxes) {
            if (v > max) max = v;
        }
        return max;
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
        System.out.println("Максимум: " + parallelMax(arr));
    }
}
