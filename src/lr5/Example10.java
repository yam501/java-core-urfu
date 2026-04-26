package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Фильтрация строк, содержащих только буквы (без цифр и символов).
 */
public class Example10 {

    static List<String> filterOnlyLetters(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.chars().allMatch(Character::isLetter))
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
        System.out.println("Строки только из букв: " + filterOnlyLetters(strings));
        sc.close();
    }
}
