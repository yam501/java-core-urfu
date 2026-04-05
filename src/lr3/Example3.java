package lr3;

import java.util.Scanner;

/**
 * Пример 3.
 * Вывод значения параметра до вхождения в рекурсивный вызов и после него.
 */
public class Example3 {
    static void printAround(int x) {
        if (x < 0 || x >= 20) {
            return;
        }
        System.out.println("До вызова:   x = " + x);
        printAround(2 * x + 1);
        System.out.println("После вызова: x = " + x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите начальное значение x: ");
        int x = sc.nextInt();
        printAround(x);
        sc.close();
    }
}
