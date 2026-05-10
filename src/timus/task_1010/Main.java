package timus.task_1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] f = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = Long.parseLong(br.readLine().trim());
        }

        long maxSlope = -1;
        int ansA = 1, ansB = 2;

        for (int i = 1; i < n; i++) {
            long slope = Math.abs(f[i + 1] - f[i]);
            if (slope > maxSlope) {
                maxSlope = slope;
                ansA = i;
                ansB = i + 1;
            }
        }

        System.out.println(ansA + " " + ansB);
    }
}
