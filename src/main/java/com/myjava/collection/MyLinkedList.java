/**
 * 1.LinkedList的简单实现
 * 2.后续有时间会逐步添加方法
 * 3.实现的方法有：
 *              void add(Object obj)
 *              void add(int index,Object obj)
 *              int size()
 *              Object get(int index)
 *              void remove(int index)
 *              Node node(int index)
 *              void rangeCheck(int index)
 */
package com.myjava.collection;

class Node{
    /*
     * 1.结点的定义
     * 2.封装成类
     */
    Object obj;
    Node previous;
    Node next;
    public void setObj(Object obj) {
        this.obj = obj;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node(Object obj, Node previous, Node next) {
        super();
        this.obj = obj;
        this.previous = previous;
        this.next = next;
    }
    public Node(){
        /*
         * 一定要定义 ，不然会报错
         */
    }
}

public class MyLinkedList {
    private Node first=null;
    private Node last=null;
    private int size=0;

    public void add(Object obj){
        /*
         * 1.指定对象实现结点的添加
         * 2.要对头结点判断是否为空，空的话将制定对象置为头结点
         * 3.不为空，则往last后增加结点（直接）
         * 4.重要：要将last置为结点
         * 5.size++
         */
        Node n=new Node();
        if(first==null){
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);
            first=n;
            last=n;
        }else{
            //直接往last后增加新的节点
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);
            last.setNext(n);
            last=n;             //再把n结点置为尾结点
        }
        size++;
    }

    public void add(int index,Object obj){
        /*
         * 1.实现指定序列的结点插入
         * 2.首先要对结点遍历
         * 3.生成新的结点（待插入结点）
         * 4.判断遍历得到的结点是否为空，不空则插入（一般不为空）
         * 5.size++
         */
        Node temp=node(index);
        Node newNode=new Node();
        newNode.obj=obj;
        if(temp!=null){
            //新结点的前驱指向结点的前驱
            //结点的前驱的后继指向新结点
            //新结点的后继指向结点temp
            //结点的前驱指向新结点
            //插在结点temp前面
            newNode.previous=temp.previous;
            temp.previous.next=newNode;
            newNode.next=temp;
            temp.previous=newNode;
        }
        size++;
    }
    public int size(){
        /*
         * 返回数据对象的个数
         */
        return size;
    }

    public Object get(int index){
        /*
         * 1.获得指定序列的结点
         * 2.对序列的合法性判断
         * 3.对结点的遍历
         * 4.结点不为空，返回结点的数据域
         */
        rangeCheck(index);
        Node temp=node(index);
        if(temp!=null){
        return temp.obj;

        }
        return null;
    }

    public void remove(int index){
        /*
         * 1.移除指定序列的对象
         * 2.对结点的遍历
         * 3.size--
         */
        Node temp=node(index);
        if(temp!=null){
            //要移除结点temp，先将temp的后继的前驱指向temp的前驱
            temp.next.previous=temp.previous;
            //再将temp的前驱的后继指向temp的后继
            temp.previous.next=temp.next;
            size--;
        }
    }

    public Node node(int index){
        /*
         * 1.实现结点的遍历
         * 2.还是要先判断头结点是否为空
         */
        Node temp=null;
        if(first!=null){
            temp=first;
        }
        for (int i = 0; i <index; i++) {
            temp=temp.next;
        }

        return temp;
    }

    private void rangeCheck(int index){
        /*
         * 对序列的合法性检查
         */
        if(index<0||index>=size){
            try {
                throw new Exception();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.add("你好");
        list.add("哦哦");
        list.add("Java");
        list.add("谢谢");
        list.remove(1);
        list.add(1,"再见啊");
        list.add(2,"开心呢");
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}