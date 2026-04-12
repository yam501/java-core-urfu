package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Вычисление суммы элементов типа byte одномерного массива.
 */
public class Task3 {

    // Диапазон byte: -128..127
    static final int BYTE_MIN = Byte.MIN_VALUE; // -128
    static final int BYTE_MAX = Byte.MAX_VALUE; // 127

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = sc.nextInt();

            byte[] arr = new byte[n];
            System.out.println("Введите элементы массива (диапазон byte: " + BYTE_MIN + ".." + BYTE_MAX + "):");
            for (int i = 0; i < n; i++) {
                System.out.print("arr[" + i + "] = ");
                int val = sc.nextInt();
                if (val < BYTE_MIN || val > BYTE_MAX) {
                    throw new ArithmeticException(
                            "Значение " + val + " выходит за диапазон byte [" + BYTE_MIN + ", " + BYTE_MAX + "]"
                    );
                }
                arr[i] = (byte) val;
            }

            int sum = 0;
            for (byte b : arr) {
                sum += b;
            }

            if (sum < BYTE_MIN || sum > BYTE_MAX) {
                throw new ArithmeticException(
                        "Сумма " + sum + " выходит за диапазон byte [" + BYTE_MIN + ", " + BYTE_MAX + "]"
                );
            }

            byte result = (byte) sum;
            System.out.println("Сумма элементов: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа.");
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
