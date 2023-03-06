package Task1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DinamicArray<T> implements Collection {
    private Object[] base;
    private int capacity;

    public Object getBase() {
        return base;
    }

    public void setBase(Object[] base) {
        this.base = base;
    }

    public DinamicArray() {
        this.capacity = 10;
        this.base = new Object[capacity];
    }

    public DinamicArray(int capacity) {
        this.capacity = capacity;
        this.base = new Object[capacity];
    }

    @Override
    public boolean add(Object elem) {
        for (int i = 0; i < capacity; i++) {
            if (base[i] == null) {
                base[i] = elem;
                return true;
            }
        }
        capacity = capacity * 2;
        Object[] newBase = new Object[capacity];
        for (int i = 0; i < base.length; i++) {
            newBase[i] = base[i];
        }
        base = newBase;
        for (int i = 0; i < capacity; i++) {
            if (base[i] == null) {
                base[i] = elem;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Object[] res = new Object[base.length];
        int counter = 0;
        for (int i = 0; i < base.length; i++){
            if(Objects.equals(base[i], o)){
                base[i] = null;
                counter++;
            }else{
                res[i - counter] = base[i];
            }
        }
        base = res;
        return true;
    }
    public boolean removeFirst(Object o) {
        Object[] res = new Object[base.length];
        int counter = 0;
        boolean flag = true;
        for (int i = 0; i < base.length; i++){
            if(Objects.equals(base[i], o) && flag){
                base[i] = null;
                counter++;
                flag = false;
            }else{
                res[i - counter] = base[i];
            }
        }
        base = res;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object i : c){
            this.add(i);
        }
        return true;
    }


    @Override
    public void clear() {
        Object[] newBase = new Object[base.length];
        base = newBase;
    }


    @Override
    public Stream stream() {
        return Arrays.stream(base);
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object i : c){
            this.remove(i);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object i : c){
            boolean flag = false;
            for (Object j : base){
                if(Objects.equals(i, j)){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                return false;
            }
        }
        return true;
    }

    public void printDinamicArray() {
        for (Object i : base) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        int counter = 0;
        for (Object i : base) {
            if (i != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        for (Object i : base) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (Object i : base) {
            if (Objects.equals(i, 0)) {
                return true;
            }
        }
        return false;
    }





    @Override
    public Object[] toArray() {
    Object[] res = new Object[this.size()];
    int counter = 0;
        for (int i = 0; i < this.size(); i++) {
            if (base[i] != null) {
                res[i - counter] = base[i];
            }else {
                counter++;
            }
        }
        return res;
    }

    @Override
    public Object[] toArray(Object[] a) {
        a = new Object[this.size()];
        int counter = 0;
        for (int i = 0; i < this.size(); i++) {
            if (base[i] != null) {
                a[i - counter] = base[i];
            }else {
                counter++;
            }
        }
        return a;
    }
/////////////////////////////////////////////////////////////////////////
@Override
public Iterator iterator() {
    return null;
}

    @Override
    public void forEach(Consumer action) {
        Collection.super.forEach(action);
    }
    @Override
    public Object[] toArray(IntFunction generator) {
        return Collection.super.toArray(generator);
    }
    @Override
    public Stream parallelStream() {
        return Collection.super.parallelStream();
    }
    @Override
    public Spliterator spliterator() {
        return Collection.super.spliterator();
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return Collection.super.removeIf(filter);
    }



}

