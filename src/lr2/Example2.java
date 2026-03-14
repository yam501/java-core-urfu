package lr2;

public class Example2 {
    public static void main(String[] args) {
        int rows = 4, cols = 5;
        int[][] arr = new int[rows][cols];

        int num = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Чётная строка: слева направо
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = num++;
                }
            } else {
                // Нечётная строка: справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    arr[i][j] = num++;
                }
            }
        }

        // Вывод массива
        for (int[] row : arr) {
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }
    }
}