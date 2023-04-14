package MyBinaryTree;

import com.sun.source.tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<Integer>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(0);
        tree.add(2);
        tree.add(9);
        tree.add(25);
        tree.add(23);
        tree.add(12);
        tree.add(10);
        tree.add(15);
        tree.add(111);
        tree.add(13);
        tree.add(1243);
        tree.add(112);
        tree.add(156);
        tree.write();
        System.out.println();
        tree.remove(156);

        tree.write();
    }
}
