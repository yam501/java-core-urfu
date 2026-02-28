package timus.task_1510;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int candidate = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();

            if (count == 0) {
                candidate = k;
                count = 1;
            } else if (k == candidate) {
                count++;
            } else {
                count--;
            }
        }

        System.out.println(candidate);
    }
}
