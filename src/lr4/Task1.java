package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Вычисление среднего значения среди положительных элементов одномерного массива (тип int).
 *
 */
public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = sc.nextInt();

            int[] arr = new int[n];

            System.out.println("Введите элементы массива (целые числа):");
            for (int i = 0; i < n; i++) {
                System.out.print("arr[" + i + "] = ");
                arr[i] = sc.nextInt();
            }

            int sum = 0, count = 0;
            for (int x : arr) {
                if (x > 0) {
                    sum += x;
                    count++;
                }
            }

            if (count == 0) {
                // деление на ноль — положительных элементов нет
                throw new ArithmeticException("В массиве нет положительных элементов");
            }

            double avg = (double) sum / count;
            System.out.printf("Среднее значение положительных элементов: %.2f%n", avg);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа или несоответствие типа.");
            System.out.println("Класс исключения: " + e.getClass().getName());
        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: размер массива не может быть отрицательным.");
            System.out.println("Класс исключения: " + e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Класс исключения: " + e.getClass().getName());
        } finally {
            System.out.println("Программа завершена.");
            sc.close();
        }
    }
}
