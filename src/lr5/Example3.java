package lr5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Пересечение двух массивов целых чисел с использованием Stream API.
 */
public class Example3 {

    static int[] intersection(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .distinct()
                .toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Размер первого массива: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Введите первый массив:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        System.out.print("Размер второго массива: ");
        int m = sc.nextInt();
        int[] b = new int[m];
        System.out.println("Введите второй массив:");
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        System.out.println("Пересечение: " + Arrays.toString(intersection(a, b)));
        sc.close();
    }
}
