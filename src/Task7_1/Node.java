package Task7_1;

import java.util.HashSet;

public class Node {
    public String name;
    public HashSet<Rib> ribs;

    public Integer label;

    public Node(String name) {
        this.name = name;
        this.ribs = new HashSet<>();
        this.label = -1;
    }
}
