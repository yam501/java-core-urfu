package timus.task_1001;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();

        while (scanner.hasNextLong()) {
            numbers.add(scanner.nextLong());
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            long value = numbers.get(i);

            double sqrtValue = Math.sqrt((double) value);

            System.out.printf("%.4f%n", sqrtValue);
        }

        scanner.close();
    }
}