package lr7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2 {

    private static final String FILE_NAME = "src/lr7/example_file.txt";

    public static void main(String[] args) {
        String data = "Hello, Java I/O!";
        File file = new File(FILE_NAME);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes());
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            int read = fis.read(buffer);
            System.out.println("Прочитано байт: " + read);
            System.out.println("Содержимое файла: " + new String(buffer));
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (file.delete()) {
            System.out.println("Файл удалён.");
        }
    }
}
