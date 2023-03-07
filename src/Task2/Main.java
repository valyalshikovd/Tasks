package Task2;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(13);
        list.add(32);
        list.add(43);
        list.set(1, 111);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(0);
        System.out.println(Arrays.toString(list.toArray()));
    }
}