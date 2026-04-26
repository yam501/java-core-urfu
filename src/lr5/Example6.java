package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Фильтрация строк, содержащих заданную подстроку.
 */
public class Example6 {

    static List<String> filterBySubstring(List<String> strings, String sub) {
        return strings.stream()
                .filter(s -> s.contains(sub))
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
        System.out.print("Введите подстроку для поиска: ");
        String sub = sc.nextLine();
        System.out.println("Строки, содержащие \"" + sub + "\": " + filterBySubstring(strings, sub));
        sc.close();
    }
}
