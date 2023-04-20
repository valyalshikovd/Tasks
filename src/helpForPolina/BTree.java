package helpForPolina;

public class BTree<T extends Comparable<T>> {

    private class BtreeOperand<T extends Comparable<T>>{
        protected T value;
        protected BtreeOperand<T> left;
        protected BtreeOperand<T> right;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public BtreeOperand<T> getLeft() {
            return left;
        }

        public void setLeft(BtreeOperand<T> left) {
            this.left = left;
        }

        public BtreeOperand<T> getRight() {
            return right;
        }

        public void setRight(BtreeOperand<T> right) {
            this.right = right;
        }

        public BtreeOperand(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private BtreeOperand<T> root;

    public BTree(T root) {
        this.root = new BtreeOperand<>(root);
    }
    public BTree() {
        this.root = null;
    }

    public void add(T value){
        BtreeOperand<T> current = root;
        BtreeOperand<T> added = new BtreeOperand<>(value);

        while(current != null){
            if(added.getValue().compareTo(current.getValue()) > 0){
                if(current.right == null){
                    break;
                }
                current = current.right;
            }else{
                if(current.left == null){
                    break;
                }
                current = current.left;
            }
        }
        if(added.getValue().compareTo(current.value) > 0){
            current.right = added;
        }else {
            current.left = added;
        }
    }

    public void write(){
        recursiveEnumeratedToWrite(root);
    }
    private void recursiveEnumeratedToWrite(BtreeOperand<T> current){

        if(current.left != null){
            recursiveEnumeratedToWrite(current.left);
        }
        System.out.print(current.getValue() + " ");
        if(current.right != null){
            recursiveEnumeratedToWrite(current.right);
        }
    }
    public void solution(){
        BtreeOperand<T> current = root;

        while(current.left != null){
                current = current.left;
            }
        System.out.println(current.value);
    }
}
