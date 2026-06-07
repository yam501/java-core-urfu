package timus.task_1513;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        BigInteger[] g = new BigInteger[N + 1];
        g[0] = BigInteger.ONE;
        BigInteger windowSum = BigInteger.ONE;

        for (int i = 1; i <= N; i++) {
            g[i] = i <= K ? windowSum.add(BigInteger.ONE) : windowSum;

            windowSum = windowSum.add(g[i]);
            int removeIdx = i - K - 1;
            if (removeIdx >= 0) {
                windowSum = windowSum.subtract(g[removeIdx]);
            }
        }

        System.out.println(g[N]);
    }
}
