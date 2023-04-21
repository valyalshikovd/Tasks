package Task6;

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

    MyDictionary<Integer, KeyAndValue> orderDict = new MyDictionary<>();
    MyDictionary<K, ValueAndOrder> keyDict = new MyDictionary<>();
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
