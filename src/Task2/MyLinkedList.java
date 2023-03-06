package Task2;

import java.lang.reflect.Array;

public class MyLinkedList<T>  {
    LinkedListNode<Object> firstElement;
    int counter;

    public MyLinkedList(LinkedListNode<Object> firstElement) {
        this.firstElement = firstElement;
        this.counter = 0;
    }
    public MyLinkedList(){
        this.firstElement = null;
        this.counter = -1;
    }

    public LinkedListNode<Object> getFirstElement() {
        return firstElement;
    }

    public void add(Object value){
        if (firstElement == null){
            firstElement = new LinkedListNode<>(value);
            counter++;
        }
        LinkedListNode<Object> temp = new LinkedListNode<>(value);
        boolean flag = true;
        LinkedListNode<Object> elementh = firstElement;
        while (flag){
            if (elementh.getLink() == null){
                elementh.setLink(temp);
                counter++;
                break;
            }else{
                LinkedListNode<Object> tmp = elementh.getLink();
                elementh = tmp;
            }
      }
    }

    public void printLinked(){
        LinkedListNode<Object> tmp = this.firstElement;
        while (tmp!=null){
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getLink();
        }
        System.out.println();
    }
    public int size(){
        return counter;
    }
    public void remove(Object elem){
        boolean flag = true;
        LinkedListNode<Object> elementh = this.getFirstElement();
        while (flag){
            if (elementh.getLink().getValue() == elem){
                elementh.setLink(elementh.getLink().getLink());
                counter--;
                return;
            }else{
                LinkedListNode<Object> tmp = elementh.getLink();
                elementh = tmp;
            }
        }
    }
    public void remove(LinkedListNode elem){
        boolean flag = true;
        LinkedListNode<Object> elementh = this.getFirstElement();
        while (flag){
            if (elementh.getLink().getValue() == elem.getValue()){
                elementh.setLink(elementh.getLink().getLink());
                counter--;
                return;
            }else{
                LinkedListNode<Object> tmp = elementh.getLink();
                elementh = tmp;
            }
        }
    }
    public Object[] asArray(){
        Object[] res =  new Array[this.size()];
        LinkedListNode<Object> tmp = this.firstElement;
        for (int i = 0; i < this.size(); i++){
            res[i] = tmp.getValue();
            tmp = tmp.getLink();
        }
        return res;
    }
}
