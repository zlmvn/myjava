package com.myjava.collection;


import java.io.Serializable;
import java.util.*;

/**
 * @see java.util.ArrayList
 * @param <E>
 *     arrayList 的创建过程
 *     1、在构造函数里设置默认的长度为10
 *     2、如果数组的长度大于默认值扩展数组的长度为1.5倍
 *     3、删除某一位置的值之后，后面所有值都往前移
 */
public class ArrayList<E> extends AbstractList<E> implements Serializable,RandomAccess,Cloneable {

    private static final long serialVersionUID = -4487349573434744861L;
    // ArrayList基于该数组实现，用该数组保存数据
    private Object[] array;
    // ArrayList中实际数据的数量
    private transient int modCount = 0;

    private final static int initCapacity = 10;

    private int size = 0;

//构造器默认数组的长度是10
    public ArrayList(){
        array = new Object[initCapacity];
    }

    public ArrayList(int capacity){
        if(capacity<initCapacity){
            capacity = initCapacity;
        }
        array = new Object[capacity];
    }

    public ArrayList(Collection<? extends E> collection){
        this(collection.size());
        this.addAll(collection);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E)array[index];
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean add(E e) {
        modCount++;
        if(size == array.length){
            large(10);
        }
        array[size++] = e;
        return true;
    }

    private void checkIndex(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException(index+",size:"+size);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        modCount++;
        if(c.size()+size>=array.length){
            large(c.size());
        }
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        modCount++;
        if(c.size()+size>=array.length){
            large(c.size());
        }
        return super.addAll(index, c);
    }

    /**
     * 对ArrayList的数组进行克隆，内部的元素不克隆。
     * @return 克隆后的结果
     */
    @Override
    public Object clone() {
        try {
            ArrayList<?> list = (ArrayList<?>) super.clone();
            list.array = new Object[array.length];
            for(int i=0;i<size;i++){
                list.array[i] = array[i];
            }
            list.modCount = 0;
            return list;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 扩容
     * @param newSize 增加的新的大小
     */
    private void large(int newSize){
        int length = array.length + newSize;
        Object[] values = new Object[length];
        for(int i=0;i<size;i++){
            values[i] = array[i];
        }
        array = values;
    }

    /**
     * 在列表的指定位置插入指定元素（可选操作）。将当前处于该位置的元素（如果有的话）和所有后续元素向右移动（在其索引中加 1）。
     * @param index 要在其中插入指定元素处的索引
     * @param element 要插入的元素
     */
    @Override
    public void add(int index, E element) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException(index+",size:"+size);
        }
        modCount++;
        if(size == array.length){
            large(10);
        }
        for(int i=size-1;i>=index;i--){
            array[i+1]=array[i];
        }
        size++;
        array[index] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        modCount++;
        E old = (E) array[index];
        array[index] = element;
        return old;
    }
    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        checkIndex(index);
        modCount++;
        E value = (E) array[index];
        for(int i=index+1;i<size;i++){
            array[i-1]=array[i];
        }
        size--;
        return value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListItr();
    }

    @Override
    public void clear() {
        modCount++;
        size = 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private class ArrayListItr implements Iterator<E>{

        int cursor;
        int lastRet = -1;
        int expectedModCount = ArrayList.this.modCount;

        @Override
        public boolean hasNext() {
           return cursor!=size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            if(i >= array.length){
                throw new ConcurrentModificationException();
            }
            cursor = i+1;
            return (E) array[lastRet = i];
        }

        public void remove() {
            if(lastRet<0){
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            }catch (IndexOutOfBoundsException e){
                throw new ConcurrentModificationException();
            }
        }

        private void checkForComodification() {
            if (ArrayList.this.modCount == this.expectedModCount)
                return;
            throw new ConcurrentModificationException();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(0);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(5);
        arrayList.addAll(list);


        System.out.println(arrayList);
        arrayList.set(3,1000);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        arrayList.add(2,1);
        System.out.println(arrayList);

        arrayList.remove(1);
        System.out.println(arrayList);
    }
}
