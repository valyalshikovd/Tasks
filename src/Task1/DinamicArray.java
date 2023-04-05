package Task1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DinamicArray<T> implements Collection<T> {    //имплементировал интерфес collection т.е у меня здесь описаны
    private T[] base; //основа коллекции простой массив         //почти все методы которые есть у других коллекциях java
    private int capacity; //размер массива до переполнения

    public T[] getBase() {
        return base;
    }  //геттер и сеттер на массив в основе

    public void setBase(T[] base) {
        this.base = base;
    }

    public DinamicArray() {
        this.capacity = 10;                          //первый конструктор (по условию по умолчанию вместимость должна быть 10)
        this.base = (T[]) new Object[capacity];
    }

    public DinamicArray(int capacity) {
        this.capacity = capacity;                  //конструктор где в параметр передаем вместимость
        this.base = (T[]) new Object[capacity];
    }

    @Override
    public boolean add(T elem) {
        for (int i = 0; i < capacity; i++) {
            if (base[i] == null) {                   //добавление элемента
                base[i] = elem;         //перебираем все элементы в массиве пока не найдем пустую клетку
                return true;
            }
        }
        capacity = capacity * 2;    //если клетку не нашли увеличиваем вместимость в два раза
        T[] newBase = (T[]) new Object[capacity]; // и срздаем новый основной массив с увеличенным в 2 раза размером
        for (int i = 0; i < base.length; i++) {
            newBase[i] = base[i];                       //перемещаем в него все элементы из старой базы
        }
        base = newBase;
        for (int i = 0; i < capacity; i++) {
            if (base[i] == null) {                 //добавляем элемент в пустое место
                base[i] = elem;
                return true;
            }                         //сейчас постфактум смотрю и понимаю, что можно улучшить но так работает
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        T[] res = (T[]) new Object[base.length];        //удаление объектов по значению
        int counter = 0;
        for (int i = 0; i < base.length; i++){           //метод удаляет ВСЕ объекты равные переданному в аргумент
            if(Objects.equals(base[i], o)){
                base[i] = null;            //перебираем массив до того момента пока не найдем совпадение с тем что надо
                counter++;
            }else{
                res[i - counter] = base[i];     //как только находим элемент сдвигаем все что после него
            }
        }
        base = res;
        return true;
    }
    public boolean removeFirst(T o) {
        T[] res = (T[]) new Object[base.length];
        int counter = 0;
        boolean flag = true;
        for (int i = 0; i < base.length; i++){           //просто удаляет первый элемент и двигает все остальные
            if(Objects.equals(base[i], o) && flag){        //элементы
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
    public boolean addAll(Collection<? extends T> c) {
        for (T i : c){
            this.add(i);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public void clear() {
        T[] newBase = (T[]) new Object[10];
        base = newBase;
    }


    @Override
    public Stream stream() {
        return Arrays.stream(base);
    }



    @Override
    public boolean removeAll(Collection c) {
        for (Object i : c){
            this.remove(i);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object i : c){
            boolean flag = false;
            for (T j : base){
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
        for (T i : base) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        int counter = 0;
        for (T i : base) {
            if (i != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        for (T i : base) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (T i : base) {
            if (Objects.equals(i, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public T get(Integer i){
        return base[i];
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




}

