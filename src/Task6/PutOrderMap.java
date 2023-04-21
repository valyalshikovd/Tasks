package Task6;

import MyBinaryTree.MyBinaryTree;
import Task2.MyLinkedList;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class PutOrderMap <K, V> implements Map {
    private class ValueAndOrder<V> {
        int num;
        V value;

        public int getNum() {
            return num;
        }

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

    private class KeyAndValue<K,V>{
        K key;
        V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "KeyAndValue{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public KeyAndValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public class KeyAndNumber implements Comparable<KeyAndNumber> {
        K key;
        Integer number;

//        @Override
//        public int compareTo(Object o) {
//
//            if(this.number == ((KeyAndNumber)o).number){
//                return 0;
//            }
//            else if(this.number > ((KeyAndNumber)o).number){
//                return -1;
//            }else{
//                return 1;
//            }
//        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

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
                return -1;
            }else{
                return 1;
            }
        }
    }

    MyDictionary<Integer, KeyAndValue> orderDict = new MyDictionary<>();
    MyDictionary<K, ValueAndOrder> keyDict = new MyDictionary<>();

    MyBinaryTree<KeyAndNumber> tree = new MyBinaryTree<KeyAndNumber>();
    MyLinkedList<Integer> numList;
    Integer counterAdded;
    Integer size;

    public PutOrderMap() {
        this.orderDict = new MyDictionary<>();
        this.keyDict = new MyDictionary<>();
        this.counterAdded = 0;
        this.numList = new MyLinkedList<>();
        this.size = 0;
    }

    public void add(K key, V value){
        size++;
        KeyAndValue<K, V> added1 = new KeyAndValue<>(key, value);
        numList.
        ValueAndOrder<V> added2 = new ValueAndOrder<>(counterAdded, value);
        orderDict.add(counterAdded, added1);
        keyDict.add(key, added2);
    }
    pub




    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

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
