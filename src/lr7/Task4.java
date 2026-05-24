package lr7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Задача 4: скопировать содержимое одного текстового файла в другой
 */
public class Task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к исходному файлу: ");
        String srcPath = sc.nextLine();
        System.out.print("Введите путь к файлу назначения: ");
        String dstPath = sc.nextLine();
        sc.close();

        File src = new File(srcPath);
        if (!src.exists()) {
            System.out.println("Исходный файл не найден: " + srcPath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(src));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dstPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Файл скопирован в: " + dstPath);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
