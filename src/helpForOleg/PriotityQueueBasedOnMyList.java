package helpForOleg;

import Task3.MyPriorityQueue;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class PriotityQueueBasedOnMyList<T> extends MyLinkedList<T>{
    private Comparator<T> comparator;
    public PriotityQueueBasedOnMyList(Comparator<T> comparator) {
    }
    public PriotityQueueBasedOnMyList(T value, Comparator<T> comparator) {
        super(value);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        System.out.println("Нельзя вызвать это у очереди");
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        System.out.println("Нельзя вызвать это у очереди");
        return null;
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        System.out.println("Нельзя вызвать это у очереди");
        return null;
    }

    @Override
    public boolean add(T value) {
        MyLinkedListNode<T> tmp = new MyLinkedListNode<T>(value, null);
        if (super.size == 0) {
            super.firstElementh = tmp;
        }
        if (size == 1) {
            if (comparator.compare(super.firstElementh.getValue(), tmp.getValue()) > 0) {
                super.firstElementh.setNext(tmp);
            } else {
                tmp.setNext(super.firstElementh);
                super.firstElementh.setNext(null);
                super.firstElementh = tmp;
            }
        } else {
            MyLinkedListNode<T>  current = super.firstElementh;
            while(current.getNext() != null){
                current = current.getNext();
            }
            while (current != null) {
                if (comparator.compare(super.firstElementh.getValue(), tmp.getValue()) > 0) {
                    if (current.nextExist()) {
                        tmp.setNext(current.getNext());
                        current.setNext(tmp);
                        size++;
                        return true;
                    } else {
                        current.setNext(tmp);
                        size++;
                        return true;
                    }
                } else {
                    MyLinkedListNode<T>  current2 = super.firstElementh;
                    while(current2.getNext() != current){
                        current2 = current2.getNext();
                    }
                    current = current2;
                }

            }
        }
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        System.out.println("всегда возвращаю первый элемент");
        return super.getFirstElementh().getValue();
    }

    @Override
    public MyLinkedList<T>.MyLinkedListNode<T> getElementh(int index) {
        return super.getElementh(index);
    }

    @Override
    public void setNextIndex(int index, MyLinkedList<T>.MyLinkedListNode<T> node) {
        super.setNextIndex(index, node);
    }

    @Override
    public MyLinkedList<T>.MyLinkedListNode<T> getFirstElementh() {
        return super.getFirstElementh();
    }

    @Override
    public void insert(int index, MyLinkedList<T>.MyLinkedListNode<T> value) {
        super.insert(index, value);
    }

    @Override
    public void set(int index, T value) {
        super.set(index, value);
    }

    @Override
    public void removeIndex(int index) {
        super.removeIndex(index);
    }

    @Override
    public MyLinkedList<T>.MyLinkedListNode<T> popIndex(int index) {
        System.out.println("ТОЛЬКО ПЕРВЫЙ ЭЛЕМЕНТ");
        return super.popIndex(0);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return super.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    @Override
    public void clear() {
        super.clear();
    }
}

