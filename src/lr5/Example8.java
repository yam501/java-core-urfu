package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Фильтрация строк с длиной больше заданного значения.
 */
public class Example8 {

    static List<String> filterByLength(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() > minLength)
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
        System.out.print("Введите минимальную длину: ");
        int minLength = sc.nextInt();
        System.out.println("Строки длиннее " + minLength + " символов: " + filterByLength(strings, minLength));
        sc.close();
    }
}
