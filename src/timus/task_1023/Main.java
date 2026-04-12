package timus.task_1023;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();

        long minD = K; // K всегда делится на себя, K >= 3 → L = K-1 всегда валиден

        for (long d = 2; d * d <= K; d++) {
            if (K % d == 0) {
                if (d >= 3 && d < minD) minD = d;
                long kd = K / d;
                if (kd >= 3 && kd < minD) minD = kd;
            }
        }

        System.out.println(minD - 1);
    }
}
