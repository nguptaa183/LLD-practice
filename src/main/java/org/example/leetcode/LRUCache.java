package org.example.leetcode;

import java.util.*;

class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val){
        this.key=key;
        this.val = val;
    }
}

public class LRUCache {
    Map<Integer,ListNode> cache;
    int capacity;
    ListNode left;
    ListNode right;

    public LRUCache(int capacity){
        cache = new HashMap<>();
        this.capacity = capacity;
        left = new ListNode(-1,-1);
        right = new ListNode(-1,-1);
        left.next = right;
        right.prev=left;
    }

    //prev->node->next
    public void remove(ListNode node){
        ListNode prv = node.prev;
        ListNode nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    //prev->node->right
    public void insert(ListNode node){
        ListNode prv = right.prev;
        prv.next = node;
        node.prev = prv;
        node.next = right;
        right.prev = node;
    }

    public int get(int key){
        if(cache.containsKey(key)){
            //remove node and place it last of DLL as its a hit
            ListNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value){
        if(cache.containsKey(key)){
            remove(cache.get(key));
            ListNode newValue = new ListNode(key,value);
            cache.put(key, newValue);
            insert(cache.get(key));
        }else if(cache.size()>=capacity){
            //evict lru
            ListNode lru = left.next;
            cache.remove(lru.key);
            remove(lru);
            ListNode newNode = new ListNode(key,value);
            cache.put(key, newNode);
            insert(newNode);
        }else{
            ListNode newNode = new ListNode(key,value);
            cache.put(key,newNode);
            insert(newNode);
        }
    }
}

class Solution{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
