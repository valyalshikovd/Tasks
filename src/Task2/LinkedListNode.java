package Task2;

import java.util.Objects;

public class LinkedListNode<T>{
    private T value; //значение
    private LinkedListNode link; //ссылка

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode getLink() {
        if(link!=null){
            return link;
        }
        return null;
    }

    public void setLink(LinkedListNode link) {
        this.link = link;
    }

    public LinkedListNode(T value) {
        this.value = value;
        this.link = null;
    }
    public boolean nextExist(){
        if (!Objects.equals(link, null)){
            return true;
        }else{
            return false;
        }
    }
}
