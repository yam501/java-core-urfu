package lr4;

/**
 * Нельзя перехватить брошенное исключение из catch с помощью другого catch того же try.
 */
public class Example7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
            throw new ArithmeticException(); // брошено из catch, не из try
        } catch (ArithmeticException e) {
            System.out.println("2"); // не будет достигнут
        }
        System.out.println("3");
    }
}
