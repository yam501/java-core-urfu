package lr3;

/**
 * Задание 7 (способ 1).
 * Создание однонаправленного списка с ГОЛОВЫ:
 * каждый новый элемент вставляется в начало списка.
 * Результат — порядок обратный порядку ввода.
 */
public class Example11 {

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

        // Создание с головы: новый элемент становится новой головой
        Node head = null;
        for (int v : values) {
            head = new Node(v, head);
        }

        System.out.println("Создание с головы (вставка в начало):");
        System.out.println("Исходные данные: 1, 2, 3, 4, 5");
        System.out.print("Список: ");
        printList(head);
        System.out.println("(порядок обратный, т.к. каждый элемент вставляется в голову)");
    }
}
