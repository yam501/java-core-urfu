package lr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Задание 6.
 * В кругу стоят N человек (1..N). При счёте по кругу вычёркивается каждый второй,
 * пока не останется один. Две реализации: ArrayList и LinkedList.
 * Сравнение времени выполнения.
 */
public class Example10 {

    static int josephus(List<Integer> people) {
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
            if (index == people.size()) {
                index = 0;
            }
        }
        return people.get(0);
    }

    static List<Integer> buildList(int n, boolean linked) {
        List<Integer> list = linked ? new LinkedList<>() : new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество людей N: ");
        int n = sc.nextInt();

        // ArrayList
        List<Integer> al = buildList(n, false);
        long start = System.currentTimeMillis();
        int survivorAL = josephus(al);
        long timeAL = System.currentTimeMillis() - start;

        // LinkedList
        List<Integer> ll = buildList(n, true);
        start = System.currentTimeMillis();
        int survivorLL = josephus(ll);
        long timeLL = System.currentTimeMillis() - start;

        System.out.println("ArrayList  — выживший: " + survivorAL + ", время: " + timeAL + " мс");
        System.out.println("LinkedList — выживший: " + survivorLL + ", время: " + timeLL + " мс");
        System.out.println("\nВывод: ArrayList обычно быстрее LinkedList для этой задачи,");
        System.out.println("так как remove(index) у LinkedList требует O(n) для поиска узла,");
        System.out.println("плюс накладные расходы на хранение указателей и кэш-промахи.");
        sc.close();
    }
}
