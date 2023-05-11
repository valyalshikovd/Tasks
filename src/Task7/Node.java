package Task7;

import java.util.HashSet;

public class Node {
    public String name;
    public HashSet<Rib> ribs;

    public Node(String name) {
        this.name = name;
        this.ribs = new HashSet<>();
    }
}
