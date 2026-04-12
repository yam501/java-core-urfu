package lr4;

/**
 * Исключение перехвачено перехватчиком предка (Exception ловит RuntimeException).
 */
public class Example2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
            // System.out.println("1"); // недостижимый код — ошибка компилятора
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}
