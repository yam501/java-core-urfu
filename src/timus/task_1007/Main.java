package timus.task_1007;

import java.io.*;

public class Main {

    static int N, mod;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                N = Integer.parseInt(line);
                break;
            }
        }
        mod = N + 1;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            sb.append(processWord(line)).append('\n');
        }

        System.out.print(sb);
    }

    static String processWord(String word) {
        int len = word.length();

        if (len == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (word.charAt(i) == '1') {
                    sum += i + 1;
                }
            }
            if (sum % mod == 0) {
                return word;
            }
            for (int i = 0; i < N; i++) {
                if (word.charAt(i) == '1' && (sum - i - 1) % mod == 0) {
                    return word.substring(0, i) + '0' + word.substring(i + 1);
                }
            }

        } else if (len == N - 1) {
            int[] prefixSum = new int[N];
            for (int k = 1; k < N; k++) {
                prefixSum[k] = prefixSum[k - 1] + (word.charAt(k - 1) == '1' ? k : 0);
            }

            int[] suffixSum = new int[N];
            int[] suffixCount = new int[N];
            for (int j = N - 2; j >= 0; j--) {
                suffixSum[j] = suffixSum[j + 1] + (word.charAt(j) == '1' ? j + 1 : 0);
                suffixCount[j] = suffixCount[j + 1] + (word.charAt(j) == '1' ? 1 : 0);
            }

            for (int k = 1; k <= N; k++) {
                int ps = prefixSum[k - 1];
                int ss = suffixSum[k - 1];
                int sc = suffixCount[k - 1];
                if ((ps + ss + sc) % mod == 0) {
                    return word.substring(0, k - 1) + '0' + word.substring(k - 1);
                }
                if ((ps + k + ss + sc) % mod == 0) {
                    return word.substring(0, k - 1) + '1' + word.substring(k - 1);
                }
            }

        } else if (len == N + 1) {
            int totalSum = 0;
            for (int i = 0; i < N + 1; i++) {
                if (word.charAt(i) == '1') totalSum += i + 1;
            }
            int[] suffixOnes = new int[N + 2];
            for (int i = N; i >= 0; i--) {
                suffixOnes[i] = suffixOnes[i + 1] + (word.charAt(i) == '1' ? 1 : 0);
            }
            for (int k = 1; k <= N + 1; k++) {
                int sumNew = totalSum - (word.charAt(k - 1) == '1' ? k : 0) - suffixOnes[k];
                if (sumNew % mod == 0) {
                    return word.substring(0, k - 1) + word.substring(k);
                }
            }
        }

        return word;
    }
}
