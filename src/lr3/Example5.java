package lr3;

import java.util.Scanner;

/**
 * Пример 5.
 * Вывести число Фибоначчи по его номеру.
 * Дополнительно: вывести последовательность обхода дерева рекурсивных вызовов.
 */
public class Example5 {

    static long fibonacci(int n, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "-> fib(" + n + ")");
        if (n <= 1) {
            System.out.println(indent + "<- fib(" + n + ") = " + n);
            return n;
        }
        long left  = fibonacci(n - 1, depth + 1);
        long right = fibonacci(n - 2, depth + 1);
        long result = left + right;
        System.out.println(indent + "<- fib(" + n + ") = " + result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер числа Фибоначчи: ");
        int n = sc.nextInt();
        System.out.println("\nДерево рекурсивных вызовов:");
        long result = fibonacci(n, 0);
        System.out.println("\nЧисло Фибоначчи с номером " + n + " = " + result);
        sc.close();
    }
}
