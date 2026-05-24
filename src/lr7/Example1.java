package lr7;

import java.io.File;
import java.io.IOException;

public class Example1 {

    public static void main(String[] args) throws IOException {
        File folder = new File("src/lr7/example1/example_folder");
        File file = new File(folder, "example_file.txt");

        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getPath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getPath());
        }

        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getPath());
            }
        } else {
            System.out.println("Файл уже существует: " + file.getPath());
        }

        if (file.delete()) {
            System.out.println("Файл удалён: " + file.getName());
        }
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getName());
        }
    }
}
