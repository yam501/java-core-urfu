package lr7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Задача 8: сохранить объект класса Student в файл и восстановить его, класс реализует Serializable и содержит несколько полей
 */
public class Task8 {

    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String name;
        private final int age;
        private final double gpa;

        Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return String.format("Student{name='%s', age=%d, gpa=%.2f}", name, age, gpa);
        }
    }

    private static final String FILE_NAME = "src/lr7/student.ser";

    public static void main(String[] args) {
        Student original = new Student("Мария", 22, 4.8);
        System.out.println("Исходный объект: " + original);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(original);
            System.out.println("Объект сохранён в файл: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Student restored = (Student) ois.readObject();
            System.out.println("Восстановленный объект: " + restored);
            System.out.println("  Имя:    " + restored.name);
            System.out.println("  Возраст: " + restored.age);
            System.out.println("  GPA:    " + restored.gpa);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }

        new File(FILE_NAME).delete();
    }
}
