package lr4;

/**
 * try-finally с оператором return.
 */
public class Example9 {
    public static int m() {
        try {
            System.out.println("0");
            return 55;       // выход из метода — но сначала finally
        } finally {
            System.out.println("1"); // выполняется до фактического возврата
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
