package lr7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Задача 3: считать текстовый файл и вывести на экран количество строк в нём
 */
public class Task3 {

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

        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        System.out.println("Количество строк в файле: " + lineCount);
    }
}
