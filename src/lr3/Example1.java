package lr3;

import java.util.Scanner;

/**
 * Пример 1.
 * Для заданного x вывести последовательность x = 2*x+1, пока 0 <= x < 20.
 */
public class Example1 {

    static void printSequence(int x) {
        if (x < 0 || x >= 20) {
            return;
        }
        System.out.println(x);
        printSequence(2 * x + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите начальное значение x: ");
        int x = sc.nextInt();
        printSequence(x);
        sc.close();
    }
}
