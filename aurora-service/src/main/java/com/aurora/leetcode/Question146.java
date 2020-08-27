package com.aurora.leetcode;

import java.util.*;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 // 缓存容量 );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class Question146 {

    private static class LRUCache {
        Map<Integer,Integer> keyValueMap;
        Deque<Integer> keyList;
        int capacity;
        public LRUCache(int capacity) {
            keyValueMap  = new HashMap<>();
            keyList = new LinkedList<Integer>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(keyList.contains(key)){
                keyList.remove(key);
                keyList.add(key);
                Integer value = keyValueMap.get(key);
                return value == null ? -1 : value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(keyList.contains(key)){
                keyList.remove(key);
            } else {
                if(!keyList.isEmpty() && keyList.size() >= capacity){
                    keyList.removeFirst();
                }
            }
            keyList.add(key);
            keyValueMap.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        // 返回  1
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));// 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));// 返回 -1 (未找到)
        System.out.println(cache.get(3));// 返回  3
        System.out.println(cache.get(4));// 返回  4
    }
}
