package lr5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Фильтрация чётных чисел из массива с использованием Stream API.
 */
public class Example2 {

    static int[] filterEven(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Введите элементы:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Чётные числа: " + Arrays.toString(filterEven(arr)));
        sc.close();
    }
}
