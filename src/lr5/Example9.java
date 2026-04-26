package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Фильтрация чисел, больших заданного значения.
 */
public class Example9 {

    static List<Integer> filterGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(x -> x > threshold)
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
        System.out.print("Введите пороговое значение: ");
        int threshold = sc.nextInt();
        System.out.println("Числа больше " + threshold + ": " + filterGreaterThan(numbers, threshold));
        sc.close();
    }
}
