package com.qunar.qboss.qer.common.lianxi.week08;

import com.qunar.qboss.qer.common.lianxi.Node;

public class DoubleList {

    private Node head,tail ; //头尾结点
    private int size; //链表元素数

    public DoubleList(){
        head = new Node(0,0);  //头尾虚结点
        tail = new Node(0,0);
        head.next = tail;//< 大专栏  LRU缓存机制/span>
        tail.prior = head;
        size = 0;
    }

    //再头部添加结点
    public void addFirst(Node x){
        x.next = head.next;
        x.prior = head;
        head.next.prior = x;
        head.next = x;
        size++;
    }

    //删除链表中的结点
    public void remove(Node x){
        x.prior.next = x.next;
        x.next.prior = x.prior;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点
    public Node removeLast(){
        //当前链表没有结点
        if(tail.prior == head)
            return null;
        Node last = tail.prior;
        remove(last);
        return last;
    }

    //返回链表长度
    public int getSize(){
        return size;
    }
}
