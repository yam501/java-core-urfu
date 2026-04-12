package lr4;

/**
 * Последовательность catch должна соответствовать иерархии классов.
 * Предок НЕ должен перехватывать исключения раньше потомков.
 */
public class Example6 {
    public static void main(String[] args) {
        // Демонстрация правильного порядка catch-блоков
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) {   // потомок перед предком — правильно
            System.out.println("2");
        } catch (Exception e) {
            System.out.println("3");
        }
        System.out.println("4");
    }
}
