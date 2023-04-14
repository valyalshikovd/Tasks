package MyBinaryTree;

import com.sun.source.tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<Integer>();
        tree.add(10);
        tree.add(12);
        tree.add(14);
        tree.add(13);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.write();
        System.out.println();
        tree.remove(6);

        tree.write();
    }
}
