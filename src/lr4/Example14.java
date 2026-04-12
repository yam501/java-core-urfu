package lr4;

/**
 * Оператор throws — метод объявляет, что может бросить исключение
 */
public class Example14 {
    public static void m(int x) throws ArithmeticException {
        int h = 10 / x; // ArithmeticException если x == 0
    }

    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}
