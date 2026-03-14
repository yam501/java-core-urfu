package timus.task_1005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] weights = new int[n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            totalSum += weights[i];
        }

        int minDifference = totalSum;

        for (int mask = 0; mask < (1 << n); mask++) {
            int currentSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentSum += weights[i];
                }
            }

            int difference = Math.abs(totalSum - 2 * currentSum);
            if (difference < minDifference) {
                minDifference = difference;
            }
        }

        System.out.println(minDifference);
        scanner.close();
    }
}