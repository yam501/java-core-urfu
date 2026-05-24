package lr7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Задача 5: вывести содержимое текстового файла на экран с нумерацией строк
 */
public class Task5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = sc.nextLine();
        sc.close();

        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Файл не найден: " + path);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNum = 1;
            while ((line = br.readLine()) != null) {
                System.out.printf("%4d: %s%n", lineNum++, line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}
