package MyBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree<T extends Comparable<T>> {

    protected class MyBinaryTreeOperand<T extends Comparable<T>> {
        private T value;
        private MyBinaryTreeOperand<T> leftOperand;
        private MyBinaryTreeOperand<T> rightOperand;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public MyBinaryTreeOperand<T> getLeftOperand() {
            return leftOperand;
        }

        public void setLeftOperand(MyBinaryTreeOperand<T> leftOperand) {
            this.leftOperand = leftOperand;
        }

        public MyBinaryTreeOperand<T> getRightOperand() {
            return rightOperand;
        }

        public void setRightOperand(MyBinaryTreeOperand<T> rightOperand) {
            this.rightOperand = rightOperand;
        }

        public MyBinaryTreeOperand(T value) {
            this.value = value;
            this.leftOperand = null;
            this.rightOperand = null;
        }
    }

    protected MyBinaryTreeOperand<T> root;
    private int size;

    public MyBinaryTreeOperand<T> getRoot() {
        return root;
    }

    public void setRoot(MyBinaryTreeOperand<T> root) {
        this.root = root;
    }

    public int size() {
        return size;
    }

    public MyBinaryTree(T value) {
        this.root = new MyBinaryTreeOperand<T>(value);
        this.size = 1;
    }

    public MyBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(T value) {
        MyBinaryTreeOperand<T> added = new MyBinaryTreeOperand<T>(value);
        size++;
        if (root == null) {
            root = added;
            return;
        }
        recursiveEnumerationToAdd(root, added);

    }

    private void recursiveEnumerationToAdd(MyBinaryTreeOperand<T> curr, MyBinaryTreeOperand<T> added) {
        if (curr.getValue().compareTo(added.getValue()) < 0) {
            if (curr.rightOperand == null) {
                curr.setRightOperand(added);
            } else {
                recursiveEnumerationToAdd(curr.rightOperand, added);
            }
        } else {
            if (curr.leftOperand == null) {
                curr.setLeftOperand(added);
            } else {
                recursiveEnumerationToAdd(curr.leftOperand, added);
            }
        }
    }

    public List<T> toList() {
        ArrayList<T> res = new ArrayList<T>();
        this.recursiveEnumerationToList(root, res);
        return res;
    }

    private void recursiveEnumerationToList(MyBinaryTreeOperand<T> curr, List<T> list) {
        if (curr.leftOperand != null) {
            recursiveEnumerationToList(curr.leftOperand, list);
        }
        list.add(curr.getValue());
        if (curr.rightOperand != null) {
            recursiveEnumerationToList(curr.rightOperand, list);
        }
    }

    public void write() {
        this.recursiveEnumerationToWrite(root);
        System.out.println();
    }

    private void recursiveEnumerationToWrite(MyBinaryTreeOperand<T> curr) {
        if (curr.leftOperand != null) {
            recursiveEnumerationToWrite(curr.leftOperand);
        }
        System.out.print(curr.getValue() + " ");
        if (curr.rightOperand != null) {
            recursiveEnumerationToWrite(curr.rightOperand);
        }
    }

    public void remove(T value) {
        size--;
        if(root.value.compareTo(value) == 0){
            if(root.rightOperand == null && root.leftOperand == null){
                root = null;
                return;
            }
            if(root.rightOperand != null && root.leftOperand == null){
                root = root.rightOperand;
                return;
            }
            if(root.rightOperand == null && root.leftOperand != null){
                root = root.leftOperand;
                return;
            }
            MyBinaryTreeOperand<T> curr = root.rightOperand;
            MyBinaryTreeOperand<T> tmp = root;
            if (curr.leftOperand == null) {
                root = curr;
                root.leftOperand = tmp.leftOperand;
                return;
            } else {
                while (curr.leftOperand != null) {
                    if (curr.leftOperand.leftOperand == null) {
                        root = curr.leftOperand;
                        curr.leftOperand = null;
                        break;
                    }
                    curr = curr.leftOperand;

                }
                root.rightOperand = tmp.rightOperand;
                root.leftOperand = tmp.leftOperand;
                return;
            }
        }

        MyBinaryTreeOperand<T> parent = recursiveEnumerationToSearchParentOperand(root, value);
      //  System.out.println(parent.getValue());
        if(parent.leftOperand != null && parent.leftOperand.getValue() == value){
            helpToDelete(parent, parent.leftOperand, 1);
        }
        if(parent.rightOperand != null && parent.rightOperand.getValue() == value){
            helpToDelete(parent, parent.rightOperand, 0);
        }
    }

    private void helpToDelete(MyBinaryTreeOperand<T> parent, MyBinaryTreeOperand<T> operand, int mode){
        if(operand.leftOperand == null && operand.rightOperand == null){
            if(mode == 1){
                parent.leftOperand = null;
            }else{
                parent.rightOperand = null; // удаление хвоста
            }
            return;
        }
        if(operand.leftOperand != null && operand.rightOperand == null){
            if(mode == 1){
                parent.leftOperand = operand.leftOperand;
            }else{
                parent.rightOperand = operand.leftOperand;
            }
            return;
        }
        if(operand.rightOperand != null && operand.leftOperand == null){
            if(mode == 1){
                parent.leftOperand = operand.rightOperand;
            }else{
                parent.rightOperand = operand.rightOperand;
            }
            return;
        }
        MyBinaryTreeOperand<T> curr = operand.rightOperand;
        MyBinaryTreeOperand<T> tmp = operand;
        if(curr.leftOperand == null){
            if(mode == 1){
                curr.leftOperand = tmp.leftOperand;
                parent.leftOperand = curr;
            }else{
                curr.leftOperand = tmp.leftOperand;
                parent.rightOperand = curr;
            }
          //  parent.leftOperand.rightOperand = tmp.rightOperand;
            return;
        }
        if(curr.leftOperand.leftOperand == null){
            if(mode == 1){
                parent.leftOperand = curr.leftOperand;
            }else{
                parent.rightOperand = curr.leftOperand;
            }
            parent.rightOperand.rightOperand = tmp.rightOperand;
            return;
        }
        while(curr.leftOperand.leftOperand != null){
            curr = curr.leftOperand;
        }
        if(mode == 1){
            parent.leftOperand = curr.leftOperand;
        }else{
            parent.rightOperand = curr.leftOperand;
        }
        curr.leftOperand = null;
        if(mode == 1){
            parent.leftOperand.rightOperand = tmp.rightOperand;
            parent.leftOperand.leftOperand = tmp.leftOperand;
        }else{
            parent.rightOperand.rightOperand = tmp.rightOperand;
            parent.rightOperand.leftOperand = tmp.leftOperand;
        }



    }

    private MyBinaryTreeOperand<T> recursiveEnumerationToSearchParentOperand(MyBinaryTreeOperand<T> curr, T
            value) {

        if (curr.leftOperand != null && curr.leftOperand.getValue().compareTo(value) == 0) {
            return curr;
        }
        if (curr.rightOperand != null && curr.rightOperand.getValue().compareTo(value) == 0) {
            return curr;
        }
        if (curr.rightOperand == null && curr.leftOperand == null) {

            return null;
        }

        if (curr.getValue().compareTo(value) < 0) {
            return recursiveEnumerationToSearchParentOperand(curr.rightOperand, value);
        }
        if (curr.getValue().compareTo(value) > 0) {
            return recursiveEnumerationToSearchParentOperand(curr.leftOperand, value);
        }
        return null;
    }


}