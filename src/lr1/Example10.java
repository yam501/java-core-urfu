package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Напишите год рождения: ");
        int date = scanner.nextInt();
        int currentYear = Year.now().getValue();
        int age = currentYear - date;
        System.out.println("Возраст пользователя: " + age + " лет/год");
    }
}
