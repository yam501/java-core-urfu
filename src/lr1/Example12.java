package lr1;

import java.time.LocalDate;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        System.out.print("Введите номер вашего месяца рождения (1-12): ");
        int birthMonth = scanner.nextInt();

        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentMonth = today.getMonthValue();

        int birthYear = currentYear - age;
        if (birthMonth > currentMonth) {
            birthYear -= 1;
        }

        System.out.println("Ваш год рождения: " + birthYear);
    }
}
