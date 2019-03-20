package com.practice.design;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {
    public static void main(String args[]){
        Cache<String,String> cache = new Cache<>();
        cache.set("A","abcd");
        //cache.set("B","xys");
        //cache.set("C","value");
        System.out.println(cache.get("A"));
        //System.out.println(cache.get("B"));
        //System.out.println(cache.get("C"));

    }
}
interface BaseCache<K,V>{
    V get(K key);
    void set(K key,V value);
    void remove(K key);
}

class Cache<K,V> implements BaseCache<K,V>{
    private class Value{
        V val;
        Long expiry;
        Value(V val,Long expiry){
            this.val = val;
            this.expiry = expiry;
        }
    }
    private final int MAX_SIZE = 100;

    Map<K,Value> M;
    List<K> keys;

    Cache(){
        M = new ConcurrentHashMap<>(MAX_SIZE);
        keys = new ArrayList<K>(MAX_SIZE);
    }

    private void updateKeysList(K key,Boolean remove){
        synchronized (keys) {
            System.out.println("Function:Updating keys list" + key);
            Iterator itr = keys.iterator();
            while (itr.hasNext()) {
                if (itr.next() == key) itr.remove();
            }
            if(!remove)
                keys.add(key);
        }
    }

    private void updateKeysListAsyc(K key,boolean remove){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                updateKeysList(key,remove);
            }
        });
        t.start();
    }

    private void compactCache(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Set<K> keys = M.keySet();
                for (K key:keys) {
                    Value v = M.get(key);
                    if(v.expiry > System.currentTimeMillis()){
                        remove(key);
                        System.out.println("Function:Compact Cache" + key);
                    }
                }
            }
        });
        t.start();

    }

    @Override
    public V get(K key) {
        Value v = M.get(key);
        Long currTime = System.currentTimeMillis();
        if(v.expiry > currTime) {
            remove(key);
            updateKeysListAsyc(key,true);
            return null;
        }
        updateKeysListAsyc(key,false);
        System.out.println("Function:Get" + key);
        return v.val;
    }

    @Override
    public void set(K key, V value) {
        if(M.size() > MAX_SIZE){
            K tempKey = keys.get(0);
            remove(tempKey);
            updateKeysListAsyc(key,false);
        }
        M.put(key,new Value(value,-1L));
        updateKeysListAsyc(key,false);
        return;
    }

    public void set(K key, V value,Long expiry) {
        if(M.size() <= MAX_SIZE) M.put(key,new Value(value,System.currentTimeMillis() + expiry));
        updateKeysListAsyc(key,false);
        if(M.size() > 0.5 * MAX_SIZE) compactCache();
    }

    @Override
    public void remove(K key){
        M.remove(key);
        updateKeysListAsyc(key,true);
    }
}
