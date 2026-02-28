package lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();

        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();

        System.out.print("Введите отчество: ");
        String middleName = scanner.nextLine();

        System.out.println("Hello " + lastName + ", " + firstName + ", " + middleName);
    }
}
