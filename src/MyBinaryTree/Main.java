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
        tree.remove(8);
        tree.write();
        tree.remove(10);
        tree.write();
        tree.remove(1);
        tree.write();
        tree.remove(3);
        tree.write();
        tree.remove(25);
        tree.write();


        tree.remove(5);



        tree.write();

        MyBinaryTree<Integer> tree2 = new MyBinaryTree<Integer>();
        tree2.add(5);
        tree2.add(3);
        System.out.println();
        tree2.write();
        tree2.remove(5);
        System.out.println();
        tree2.write();
    }
}
