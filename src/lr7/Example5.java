package lr7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Example5 {

    private static final String INPUT_FILE  = "src/lr7/input.txt";
    private static final String OUTPUT_FILE = "src/lr7/output.txt";

    public static void main(String[] args) {
        File input = new File(INPUT_FILE);
        if (!input.exists()) {
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(input), StandardCharsets.UTF_8))) {
                bw.write("Привет, мир!");
                bw.newLine();
                bw.write("Hello, World!");
                bw.newLine();
            } catch (IOException e) {
                System.out.println("Ошибка создания input.txt: " + e.getMessage());
                return;
            }
            System.out.println("Создан input.txt для демонстрации.");
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(INPUT_FILE), StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase());
                bw.newLine();
            }
            System.out.println("Файл преобразован. Результат записан в " + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
