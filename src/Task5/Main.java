package Task5;

import MyBinaryTree.MyBinaryTree;

public class Main {
    public static void main(String[] args){

        SolutionTree<Integer> threeOne = new SolutionTree<>();
        MyBinaryTree<Integer> threeTwo = new SolutionTree<>();

        threeOne.add(4);
        threeOne.add(3);
        threeOne.add(5);
        threeOne.add(6);
        threeOne.add(2);


        threeTwo.add(4);
        threeTwo.add(3);
        threeTwo.add(5);
        threeTwo.add(9);
        threeTwo.add(2);

        System.out.println(threeOne.equals(threeTwo));


    }

}
