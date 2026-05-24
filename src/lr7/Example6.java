package lr7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Example6 {

    private static final String FILE_NAME = "src/lr7/example_file.txt";

    public static void main(String[] args) {
        File file = new File(FILE_NAME);

        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.println("Строка 1: PrintWriter удобен для форматированного вывода.");
            pw.println("Строка 2: методы print() и println() — как у System.out.");
            pw.printf("Строка 3: форматирование — число PI = %.4f%n", Math.PI);
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("Содержимое файла:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        // PrintWriter принимает System.out напрямую
        try (PrintWriter pw = new PrintWriter(System.out)) {
            pw.println("PrintWriter с System.out: вывод в консоль.");
        }

        if (file.delete()) {
            System.out.println("Файл удалён.");
        }
    }
}
