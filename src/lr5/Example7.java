package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Фильтрация чисел, делящихся на заданное число без остатка.
 */
public class Example7 {

    static List<Integer> filterDivisible(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(x -> x % divisor == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            numbers.add(sc.nextInt());
        }
        System.out.print("Введите делитель: ");
        int divisor = sc.nextInt();
        System.out.println("Числа, делящиеся на " + divisor + ": " + filterDivisible(numbers, divisor));
        sc.close();
    }
}
