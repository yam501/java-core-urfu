package lr4;

/**
 * return в блоках try и finally.
 */
public class Example10 {
    public static int m() {
        try {
            System.out.println("0");
            return 15;   // «собирается» вернуть 15, но finally перекрывает
        } finally {
            System.out.println("1");
            return 20;   // перекрывает return из try
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
