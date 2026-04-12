package lr4;

/**
 * Перехват исключения подходящим классом.
 * RuntimeException → перехватывается catch(Exception e), т.к. Exception — предок RuntimeException.
 * catch(Error e) не задействован — Error и Exception разные ветки иерархии.
 */
public class Example4 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
        } catch (Error e) {
            System.out.println("3");
        }
        System.out.println("4");
    }
}
