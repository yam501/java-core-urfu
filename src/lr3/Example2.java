package lr3;

import java.util.Scanner;

/**
 * Пример 2.
 * Вывести последовательность x = 2*x+1 (0 <= x < 20) в обратном порядке.
 */
public class Example2 {

    static void printReverse(int x) {
        if (x < 0 || x >= 20) {
            return;
        }
        printReverse(2 * x + 1);
        System.out.println(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите начальное значение x: ");
        int x = sc.nextInt();
        printReverse(x);
        sc.close();
    }
}
