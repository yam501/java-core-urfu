package lr7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Example7 {

    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    private static final String FILE_NAME = "src/lr7/person.ser";

    public static void main(String[] args) {
        Person original = new Person("Иван", 30);
        System.out.println("Исходный объект: " + original);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(original);
            System.out.println("Объект сериализован в файл: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Person restored = (Person) ois.readObject();
            System.out.println("Восстановленный объект: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }

        new File(FILE_NAME).delete();
    }
}
