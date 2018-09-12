package com.myjava.collection;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements DNMap<K, V> {

    private static int defaultLength = 16;
    private static double defaultLoader = 0.75;
    private Entry<K, V>[] table = null;
    private int size = 0;

    public MyHashMap(int length, double loader) {
        defaultLength = length;
        defaultLoader = loader;
        table = new MyHashMap.Entry[defaultLength];
    }

    public MyHashMap() {
        this(defaultLength, defaultLoader);
    }


    @Override
    public V put(K k, V v) {
        //size 如果超过自定义进行扩容
        if (size >= defaultLength * defaultLoader) {

        }
        return null;
    }


    public void up2size() {
        Entry<K, V>[] newTable = new Entry[2 * defaultLength];
        //新创建数组以后，以前老数组里面的元素要对新数组进项再散列
        againHash(newTable);
    }

    //新创建数组以后，以前老数组里面的元素要对新数组进项再散列
    public void againHash(Entry<K, V>[] newTable) {
        List<Entry<K, V>> list = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
        }
    }

    private void findEntryNext(Entry<K, V> entry, List<Entry<K, V>> list) {
        if (entry != null && entry.next!=null) {
           list.add(entry);
           findEntryNext(entry.next,list);
        }else{
            list.add(entry);
        }
    }

    private  Entry<K,V> newEntry(K k,V v,Entry<K,V>next){
        return  new Entry<>(k,v,next);
    }
private  int getIndex(K k){
       int m=defaultLength;
        int index=k.hashCode()%m;
        return  index>=0?index:-index;
}
    @Override
    public V get(K k) {
    int index=getIndex(k);
    if(table[index]==null){
        return  null;
    }
        return null;
    }

    @Override
    public int size() {
        return size;
    }


    class Entry<K, V> implements DNMap.Entry<K, V> {
        K k;
        V v;
        Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }
    }

}