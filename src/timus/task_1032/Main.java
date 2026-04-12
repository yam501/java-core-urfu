package timus.task_1032;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        int[] remainderIndex = new int[N];
        Arrays.fill(remainderIndex, -1);
        remainderIndex[0] = 0;

        long prefixSum = 0;
        int ansStart = -1, ansEnd = -1;

        for (int j = 1; j <= N; j++) {
            prefixSum += a[j - 1];
            int r = (int) (prefixSum % N);

            if (remainderIndex[r] != -1) {
                ansStart = remainderIndex[r];
                ansEnd = j - 1;
                break;
            }
            remainderIndex[r] = j;
        }

        StringBuilder sb = new StringBuilder();
        if (ansStart == -1) {
            sb.append(0);
        } else {
            sb.append(ansEnd - ansStart + 1).append('\n');
            for (int i = ansStart; i <= ansEnd; i++) {
                sb.append(a[i]).append('\n');
            }
        }
        System.out.print(sb);
    }
}
