package Task2;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {


    public class LinkedListNode<T> {
        private T value;
        private int index;
        private LinkedListNode<T> link;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public LinkedListNode<T> getLink() {
            if (link != null) {
                return link;
            }
            return null;
        }

        public void setLink(LinkedListNode<T> link) {
            this.link = link;
        }

        public LinkedListNode(T value) {
            this.value = value;
            this.link = null;

        }

        public boolean nextExist() {
            return !Objects.equals(link, null);
        }
    }

    private LinkedListNode<T> firstElement;
    private int counter;

    public MyLinkedList(T value) {
        this.firstElement = new LinkedListNode<T>(value);
        this.counter = 0;
    }

    public MyLinkedList() {
        this.firstElement = null;
        this.counter = -1;
    }

    public LinkedListNode<T> getFirstElement() {
        return firstElement;
    }

    public void add(T value) {
        if (firstElement == null) {
            firstElement = new LinkedListNode<T>(value);
            counter++;
        }
        LinkedListNode<T> temp = new LinkedListNode<>(value);
        LinkedListNode<T> elementh = firstElement;
        while (true) {
            if (elementh.getLink() == null) {
                elementh.setLink(temp);
                counter++;
                break;
            } else {
                elementh = elementh.getLink();
            }
        }
    }

    public void get(T elem) {
        LinkedListNode<T> elementh = firstElement;
        while (true) {
            if (elementh.getLink() == null) {
                elementh.setLink(temp);
                counter++;
                break;
            } else {
                elementh = elementh.getLink();
            }
        }
    }

    public void printLinked() {
        LinkedListNode<T> tmp = this.firstElement;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getLink();
        }
        System.out.println();
    }

    public int size() {
        return counter;
    }

    public void remove(T elem) {
        LinkedListNode<T> elementh = this.getFirstElement();
        while (true) {
            if (elementh.getLink().getValue() == elem) {
                elementh.setLink(elementh.getLink().getLink());
                counter--;
                return;
            } else {
                elementh = elementh.getLink();
            }
        }
    }

    public T[] asArray() {
        T[] res = (T[]) new Array[this.size()];
        LinkedListNode<T> tmp = this.firstElement;
        for (int i = 0; i < this.size(); i++) {
            res[i] = tmp.getValue();
            tmp = tmp.getLink();
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {

        class LinkedListIterator implements Iterator<T> {

            LinkedListNode<T> curr = firstElement;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.link;
                return value;
            }
        }
        return new LinkedListIterator();
    }
}
