package lr3;

/**
 * Задание 4.
 * Пример 1 из раздела 2: построить однонаправленный список из 5 узлов
 * (значение поля = номер элемента) и вывести значения полей на экран.
 */
public class Example8 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Создание узлов независимо друг от друга
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        // Связывание узлов в цепочку
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node head = node1;

        // Вывод списка
        System.out.println("Однонаправленный список:");
        Node ref = head;
        while (ref != null) {
            System.out.println("Элемент: " + ref.value);
            ref = ref.next;
        }
    }
}
