package Task2;

public class MyLinkedList<T> {
    private class MyLinkedListNode<T>{
        private T value;
        private int index;
        private MyLinkedListNode<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public MyLinkedListNode<T> getNext() {
            return next;
        }

        public void setNext(MyLinkedListNode<T> next) {
            this.next = next;
        }

        public MyLinkedListNode(T value, int index, MyLinkedListNode<T> next) {
            this.value = value;
            this.index = index;
            this.next = next;
        }
        private boolean nextExist(){
            return next==null;
        }
    }

    private MyLinkedListNode<T> firstElementh;
    private MyLinkedListNode<T> lastElementh;
    private int size;


}
