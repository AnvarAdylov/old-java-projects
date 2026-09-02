/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

/**
 *
 * @author Anvar Adylov
 */
public class LLQueueMap<K extends Comparable, V> implements Map<K, V>  {
    private LinkedListQueue<KeyValuePair<K, V>> pairs;
    
    public LLQueueMap() {
        pairs = new LinkedListQueue();
    }
    
    @Override
    public void define(K key, V value) {
        if (getValue(key) == null) {
            pairs.enqueue(new KeyValuePair(key, value));
        } else {
            int sz;
        KeyValuePair<K, V> temp;
        
        sz = pairs.getSize();
        try {
        for(int i = 0;i<sz;i++) {
            temp = pairs.dequeue();
            if (temp.equals(new KeyValuePair(key, value))) {
                temp.setValue(value);
                pairs.enqueue(temp);
                break;
            }
            pairs.enqueue(temp); 
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        }
    }

    @Override
    public V getValue(K key) {
        int sz;
        KeyValuePair<K, V> temp;
        sz = pairs.getSize();
        try {
        for(int i = 0;i<sz;i++) {
            temp = pairs.dequeue();
            pairs.enqueue(temp);
            if (temp.equals(new KeyValuePair(key, null))) {
                return temp.getValue();
            }
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int sz;
        V result = null;
        KeyValuePair<K, V> temp;
        sz = pairs.getSize();
        try {
        for(int i = 0;i<sz;i++) {
            temp = pairs.dequeue();
            if (temp.equals(new KeyValuePair(key, null))) {
                result = temp.getValue();
                break;
            }
            pairs.enqueue(temp); 
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        return result;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (pairs.getSize() == 0) {
            throw new Exception("The Map is empty!");
        } else {
        return pairs.dequeue();
        }   
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue();
    }
    
    @Override
    public String toString() {
            String messg = "|";
        KeyValuePair x;
        if (pairs.getSize() == 0) {
            return "|null|";
        } else {
        try {
        x = pairs.dequeue();
        pairs.enqueue(x);
        messg = messg + x.toString();
        for (int i = 1;i<pairs.getSize();i++) { 
            x = pairs.dequeue();
            pairs.enqueue(x);
            messg = messg + ", " + x.toString();   
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        return messg + "|";
        }
    }
    
}
