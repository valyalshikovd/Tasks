package MyBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree <T extends Comparable<T>> {

    private class MyBinaryTreeOperand<T extends Comparable<T>>{
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

    private MyBinaryTreeOperand<T> root;
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
    public void add(T value){
        MyBinaryTreeOperand<T> added = new MyBinaryTreeOperand<T>(value);
        size++;
        if(root == null){
            root = added;
            return;
        }
        recursiveEnumerationToAdd(root, added);

    }
    private void recursiveEnumerationToAdd(MyBinaryTreeOperand<T> curr, MyBinaryTreeOperand<T> added){
        if(curr.getValue().compareTo(added.getValue()) < 0) {
            if(curr.rightOperand == null){
                curr.setRightOperand(added);
            }else{
                recursiveEnumerationToAdd(curr.rightOperand, added);
            }
        }else{
            if(curr.leftOperand == null){
                curr.setLeftOperand(added);
            }else{
                recursiveEnumerationToAdd(curr.leftOperand, added);
            }
        }
    }

    public List<T> toList(){
        ArrayList<T> res = new ArrayList<T>();
        this.recursiveEnumerationToList(root, res);
        return res;
    }

    private void recursiveEnumerationToList(MyBinaryTreeOperand<T> curr, List<T> list){
        if(curr.leftOperand != null) {
            recursiveEnumerationToList(curr.leftOperand, list);
        }
        list.add(curr.getValue());
        if(curr.rightOperand != null) {
            recursiveEnumerationToList(curr.rightOperand, list);
        }
    }

    public void write(){
        this.recursiveEnumerationToWrite(root);
    }

    private void recursiveEnumerationToWrite(MyBinaryTreeOperand<T> curr){
        if(curr.leftOperand != null) {
            recursiveEnumerationToWrite(curr.leftOperand);
        }
        System.out.print(curr.getValue() + " ");
        if(curr.rightOperand != null) {
            recursiveEnumerationToWrite(curr.rightOperand);
        }
    }
    public void remove(T value){
        MyBinaryTreeOperand<T> parent = recursiveEnumerationToSearchParentOperand(root, value);
        if ((parent.leftOperand != null && parent.leftOperand.getValue().compareTo(value) == 0)){
            ///// удаление левого листа
            if(parent.leftOperand.leftOperand == null && parent.leftOperand.rightOperand == null){
                parent.leftOperand = null;
                return;
                ///
            }else {

                if (parent.leftOperand.leftOperand != null && parent.leftOperand.rightOperand == null) {
                    parent.leftOperand = parent.leftOperand.leftOperand;
                    return;
                }

                if (parent.leftOperand.rightOperand != null && parent.leftOperand.leftOperand == null) {
                    parent.leftOperand = parent.leftOperand.rightOperand;
                    return;
                }
            }

            if (parent.leftOperand.leftOperand != null && parent.leftOperand.rightOperand != null){
                System.out.println("УСЛОВИЕ");
                MyBinaryTreeOperand<T> curr = parent;
                while (curr.rightOperand != null){
                    MyBinaryTreeOperand<T> tmp = curr.leftOperand.leftOperand;
                    curr.leftOperand = curr.leftOperand.rightOperand;
                    curr.leftOperand.leftOperand = tmp;
                    curr = curr.rightOperand;
                }
                return;
            }
        }

        if ((parent.rightOperand != null && parent.rightOperand.getValue().compareTo(value) == 0)){
            //////////удаление правого листа
            if(parent.rightOperand.leftOperand == null && parent.rightOperand.rightOperand == null){
                parent.rightOperand = null;
                ////////
            }else {

                if (parent.rightOperand.leftOperand != null && parent.rightOperand.rightOperand == null) {
                    parent.rightOperand = parent.rightOperand.leftOperand;
                }

                if (parent.rightOperand.rightOperand != null && parent.rightOperand.leftOperand == null) {
                    parent.rightOperand = parent.rightOperand.rightOperand;
                }
            }
            if (parent.rightOperand.leftOperand != null && parent.rightOperand.rightOperand != null){
                System.out.println("УСЛОВИЕ");
                MyBinaryTreeOperand<T> curr = parent;
                while (curr.rightOperand != null){
                    MyBinaryTreeOperand<T> tmp = curr.rightOperand.leftOperand;
                    curr.rightOperand = curr.rightOperand.rightOperand;
                    curr.rightOperand.leftOperand = tmp;
                    curr = curr.rightOperand;
                }
                return;
            }
        }

    }
    private MyBinaryTreeOperand<T> recursiveEnumerationToSearchParentOperand(MyBinaryTreeOperand<T> curr, T value){

        if(curr.leftOperand != null && curr.leftOperand.getValue() == value ){
            return curr;
        }
        if(curr.rightOperand != null && curr.rightOperand.getValue() == value ){
            return curr;
        }
        if(curr.rightOperand == null && curr.leftOperand == null){
            return null;
        }

        if(curr.getValue().compareTo(value) < 0){
            System.out.println("2-st");
            return recursiveEnumerationToSearchParentOperand(curr.rightOperand, value);
        }
        if(curr.getValue().compareTo(value) > 0){
            System.out.println("3-st");
            return recursiveEnumerationToSearchParentOperand(curr.leftOperand, value);
        }
        System.out.println("4-th");
        return null;
    }



}
