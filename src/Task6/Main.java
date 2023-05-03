package Task6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        PutOrderMap<String, Integer> dict = new PutOrderMap<>();
        dict.add("Шесть", 6);
        dict.add("Один", 1);
        dict.add("Два", 2);
        dict.add("Три", 3);
        dict.add("Четыре", 4);
        dict.add("Пять", 5);
      //  dict.write();
        System.out.println();
      //  dict.remove("Пять");
       // dict.write();
        AtomicReference<Integer> counter = new AtomicReference<>(0);



        dict.doing(

                x -> {
                    Integer val = (Integer) dict.get(((PutOrderMap.KeyAndNumber) x).getKey());
                    System.out.print(val + " ");
                    counter.updateAndGet(v -> v + val);
                    return 0;
                }
        );

        System.out.println(counter);


    }
}
