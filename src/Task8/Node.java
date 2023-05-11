package Task8;

import helpForOleg.MyLinkedList;

import java.util.HashSet;

public class Node {
    public String name;
    public HashSet<Rib> ribs;
    public Integer label;
    public String before;

    public Node(String name) {
        this.name = name;
        this.ribs = new HashSet<>();
        this.label = 2147483646;
        this.before = null;
    }
}
