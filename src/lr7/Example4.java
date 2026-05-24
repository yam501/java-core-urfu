package lr7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example4 {

    private static final String FILE_NAME = "src/lr7/example_file.txt";

    public static void main(String[] args) {
        String data = "Hello, Buffered I/O!";
        File file = new File(FILE_NAME);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(data);
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.print("Содержимое файла: ");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (file.delete()) {
            System.out.println("Файл удалён.");
        }
    }
}
