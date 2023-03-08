package Task2;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<T> implements Collection<T> {
    private class MyLinkedListNode<T> {
        private T value;
        private int index;
        private MyLinkedListNode<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public MyLinkedListNode<T> getNext() {
            return next;
        }

        public void setNext(MyLinkedListNode<T> next) {
            this.next = next;
        }

        public MyLinkedListNode(T value, int index, MyLinkedListNode<T> next) {
            this.value = value;
            this.index = index;
            this.next = next;
        }

        private boolean nextExist() {
            return next != null;
        }

        @Override
        public String toString() {
            return "MyLinkedListNode{" +
                    "value=" + value +
                    ", index=" + index +
                    ", next=" + next +
                    '}';
        }

    }

    private MyLinkedListNode<T> firstElementh;

    private int size;

    public MyLinkedList() {
        this.firstElementh = null;

        this.size = 0;
    }

    public MyLinkedList(T value) {
        MyLinkedListNode<T> tmp = new MyLinkedListNode<>(value, 0, null);
        this.firstElementh = tmp;
        this.size = 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        MyLinkedListNode<T> current = firstElementh;
        while (current.nextExist()) {
            if (current.getNext().getValue().equals(o)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            MyLinkedListNode<T> curr = firstElementh;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        MyLinkedListNode<T> current = firstElementh;
        int counter = -1;
        while (current != null) {
            counter++;
            res[counter] = current.getValue();
            current = current.getNext();
        }
        return res;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T value) {
        if (firstElementh == null) {
            MyLinkedListNode<T> tmp = new MyLinkedListNode<>(value, 0, null);
            firstElementh = tmp;
            this.size = 1;
        } else {
            MyLinkedListNode<T> current = firstElementh;
            while (current.nextExist()) {
                current = current.getNext();
            }
            current.setNext(new MyLinkedListNode<>(value, current.getIndex() + 1, null));
            size++;
        }
        return true;
    }

    public T get(int index) {
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < index ; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void set(int index, T value) {
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setValue(value);
    }

    public void removeIndex(int index) {
        if (index == 0) {
            firstElementh = firstElementh.getNext();
            size--;
            return;
        }
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        if (current.getNext().nextExist()) {
            current.setNext(current.getNext().getNext());
        } else {
            current.setNext(null);
        }
        size--;
    }

    @Override
    public boolean remove(Object o) {
        if (firstElementh.getValue().equals(o)) {
            firstElementh = firstElementh.getNext();
        } else {
            MyLinkedListNode<T> current = firstElementh;
            while (!current.getNext().getValue().equals(o)) {
                current = current.getNext();
            }
            if (current.getNext().nextExist()) {
                current.setNext(current.getNext().getNext());
                size--;
            } else {
                current.setNext(null);
                size--;
            }
        }
        return true;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object i : c) {
            boolean fl = false;
            MyLinkedListNode<T> current = firstElementh;
            while (current != null) {
                if (current.getValue().equals(i)) {
                    fl = true;
                    break;
                }
                current = current.getNext();
            }
            if (!fl) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for(T i : c){
            this.add(i);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object i : c){
            this.remove(i);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < size; i++){
            if (!c.contains(current.value)){
                this.removeIndex(i);
            }
            current = current.getNext();
        }
        return true;
    }

    @Override
    public void clear() {
        firstElementh = null;
        size = 0;
    }

}
