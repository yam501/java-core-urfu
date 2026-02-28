package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int nMinus1 = n - 1;
        int nPlus1 = n + 1;

        int sumFirstThree = nPlus1 + nMinus1 + n;
        int fourthNumber = sumFirstThree * sumFirstThree;

        System.out.println("Последовательность чисел: " + nMinus1 + ", " + n + ", " + nPlus1 + "," + fourthNumber);
    }
}
