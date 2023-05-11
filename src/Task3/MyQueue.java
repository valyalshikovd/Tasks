package Task3;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private Node<T> first; // начало очереди
    private Node<T> last; // конец очереди

    // внутренний класс для узла очереди
    private static class Node<T> {
        private T data; // данные узла
        private Node<T> next; // ссылка на следующий узел

        public Node(T data) {
            this.data = data;
        }
    }
    public void write(){
        System.out.print(" [ ");
        Node curr = first;
        while(curr.next != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println(" ]");
    }

    // добавление элемента в очередь
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    // удаление элемента из очереди
    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    // проверка, пуста ли очередь
    public boolean isEmpty() {
        return first == null;
    }

    // получение размера очереди
    public int size() {
        int count = 0;
        Node<T> current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // получение первого элемента без удаления из очереди
    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("Размер очереди: " + queue.size());
        System.out.println("Первый элемент: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}