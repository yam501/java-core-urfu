package lr7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Задача 7: ввести имя файла и текст; записать текст в файл и вывести количество записанных символов
 */
public class Task7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = sc.nextLine();
        System.out.print("Введите текст для записи: ");
        String text = sc.nextLine();
        sc.close();

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.print(text);
            System.out.println("Текст записан в файл: " + fileName);
            System.out.println("Количество записанных символов: " + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }
}
