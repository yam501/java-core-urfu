package lr3;

/**
 * Задание 8.
 * Полная реализация однонаправленного (односвязного) списка со всеми методами:
 *
 * Итеративные:
 *   createHead()   — ввод с головы (элементы в обратном порядке)
 *   createTail()   — ввод с хвоста (элементы в прямом порядке)
 *   toString()     — вывод списка в виде строки
 *   addFirst()     — добавление в начало
 *   addLast()      — добавление в конец
 *   insert(i, v)   — вставка элемента на позицию i
 *   removeFirst()  — удаление с головы
 *   removeLast()   — удаление с хвоста
 *   remove(i)      — удаление элемента с позицией i
 *
 * Рекурсивные:
 *   createHeadRec() — ввод с головы
 *   createTailRec() — ввод с хвоста
 *   toStringRec()   — вывод списка в виде строки
 */
public class Example13 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // ---- Итеративные методы ----

        void createHead(int[] values) {
            head = null;
            for (int v : values) {
                head = new Node(v, head);
            }
        }

        void createTail(int[] values) {
            head = null;
            Node tail = null;
            for (int v : values) {
                Node node = new Node(v, null);
                if (head == null) {
                    head = tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
        }

        @Override
        public String toString() {
            if (head == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            Node cur = head;
            while (cur != null) {
                sb.append(cur.value);
                if (cur.next != null) sb.append(", ");
                cur = cur.next;
            }
            sb.append("]");
            return sb.toString();
        }

        void addFirst(int value) {
            head = new Node(value, head);
        }

        void addLast(int value) {
            Node node = new Node(value, null);
            if (head == null) {
                head = node;
                return;
            }
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

        void insert(int index, int value) {
            if (index == 0) {
                addFirst(value);
                return;
            }
            Node cur = head;
            for (int i = 0; i < index - 1 && cur != null; i++) {
                cur = cur.next;
            }
            if (cur == null) {
                throw new IndexOutOfBoundsException("Индекс выходит за пределы списка: " + index);
            }
            cur.next = new Node(value, cur.next);
        }

        void removeFirst() {
            if (head != null) {
                head = head.next;
            }
        }

        void removeLast() {
            if (head == null) {
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
        }

        void remove(int index) {
            if (head == null) {
                return;
            }
            if (index == 0) {
                removeFirst();
                return;
            }
            Node cur = head;
            for (int i = 0; i < index - 1 && cur.next != null; i++) {
                cur = cur.next;
            }
            if (cur.next == null) {
                return;
            }
            cur.next = cur.next.next;
        }

        // ---- Рекурсивные методы ----

        void createHeadRec(int[] values, int index) {
            if (index >= values.length) {
                return;
            }
            head = new Node(values[index], head);
            createHeadRec(values, index + 1);
        }

        void createTailRec(int[] values, int index) {
            if (index >= values.length) {
                return;
            }
            addLast(values[index]);
            createTailRec(values, index + 1);
        }

        String toStringRec(Node node) {
            if (node == null) {
                return "]";
            }
            if (node == head) {
                return "[" + node.value + toStringRec(node.next);
            }
            return ", " + node.value + toStringRec(node.next);
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] values = {1, 2, 3, 4, 5};

        System.out.println("=== createTail([1,2,3,4,5]) ===");
        list.createTail(values);
        System.out.println(list);

        System.out.println("\n=== addFirst(0) ===");
        list.addFirst(0);
        System.out.println(list);

        System.out.println("\n=== addLast(6) ===");
        list.addLast(6);
        System.out.println(list);

        System.out.println("\n=== insert(3, 99) ===");
        list.insert(3, 99);
        System.out.println(list);

        System.out.println("\n=== removeFirst() ===");
        list.removeFirst();
        System.out.println(list);

        System.out.println("\n=== removeLast() ===");
        list.removeLast();
        System.out.println(list);

        System.out.println("\n=== remove(2) ===");
        list.remove(2);
        System.out.println(list);

        System.out.println("\n=== createHead([1,2,3,4,5]) ===");
        list.createHead(values);
        System.out.println(list);

        System.out.println("\n=== createHeadRec([1,2,3,4,5]) ===");
        list.head = null;
        list.createHeadRec(values, 0);
        System.out.println(list);

        System.out.println("\n=== createTailRec([1,2,3,4,5]) ===");
        list.head = null;
        list.createTailRec(values, 0);
        System.out.println(list);

        System.out.println("\n=== toStringRec ===");
        System.out.println(list.toStringRec(list.head));
    }
}
