package lr3;

/**
 * Задание 7 (способ 2).
 * Создание однонаправленного списка с ХВОСТА:
 * каждый новый элемент добавляется в конец списка.
 * Результат — порядок совпадает с порядком ввода.
 */
public class Example12 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static void printList(Node head) {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value);
            if (ref.next != null) {
                System.out.print(" -> ");
            }
            ref = ref.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        // Создание с хвоста: новый элемент добавляется в конец
        Node head = null;
        Node tail = null;
        for (int v : values) {
            Node node = new Node(v, null);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.println("Создание с хвоста (добавление в конец):");
        System.out.println("Исходные данные: 1, 2, 3, 4, 5");
        System.out.print("Список: ");
        printList(head);
        System.out.println("(порядок совпадает с порядком ввода)");
    }
}
