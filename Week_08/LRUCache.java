package com.qunar.qboss.qer.common.lianxi.week08;

import com.qunar.qboss.qer.common.lianxi.DoubleList;
import com.qunar.qboss.qer.common.lianxi.Node;

import java.util.HashMap;

public class LRUCache {
    private  HashMap<Integer ,Node> map;
    private DoubleList cache; //双向链表
    private int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        //利用put方法把数据提前
        put(key,val);
        return val;
    }

    public void put(int key,int val){
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        }else{
            if (capacity == cache.getSize()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
