package helpForOleg;

import java.util.Comparator;

public class Main {
    static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()){
                return 0;
            }
            else if(o1.length() > o2.length()){
                return -1;
            }else{
                return 1;
            }
        }
    };
    public static void main(String[] args){

        PriotityQueueBasedOnMyList<String> queue = new PriotityQueueBasedOnMyList<>("sdsdsdsd", comparator);
        queue.add("23");
        queue.add("wewerwrw");
        queue.add("eww");
        queue.add("hui");
        queue.add("23w");

        for (int i = 0; i < queue.size;){
            System.out.println(queue.popIndex(0));
        }
    }
}
