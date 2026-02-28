package lr1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        double difference = num1 - num2;

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
    }
}
