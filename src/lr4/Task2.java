package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Вывести столбец матрицы с номером, введённым с клавиатуры.
 */
public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите количество строк матрицы: ");
            int rows = sc.nextInt();

            System.out.print("Введите количество столбцов матрицы: ");
            int cols = sc.nextInt();

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("matrix[" + i + "][" + j + "] = ");
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.print("Введите номер столбца (от 0 до " + (cols - 1) + "): ");
            int col = sc.nextInt();

            System.out.println("Столбец " + col + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][col]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа.");
            System.out.println("Класс исключения: " + e.getClass().getName());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: столбца с таким номером не существует.");
            System.out.println("Класс исключения: " + e.getClass().getName());
        } finally {
            System.out.println("Программа завершена.");
            sc.close();
        }
    }
}
