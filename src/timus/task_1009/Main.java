package timus.task_1009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // dp[0] = count of valid numbers where last digit != 0
        // dp[1] = count of valid numbers where last digit == 0
        long notZero = k - 1; // first digit: 1..K-1, none zero
        long zero = 0;        // first digit can't be 0

        for (int i = 2; i <= n; i++) {
            long newNotZero = (notZero + zero) * (k - 1);
            long newZero = notZero;
            notZero = newNotZero;
            zero = newZero;
        }

        System.out.println(notZero + zero);
    }
}