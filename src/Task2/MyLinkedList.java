package Task2;

import Task3.MyQueue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<T> implements Collection<T> {
    public class MyLinkedListNode<T> {
        private T value;
        //      private int index;
        private MyLinkedListNode<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

//        public int getIndex() {
//            return index;
//        }
        //     public void setIndex(int index) {
        //          this.index = index;
        //      }

        public MyLinkedListNode<T> getNext() {
            return next;
        }

        public void setNext(MyLinkedListNode<T> next) {
            this.next = next;
        }

        public MyLinkedListNode(T value, MyLinkedListNode<T> next) {
            this.value = value;
            //this.index = index;
            this.next = next;
        }

        private boolean nextExist() {
            return next != null;
        }

        @Override
        public String toString() {
            return "MyLinkedListNode{" +
                    "value=" + value +
                    //", index=" + index +
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
        MyLinkedListNode<T> tmp = new MyLinkedListNode<>(value, null);
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
    public void write(){
        System.out.print(" [ ");
        MyLinkedListNode<T> curr = firstElementh;
        while(curr.next != null){
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.print(" ]");
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
            MyLinkedListNode<T> tmp = new MyLinkedListNode<>(value, null);
            firstElementh = tmp;
            this.size = 1;
        } else {
            MyLinkedListNode<T> current = firstElementh;
            while (current.nextExist()) {
                current = current.getNext();
            }
            current.setNext(new MyLinkedListNode<>(value, null));
            size++;
        }
        return true;
    }

    public T get(int index) {
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        if (current == null) {
            return null;
        }
        return current.getValue();
    }

    public MyLinkedListNode<T> getElementh(int index) {
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void setNextIndex(int index, MyLinkedListNode<T> node) {
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setNext(node);
    }

    public MyLinkedListNode<T> getFirstElementh() {
        return firstElementh;
    }

    public void insert(int index, MyLinkedListNode<T> value) {
//        System.out.println(value.getValue());
//        System.out.println(value.getNext());
        if (index == 0) {
            value.setNext(firstElementh);
            firstElementh = value;
            size++;
        } else if (index == 1) {
            value.setNext(firstElementh.getNext());
            firstElementh.setNext(value);
            size++;
        } else {
            MyLinkedListNode<T> current = firstElementh;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            value.setNext(current.getNext());
            if (index == size) {
                current.setNext(null);
            } else {
                current.setNext(value);
            }
            //          value.setIndex(index );
            size++;
            //           for(int i = index + 2; i < size; i++){
            //              this.getElementh(i).setIndex(this.getElementh(i).getIndex() + 1);
            //         }

        }


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

    public MyLinkedListNode<T> popIndex(int index) {
        if (index == 0) {
            MyLinkedListNode<T> tmp = firstElementh;
            firstElementh = firstElementh.getNext();
            size--;
            return tmp;
        }
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        MyLinkedListNode<T> tmp = current.getNext();
        if (current.getNext().nextExist()) {
            current.setNext(current.getNext().getNext());
        } else {
            current.setNext(null);
        }
        size--;
        return tmp;
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
        for (T i : c) {
            this.add(i);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object i : c) {
            this.remove(i);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        MyLinkedListNode<T> current = firstElementh;
        for (int i = 0; i < size; i++) {
            if (!c.contains(current.value)) {
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

    public static MyLinkedList<Integer> solution(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2) {
        MyLinkedList<Integer> res = new MyLinkedList<>();
        res.addAll(list1);
        for (int i = 0; i < res.size(); i++) {
            if (list2.get(0) != null && res.get(i) > list2.get(0)) {
                res.insert(i, list2.popIndex(0));
            } else if (list2.get(0) != null && res.get(res.size() - 1) != null) {
                if (res.get(res.size() - 1) < list2.get(0)) {
                    res.getElementh(res.size() - 1).setNext(list2.popIndex(0));
                    res.size++;
                }
            } else {
                System.out.println("Sss");
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

}
