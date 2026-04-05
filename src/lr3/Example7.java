package lr3;

import java.util.Scanner;

/**
 * Задание 3.
 * Ввод и вывод одномерного массива целых чисел с использованием рекурсии вместо циклов for.
 */
public class Example7 {

    static int[] arr;
    static Scanner sc = new Scanner(System.in);

    static void inputArray(int index) {
        if (index >= arr.length) return;
        System.out.print("Введите элемент [" + index + "]: ");
        arr[index] = sc.nextInt();
        inputArray(index + 1);
    }

    static void printArray(int index) {
        if (index >= arr.length) return;
        System.out.println("arr[" + index + "] = " + arr[index]);
        printArray(index + 1);
    }

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size = sc.nextInt();
        arr = new int[size];
        inputArray(0);
        System.out.println("Элементы массива:");
        printArray(0);
        sc.close();
    }
}
