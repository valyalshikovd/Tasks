package Task3;

public class MyPriorityQueue {
    private class QueueNode {
        private String value;
        private QueueNode next;
        private QueueNode before;
        private int size;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public QueueNode getNext() {
            return next;
        }

        public void setNext(QueueNode next) {
            this.next = next;
        }

        public QueueNode getBefore() {
            return before;
        }

        public void setBefore(QueueNode before) {
            this.before = before;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        private QueueNode(String value) {
            this.value = value;
            this.next = null;
            this.before = null;
            this.size = value.length();
        }

        @Override
        public String toString() {
            return "QueueNode{" +
                    "value='" + value + '\'' +
                    '}';
        }
        private boolean nextExist(){
            return next != null;
        }
        private boolean beforeExist(){
            return before != null;
        }
    }
    public QueueNode firstElement;
    public QueueNode lastElement;
    private int size;

    public MyPriorityQueue() {
        this.firstElement = null;
        this.lastElement = null;
        this.size = 0;
    }
    public MyPriorityQueue(String value) {
        QueueNode tmp = new QueueNode(value);
        this.firstElement = tmp;
        this.lastElement = tmp;
        this.size = 1;
    }
    public void add(String value){
        QueueNode tmp = new QueueNode(value);
        if(size == 0){
            firstElement = tmp;
            lastElement = tmp;
        }
        if(size == 1){
            if(firstElement.getSize() >= tmp.getSize()){
            firstElement.setNext(tmp);
            lastElement = tmp;
            tmp.setBefore(firstElement);
            }else{
                tmp.setNext(firstElement);
                firstElement.setNext(null);
                firstElement.setBefore(tmp);
                lastElement = firstElement;
                firstElement = tmp;
            }
        }else{
            QueueNode current = lastElement;
            while(current != null){
                if(current.getSize() >= tmp.getSize()){
                    if(current.nextExist()){
                        tmp.setBefore(current);
                        tmp.setNext(current.getNext());
                        current.getNext().setBefore(tmp);
                        current.setNext(tmp);
                        size++;
                        return;
                    }else{
                        current.setNext(tmp);
                        tmp.setBefore(current);
                        lastElement = tmp;
                        size++;
                        return;
                    }
                }else{
                     current = current.getBefore();
                }

            }
        }
        size++;
    }
    public String pop(){
        String tmp = firstElement.getValue();
        firstElement.getNext().setBefore(null);
        firstElement = firstElement.getNext();
        size --;
        return tmp;
    }
    public String get(){
        return firstElement.getValue();
    }
    public int size(){return size;}

    public void write(){
        QueueNode tmp = firstElement;
        int counter = 0;
        while (tmp != null){
            System.out.print("[" + tmp.value + "], " );
            tmp = tmp.getNext();
            counter++;
            if(counter == 5){
                System.out.println();
                counter = 0;
            }
        }
    }
    public void clear(){
        firstElement = null;
        lastElement = null;
        size = 0;
    }
}
