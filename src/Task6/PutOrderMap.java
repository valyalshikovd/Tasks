package Task6;

import MyBinaryTree.MyBinaryTree;
import Task2.MyLinkedList;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class PutOrderMap <K, V> implements Map {
    private class ValueAndOrder<V> {
        int num;
        V value;
        public int getNum() {return num;}
        public void setNum(int num) {
            this.num = num;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "ValueAndOrder{" +
                    "num=" + num +
                    ", value=" + value +
                    '}';
        }
        public ValueAndOrder(int num, V value) {
            this.num = num;
            this.value = value;
        }
    }
    public class KeyAndNumber implements Comparable<KeyAndNumber> {
        K key;
        Integer number;
        public K getKey() {
            return key;
        }

        public void setKey(K key) {this.key = key;}
        public Integer getNumber() {
            return number;
        }
        public void setNumber(Integer number) {
            this.number = number;
        }
        @Override
        public String toString() {
            return "KeyAndNumber{" +
                    "key=" + key +
                    ", number=" + number +
                    '}';
        }
        public KeyAndNumber(K key, Integer number) {
            this.key = key;
            this.number = number;
        }

        @Override
        public int compareTo(KeyAndNumber o) {
            if(this.number == o.number){
                return 0;
            }
            else if(this.number > o.number){
                return 1;
            }else{
                return -1;
            }
        }
    }

    MyDictionary<K, ValueAndOrder> keyDict;
    MyBinaryTree<KeyAndNumber> tree = new MyBinaryTree<KeyAndNumber>();
    Integer counterAdded;
    Integer size;
    public PutOrderMap() {
        this.keyDict = new MyDictionary<>();
        this.counterAdded = 0;
        this.size = 0;
    }

    public void add(K key, V value){
        size++;
        KeyAndNumber added1 = new KeyAndNumber(key, counterAdded);
        ValueAndOrder<V> added2 = new ValueAndOrder<>(counterAdded, value);
        tree.add(added1);
        keyDict.add(key, added2);
        counterAdded++;
    }
    public void write(){
        tree.doing(x -> {
             System.out.print(keyDict.get(x.getKey()));
             return 0;
        });
    }
    public void doing(Function<Object,Integer> function){
        tree.doing(
                function::apply
        );
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keyDict.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return keyDict.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return ((ValueAndOrder<V>)keyDict.get(key)).getValue();
    }

    @Override
    public Object put(Object key, Object value) {
        return ((ValueAndOrder<V>)keyDict.put(key, value)).getValue();
    }

    @Override
    public Object remove(Object key) {
        ValueAndOrder<V> tmp = (ValueAndOrder<V>) keyDict.remove(key);
        tree.remove(new KeyAndNumber((K) key, tmp.num));
       // tree.write();
        return tmp.getValue();
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {
         keyDict.clear();
         tree.clear();

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

}
