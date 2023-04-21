package Task5;
import MyBinaryTree.MyBinaryTree;

public class SolutionTree<T extends Comparable<T>> extends MyBinaryTree<T>{

    public boolean equals(MyBinaryTree<T> tree) {
        return this.recursiveEnumerationToEquals(this.root , tree.getRoot());
    }

    private boolean recursiveEnumerationToEquals(MyBinaryTreeOperand<T> frstCrr, MyBinaryTreeOperand<T> secondCrr) {

        if (frstCrr.getLeftOperand() != null && secondCrr.getLeftOperand() != null){

            if(frstCrr.getLeftOperand().getValue().compareTo(secondCrr.getLeftOperand().getValue()) != 0){
                return false;
            }
            if(!recursiveEnumerationToEquals(frstCrr.getLeftOperand(), secondCrr.getLeftOperand())){
                return false;
            };
        }
        if (frstCrr.getRightOperand() != null && secondCrr.getRightOperand() != null){

            if(frstCrr.getRightOperand().getValue().compareTo(secondCrr.getRightOperand().getValue()) != 0){
                return false;
            }
            if(!recursiveEnumerationToEquals(frstCrr.getRightOperand(), secondCrr.getRightOperand())){
                return false;
            };
        }
        return true;
    }
}
