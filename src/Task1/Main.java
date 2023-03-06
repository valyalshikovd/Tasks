package Task1;

import Task1.DinamicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> example =  new ArrayList<>();
        example.add(1);
        example.add(2);
        example.add(3);
        example.add(4);
        example.add(5);
        example.add(6);
        example.add(7);
        DinamicArray<Integer> array = new DinamicArray<>(5);
        array.add(23);
        array.add(2);
        array.add(253);
        array.add(75);
        array.add(296);
        array.printDinamicArray();
        array.add(75);
        array.add(42332);
        array.printDinamicArray();
        array.removeFirst(75);
        array.printDinamicArray();
        System.out.println(Arrays.toString(array.toArray()));
        System.out.println(array.size());
        array.addAll(example);
        array.printDinamicArray();
        System.out.println(array.containsAll(example));
    }
}