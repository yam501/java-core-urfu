package lr3;

import java.util.Scanner;

/**
 * Задание 2.
 * Перевод целого числа в двоичную систему счисления с использованием рекурсии.
 */
public class Example6 {

    static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое положительное число: ");
        int n = sc.nextInt();
        System.out.println(n + " в двоичной системе счисления: " + toBinary(n));
        System.out.println("Проверка (Integer.toBinaryString): " + Integer.toBinaryString(n));
        sc.close();
    }
}
