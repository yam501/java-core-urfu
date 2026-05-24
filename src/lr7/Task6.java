package lr7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Задача 6: ввести два имени файла и слово для поиска; вывести строки, содержащие это слово и сохранить результат во второй файл
 */
public class Task6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к файлу для поиска: ");
        String srcPath = sc.nextLine();
        System.out.print("Введите слово для поиска: ");
        String word = sc.nextLine();
        System.out.print("Введите путь к файлу для сохранения результата: ");
        String outPath = sc.nextLine();
        sc.close();

        File src = new File(srcPath);
        if (!src.exists()) {
            System.out.println("Файл не найден: " + srcPath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(src));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
            String line;
            int found = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println(line);
                    bw.write(line);
                    bw.newLine();
                    found++;
                }
            }
            System.out.println("Найдено строк: " + found + ". Результат сохранён в: " + outPath);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
