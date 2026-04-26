package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация всех примеров из раздела 1
 */
public class Example1 {

    static int[] filterEven(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }

    static int[] intersection(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .distinct()
                .toArray();
    }

    static List<String> filterCapitalized(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    static List<Integer> squares(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Чётные числа: " + Arrays.toString(filterEven(arr)));

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 6, 7};
        System.out.println("\nМассив A: " + Arrays.toString(a));
        System.out.println("Массив B: " + Arrays.toString(b));
        System.out.println("Пересечение: " + Arrays.toString(intersection(a, b)));

        List<String> words = List.of("Яблоко", "банан", "Апельсин", "груша", "Манго");
        System.out.println("\nСписок строк: " + words);
        System.out.println("Строки с заглавной буквы: " + filterCapitalized(words));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("\nСписок чисел: " + numbers);
        System.out.println("Квадраты: " + squares(numbers));
    }
}
