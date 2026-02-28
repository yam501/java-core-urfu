package timus.task_1068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = Math.min(1, n);
        int b = Math.max(1, n);
        System.out.println((a + b) * (b - a + 1) / 2);
    }
}
