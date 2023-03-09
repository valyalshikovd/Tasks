package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>(13);
        list1.add(32);
        list1.add(43);
        MyLinkedList<Integer> list2 = new MyLinkedList<>(10);
        list2.add(152);
        list2.add(20);
        MyLinkedList.solution(list1, list2);
         list1.insert(0, list2.getElementh(0));

        list1.insert(0, list2.getElementh(1));
        list1.insert(0, list2.getElementh(2));
        list1.insert(1, list2.getElementh(0));
        list1.insert(1, list2.getElementh(1));
        list1.insert(1, list2.getElementh(2));
        list1.insert(2, list2.getElementh(0));
        list1.insert(2, list2.getElementh(1));
        list1.insert(2, list2.getElementh(2));
        System.out.println(Arrays.toString(list1.toArray()));
    }


}