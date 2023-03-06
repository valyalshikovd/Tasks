package Task2;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>(new LinkedListNode<>(10));
        list1.add(1);
        list1.add(23);
        list1.add(54);
        list1.add(432);
        list1.add(433);

   //     new MyFrame();

        MyLinkedList<Integer> list2 = new MyLinkedList<>(new LinkedListNode<>(11));
        list2.add(4);
        list2.add(32);
        list2.add(450);
        list2.add(451);
        unity(list1, list2).printLinked();
    }
    public static MyLinkedList unity(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2 ){
        MyLinkedList<Integer> res = new MyLinkedList<>();
        LinkedListNode currentNode1 = list1.getFirstElement();
        LinkedListNode currentNode2 = list2.getFirstElement();
        while(!Objects.equals(currentNode1.getLink(), null) && !Objects.equals(currentNode2.getLink(), null)){
            if((Integer) currentNode1.getValue() < (Integer) currentNode2.getValue()){
                res.add(currentNode1.getValue());
                System.out.println("антихайп");
                res.printLinked();
                boolean flag = true;
                while (flag && !Objects.equals(currentNode1.getLink(), null) && !Objects.equals(currentNode2.getLink(), null)){
                    if((Integer) currentNode1.getLink().getValue() < (Integer) currentNode2.getValue()){
                        res.add(currentNode1.getLink().getValue());
                        res.printLinked();
                        currentNode1 = currentNode1.getLink();
                    }else{
                        flag = false;
                        currentNode1 = currentNode1.getLink();
                        res.add(currentNode2.getValue());
                        res.printLinked();
                        currentNode2 = currentNode2.getLink();
                    }

                }
            }else{
                res.add(currentNode2.getValue());
                System.out.println("антихайп2");
                res.printLinked();

                boolean flag = true;
                while (flag && !Objects.equals(currentNode1.getLink(), null) && !Objects.equals(currentNode2.getLink(), null)){
                    if((Integer) currentNode2.getLink().getValue() < (Integer) currentNode1.getValue()){
                        res.add(currentNode2.getLink().getValue());
                        res.printLinked();
                        currentNode2 = currentNode2.getLink();
                    }else{
                        flag = false;
                        currentNode2 = currentNode2.getLink();
                        res.add(currentNode1.getValue());
                        res.printLinked();
                        currentNode1 = currentNode1.getLink();
                    }

                }
            }
        }
        if (Objects.equals(currentNode1.getLink(), null)) {
            while(currentNode2.nextExist()){
                res.add(currentNode2.getValue());
                currentNode2 = currentNode2.getLink();
            }
        }
        if (Objects.equals(currentNode2.getLink(), null)) {
            while(currentNode1.nextExist()){
                res.add(currentNode1.getValue());
                currentNode1 = currentNode1.getLink();
            }
        }
        return res;
    }
}