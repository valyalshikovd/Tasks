package Task2;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

                new MyFrame();
        MyLinkedList<Integer> list1 = new MyLinkedList<>(1);
        list1.addAll(List.of(3, 4, 5, 44, 45));
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.addAll(List.of(5, 13, 14,15,16,17,18,19,20,21,22));
        System.out.println(Arrays.toString(MyLinkedList.solution(list1, list2).toArray()));

    }


}