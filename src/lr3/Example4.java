package lr3;

import java.util.Scanner;

/**
 * Пример 4.
 * Вычислить факториал числа n с использованием рекурсии.
 */
public class Example4 {

    static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = sc.nextInt();
        System.out.println(n + "! = " + factorial(n));
        sc.close();
    }
}
