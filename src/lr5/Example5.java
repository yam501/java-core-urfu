package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Получение списка квадратов чисел с использованием Stream API.
 */
public class Example5 {

    static List<Integer> squares(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).collect(Collectors.toList());
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
        System.out.println("Квадраты: " + squares(numbers));
        sc.close();
    }
}
