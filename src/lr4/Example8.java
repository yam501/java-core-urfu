package lr4;

/**
 * Генерация исключения в методе с блоком finally.
 */
public class Example8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1"); // выполняется перед распространением исключения
        }
    }

    public static void main(String[] args) {
        System.out.println(m()); // m() бросает → println не вызывается
    }
}
