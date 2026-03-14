package timus.task_1002;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int k = scanner.nextInt();

        long[][] dp = new long[n + 1][2];

        dp[1][0] = k - 1;
        dp[1][1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) * (k - 1);
            dp[i][1] = dp[i-1][0];
        }

        long result = dp[n][0] + dp[n][1];
        System.out.println(result);

        scanner.close();
    }
}