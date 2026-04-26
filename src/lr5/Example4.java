package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Фильтрация строк, начинающихся с заглавной буквы.
 */
public class Example4 {

    static List<String> filterCapitalized(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Строка " + (i + 1) + ": ");
            strings.add(sc.nextLine());
        }
        System.out.println("Строки с заглавной буквы: " + filterCapitalized(strings));
        sc.close();
    }
}
