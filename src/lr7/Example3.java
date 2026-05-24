package lr7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example3 {

    private static final String FILE_NAME = "src/lr7/example_file.txt";

    public static void main(String[] args) {
        String data = "Hello, FileWriter!";
        File file = new File(FILE_NAME);

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (FileReader fr = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            int read = fr.read(buffer);
            System.out.println("Прочитано символов: " + read);
            System.out.println("Содержимое файла: " + new String(buffer));
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (file.delete()) {
            System.out.println("Файл удалён.");
        }
    }
}
