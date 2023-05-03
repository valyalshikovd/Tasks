package Task6;

import java.util.*;


import Task2.MyLinkedList;

public class MyDictionary <K, V> implements Map {

    protected class Element<K, V>{
        private K key;
        private V value;

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

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(key=" + key +
                    ", value=" + value +
                    ')';
        }
    }

    int size;
    MyLinkedList<Element<K, V>>[] base;


    public MyDictionary() {
        this.size = 0;
        this.base = new MyLinkedList[10];
    }
    public void add(K key, V value){
        size++;
        int index = this.hash(key);
        if (base[index] == null){
            base[index] = new MyLinkedList<>(new Element<>(key, value));
            return;
        }
        base[index].add(new Element<>(key, value));
        size++;
    }
    private int hash(K key){
        return key.hashCode() % 10;
    }

    public void write(){
        for (MyLinkedList<Element<K,V>> i : base) {
            if(i == null){
                continue;
            }
            for (Element<K, V> element : i) {
                System.out.print(element);
            }

        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (MyLinkedList<Element<K,V>> i : base) {
            for (Element<K,V> j : i) {
                if(j != null){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Element<K,V> j : base[this.hash((K) key)]) {
            if(j.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MyLinkedList<Element<K,V>> i : base) {
            for (Element<K,V> j : i) {
                if(j.value.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        for (Element<K,V> j : base[this.hash((K) key)]) {
            if(j.key.equals(key)){
                return j.value;
            }
        }
        return false;
    }

    @Override
    public Object put(Object key, Object value) {
        V tmp = null;
        for (Element<K, V> i : base[this.hash((K) key)]) {
            if(i.key.equals(key)){
                tmp = i.value;
                i.value = (V) value;  //колхозище
            }
        }
        return tmp;

    }

    @Override
    public Object remove(Object key) {
        size--;
        int index = this.hash((K) key);
        for (Element<K, V> i : base[index]) {
            if(i.key.equals(key)){
                V tmp = i.value;
                base[index].remove(i);  //колхозище
                return tmp;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map m) {

        for (Object entry : m.entrySet()) {
            K key = ((Element<K, V>) entry).getKey();
            V value = ((Element<K, V>)entry).getValue();
            for (Element<K, V> i : base[this.hash(key)]) {
                if(i.key.equals(key)){
                    i.value =  value; //колхозище
                }
            }
        }

    }

    @Override
    public void clear() {

        base = new MyLinkedList[10];

    }

    @Override
    public Set keySet() {
        Set<K> res = new HashSet<>();
        for (MyLinkedList<Element<K,V>> i : base) {
            if(i == null){
                continue;
            }
            for (Element<K, V> element : i) {
                res.add(element.key);
            }

        }
        return res;
    }

    @Override
    public Collection values() {
        MyLinkedList<V> res = new MyLinkedList<>();
        for (MyLinkedList<Element<K,V>> i : base) {
            if(i == null){
                continue;
            }
            for (Element<K, V> element : i) {
                res.add(element.value);
            }

        }
        return res;
    }

    @Override
    public Set<Element<K, V>> entrySet() {
        Set<Element<K, V>> res = new HashSet<>();
        for (MyLinkedList<Element<K,V>> i : base) {
            if(i == null){
                continue;
            }
            for (Element<K, V> element : i) {
                res.add(element);
            }

        }
        return res;
    }
}
