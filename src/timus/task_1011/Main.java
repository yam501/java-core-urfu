package timus.task_1011;

import java.util.Scanner;

public class Main {

    static long parseHundredths(String s) {
        s = s.trim();
        int dot = s.indexOf('.');
        if (dot == -1) {
            return Long.parseLong(s) * 100;
        }
        String intPart = s.substring(0, dot);
        String fracPart = s.substring(dot + 1);
        while (fracPart.length() < 2) {
            fracPart += "0";
        }
        return Long.parseLong(intPart) * 100 + Long.parseLong(fracPart.substring(0, 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long pNum = parseHundredths(sc.next());
        long qNum = parseHundredths(sc.next());

        for (long n = 1; n <= 20000; n++) {
            long kMin = (pNum * n) / 10000 + 1;
            if (10000L * kMin < qNum * n) {
                System.out.println(n);
                return;
            }
        }
    }
}
