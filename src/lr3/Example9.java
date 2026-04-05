package lr3;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Задание 5.
 * Заполнить HashMap 10 объектами <Integer, String>.
 * 1) Найти строки, у которых ключ > 5.
 * 2) Если ключ = 0, вывести все строки через запятую.
 * 3) Перемножить все ключи, где длина строки > 5.
 */
public class Example9 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Иван");
        map.put(1, "Сергей");
        map.put(2, "Вася");
        map.put(3, "Дмитрий");
        map.put(4, "Саша");
        map.put(5, "Анатолий");
        map.put(6, "Лена");
        map.put(7, "Николай");
        map.put(8, "Таня");
        map.put(9, "Алексей");

        System.out.println("Содержимое HashMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nСтроки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
            }
        }

        if (map.containsKey(0)) {
            StringJoiner sj = new StringJoiner(", ");
            for (String val : map.values()) {
                sj.add(val);
            }
            System.out.println("\nКлюч 0 найден. Все строки через запятую:");
            System.out.println("  " + sj);
        }

        long product = 1;
        boolean found = false;
        System.out.println("\nКлючи, где длина строки > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                System.out.println("  ключ=" + entry.getKey() + ", строка=\"" + entry.getValue() + "\" (длина=" + entry.getValue().length() + ")");
                product *= entry.getKey();
                found = true;
            }
        }
        if (found) {
            System.out.println("Произведение таких ключей: " + product);
        } else {
            System.out.println("Строк с длиной > 5 не найдено.");
        }
    }
}
