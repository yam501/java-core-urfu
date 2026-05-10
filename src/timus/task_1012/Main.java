package timus.task_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());

        BigInteger kMinus1 = BigInteger.valueOf(k - 1);

        BigInteger endZero = BigInteger.ZERO;
        BigInteger endNonZero = kMinus1;

        for (int i = 2; i <= n; i++) {
            BigInteger newEndZero = endNonZero;
            BigInteger newEndNonZero = endZero.add(endNonZero).multiply(kMinus1);
            endZero = newEndZero;
            endNonZero = newEndNonZero;
        }

        System.out.println(endZero.add(endNonZero));
    }
}
