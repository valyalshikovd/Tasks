package Task1;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DinamicArrayTest {


    DinamicArray<Integer> arr = new DinamicArray<Integer>();


    @org.junit.jupiter.api.Test
    void getBase() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Object[] arrr = new Object[3];
        arrr[0] = 1;
        arrr[1] = 2;
        arrr[2] = 3;
        Assertions.assertEquals(arrr[0], arr.get(0));
        Assertions.assertEquals(arrr[1], arr.get(1));
        Assertions.assertEquals(arrr[2], arr.get(2));
    }

    @org.junit.jupiter.api.Test
    void setBase() {
        Integer[] arrr = new Integer[3];
        arrr[0] = 1;
        arrr[1] = 3;
        arrr[2] = 4;
        arr.setBase(arrr);
        Assertions.assertEquals(arrr[0], arr.get(0));
        Assertions.assertEquals(arrr[1], arr.get(1));
        Assertions.assertEquals(arrr[2], arr.get(2));
    }


    @org.junit.jupiter.api.Test
    void add() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Assertions.assertEquals(3, arr.get(2));
    }

    @org.junit.jupiter.api.Test
    void remove() {

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.remove(2);
        assertNull(arr.get(2));
        Assertions.assertEquals( 3,  arr.get(1));

    }

    @org.junit.jupiter.api.Test
    void removeFirst() {
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(3);
        arr.removeFirst(3);
        assertNull(arr.get(3));
        Assertions.assertEquals( 2,  arr.get(1));
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        List<Integer> r = new ArrayList<>();
        r.add(5);
        r.add(4);
        r.add(3);
        r.add(2);
        arr.addAll(r);
        Assertions.assertEquals( 5,  arr.get(0));
        Assertions.assertEquals( 4,  arr.get(1));
        Assertions.assertEquals( 3,  arr.get(2));
        Assertions.assertEquals( 2,  arr.get(3));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(3);
        arr.clear();
        assertTrue(arr.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void stream() {
        arr.add(1);
        arr.add(3);
        arr.add(2);
        Stream<Integer> stream = arr.stream();
        Assertions.assertEquals( 10,  stream.count());   //10 налл


    }


    @org.junit.jupiter.api.Test
    void removeAll() {
        List<Integer> r = new ArrayList<>();
        r.add(5);
        r.add(4);
        r.add(3);
        r.add(2);
        arr.addAll(r);
        arr.removeAll(r);
        assertTrue(arr.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
        List<Integer> r = new ArrayList<>();
        r.add(5);
        r.add(4);
        r.add(3);
        r.add(2);
        arr.addAll(r);
        assertTrue(arr.containsAll(r));
        arr.remove(2);
        assertFalse(arr.containsAll(r));
    }

    @org.junit.jupiter.api.Test
    void size() {
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(3);
        Assertions.assertEquals(4, arr.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
            arr.add(1);
            arr.add(3);
            arr.add(2);
            arr.add(3);
            arr.clear();
            assertTrue(arr.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        arr.add(2);
        assertTrue(arr.contains(2));
        arr.remove(2);
        assertFalse(arr.contains(2));
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        arr.add(1);
        arr.add(3);
        arr.add(2);
        Integer[] arrr = new Integer[3];
        arrr[0] = 1;
        arrr[1] = 3;
        arrr[2] = 2;
        Assertions.assertArrayEquals(arrr, arr.toArray());
    }
}