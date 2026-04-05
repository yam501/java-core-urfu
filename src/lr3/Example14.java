package lr3;

import java.util.*;

/**
 * Сравнение коллекций (вариант 10): HashSet, LinkedHashMap, ArrayList.
 * Количество элементов N = 10 * 1_000_000.
 *
 * Для позиционных операций ArrayList (добавление/удаление в начало и середину)
 * используется уменьшенный N_POS = 100_000, так как эти операции O(n) и
 * с 10M элементами итоговая сложность O(n^2) неприемлема по времени.
 */
public class Example14 {

    static final int N     = 10_000_000;
    static final int N_POS = 100_000;

    // ArrayList

    static long alAddEnd() {
        ArrayList<Integer> list = new ArrayList<>();
        long t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - t;
    }

    static long alAddStart() {
        ArrayList<Integer> list = new ArrayList<>();
        long t = System.currentTimeMillis();
        for (int i = 0; i < N_POS; i++) {
            list.add(0, i);
        }
        return System.currentTimeMillis() - t;
    }

    static long alAddMiddle() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N_POS; i++) {
            list.add(i);
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < N_POS; i++) {
            list.add(list.size() / 2, i);
        }
        return System.currentTimeMillis() - t;
    }

    static long alRemoveStart() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N_POS; i++) {
            list.add(i);
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < N_POS; i++) {
            list.remove(0);
        }
        return System.currentTimeMillis() - t;
    }

    static long alRemoveEnd() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.remove(list.size() - 1);
        }
        return System.currentTimeMillis() - t;
    }

    static long alRemoveMiddle() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N_POS; i++) {
            list.add(i);
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < N_POS; i++) {
            list.remove(list.size() / 2);
        }
        return System.currentTimeMillis() - t;
    }

    static long alGet() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.get(i);
        }
        return System.currentTimeMillis() - t;
    }

    // HashSet

    static long hsAdd() {
        HashSet<Integer> set = new HashSet<>();
        long t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        return System.currentTimeMillis() - t;
    }

    static long hsRemove() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            set.remove(i);
        }
        return System.currentTimeMillis() - t;
    }

    // LinkedHashMap ---

    static long lhmAdd() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        long t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }
        return System.currentTimeMillis() - t;
    }

    static long lhmRemove() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) map.put(i, i);
        long t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) map.remove(i);
        return System.currentTimeMillis() - t;
    }

    public static void main(String[] args) {
        System.out.println("Вариант 10: HashSet, LinkedHashMap, ArrayList");
        System.out.printf("N = %,d  |  N_POS (позиционные операции AL) = %,d%n%n", N, N_POS);

        System.out.println("=== Таблица 1. Добавление элементов ===");
        System.out.printf("%-18s %-20s %-20s %-20s%n", "Коллекция", "В начало", "В середину", "В конец");
        System.out.printf("%-18s %-20s %-20s %-20s%n",
                "ArrayList",
                alAddStart() + " мс (N=" + N_POS + ")",
                alAddMiddle() + " мс (N=" + N_POS + ")",
                alAddEnd()   + " мс (N=" + N + ")");
        System.out.printf("%-18s %-20s %-20s %-20s%n",
                "HashSet",
                "N/A",
                "N/A",
                hsAdd() + " мс (N=" + N + ")");
        System.out.printf("%-18s %-20s %-20s %-20s%n",
                "LinkedHashMap",
                "N/A",
                "N/A",
                lhmAdd() + " мс (N=" + N + ")");

        System.out.println("\n=== Таблица 2. Удаление элементов ===");
        System.out.printf("%-18s %-20s %-20s %-20s%n", "Коллекция", "С начала", "С середины", "С конца");
        System.out.printf("%-18s %-20s %-20s %-20s%n",
                "ArrayList",
                alRemoveStart()  + " мс (N=" + N_POS + ")",
                alRemoveMiddle() + " мс (N=" + N_POS + ")",
                alRemoveEnd()    + " мс (N=" + N + ")");
        System.out.printf("%-18s %-20s %-20s %-20s%n",
                "HashSet",
                "N/A",
                hsRemove() + " мс (N=" + N + ")",
                "N/A");
        System.out.printf("%-18s %-20s %-20s %-20s%n",
                "LinkedHashMap",
                "N/A",
                lhmRemove() + " мс (N=" + N + ")",
                "N/A");

        System.out.println("\n=== Таблица 3. Получение элемента по индексу ===");
        System.out.printf("%-18s %-30s%n", "Коллекция", "По индексу");
        System.out.printf("%-18s %-30s%n", "ArrayList",    alGet() + " мс (N=" + N + ", O(1))");
        System.out.printf("%-18s %-30s%n", "HashSet",      "N/A — нет доступа по индексу");
        System.out.printf("%-18s %-30s%n", "LinkedHashMap","N/A — нет доступа по числовому индексу");
    }
}
