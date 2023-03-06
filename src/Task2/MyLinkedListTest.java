package Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList<Integer> example = new MyLinkedList<>();


    @Test
    void getFirstElement() {
        example.add(1);
        example.add(3);
        example.add(2);
        assertEquals(1, example.getFirstElement().getValue());
    }

    @Test
    void add() {
        example.add(1);
        example.add(3);
        example.add(2);
        assertEquals(3, example.getE(3).getValue());
    }

    @Test
    void printLinked() {
    }

    @Test
    void size() {
    }

    @Test
    void remove() {
    }

    @Test
    void asArray() {
    }
}