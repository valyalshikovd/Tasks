package Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList<Integer> list = new MyLinkedList<>(13);

    @Test
    void contains() {
        list.add(15);
        assertTrue(list.contains(15));
        assertFalse(list.contains(16));
    }


    @Test
    void add() {
        list.add(15);
        assertTrue(list.contains(15));
    }

    @Test
    void get() {
        list.add(15);
        assertEquals(13, list.get(0));
        assertEquals(15, list.get(1));
    }

    @Test
    void set() {
        assertEquals(13, list.get(0));
        list.set(0, 15);
        assertEquals(15, list.get(0));
    }
    @Test
    void removeIndex() {
        list.add(15);
        list.add(16);
        list.add(17);
        assertEquals(16, list.get(2));
        list.removeIndex(2);
        assertEquals(17, list.get(2));
    }

    @Test
    void remove() {
        list.add(15);
        list.add(16);
        list.add(17);
        assertEquals(16, list.get(2));
        list.remove(16);
        assertEquals(17, list.get(2));
    }


    @Test
    void containsAll() {
        List<Integer> exmpl = new ArrayList<>();
        exmpl.add(111);
        exmpl.add(43);
        assertFalse(list.containsAll(exmpl));
        list.add(111);
        list.add(43);
        assertTrue(list.containsAll(exmpl));
    }

    @Test
    void addAll() {
        List<Integer> exmpl = new ArrayList<>();
        exmpl.add(111);
        exmpl.add(43);
        assertFalse(list.containsAll(exmpl));
        list.addAll(exmpl);
        assertTrue(list.containsAll(exmpl));
    }

    @Test
    void removeAll() {
        List<Integer> exmpl = new ArrayList<>();
        exmpl.add(111);
        exmpl.add(43);
        list.addAll(exmpl);
        assertTrue(list.containsAll(exmpl));
        list.removeAll(exmpl);
        assertFalse(list.containsAll(exmpl));
    }

    @Test
    void retainAll() {
        List<Integer> exmpl = new ArrayList<>();
        exmpl.add(111);
        exmpl.add(43);
        list.addAll(exmpl);
        Assertions.assertEquals(13, list.get(0));
        list.retainAll(exmpl);
        Assertions.assertEquals(111, list.get(0));
    }

    @Test
    void clear() {
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void insert() {
        MyLinkedList<Integer> exmp = new MyLinkedList<>(13);

        list.add(32);
        list.add(600);
        System.out.println(Arrays.toString(list.toArray()));
        list.insert(2, exmp.getElementh(0));
        System.out.println(Arrays.toString(list.toArray()));
    }
}