/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.HashTableMap;
import csci152.adt.KeyValuePair;
import csci152.impl.LinkedListQueue;

/**
 *
 * @author Anvar Adylov
 * @param <K>
 * @param <V>
 */
public class LLQHashTableMap<K extends Comparable, V> implements HashTableMap<K, V> {
    private LinkedListQueue<KeyValuePair<K, V>>[] buckets;
    private int size;
    private int bucketsAmount;
    
public LLQHashTableMap(int numBuckets) {
    buckets = new LinkedListQueue[numBuckets];
    size = 0;
    bucketsAmount = numBuckets;
}
    @Override
    public void define(K key, V value) {
        if (getValue(key) == null) {
            int hashvalue = key.hashCode() % bucketsAmount;
            if (hashvalue < 0) {
            hashvalue = -hashvalue;
            }
            if (buckets[hashvalue] == null) {
                buckets[hashvalue] = new LinkedListQueue();
                buckets[hashvalue].enqueue(new KeyValuePair(key, value));
            } else {
                buckets[hashvalue].enqueue(new KeyValuePair(key, value));
            }
            size++;
        } else {
            int hashvalue = key.hashCode() % bucketsAmount;
            if (hashvalue < 0) {
            hashvalue = -hashvalue;
            }
            int bucketSize = buckets[hashvalue].getSize();
        KeyValuePair<K, V> temp;
        try {
        for (int i = 0;i<bucketSize;i++) {
                temp = buckets[hashvalue].dequeue();
                if (temp.getKey() == key) { 
                    temp.setValue(value);
                }
                buckets[hashvalue].enqueue(temp);
        }
        } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
    }

    @Override
    public V getValue(K key) {
        int hashvalue = key.hashCode() % bucketsAmount;
        if (hashvalue < 0) {
            hashvalue = -hashvalue;
        }
        if (buckets[hashvalue] == null) {
            return null;
        } else  {
        int bucketSize = buckets[hashvalue].getSize();
        KeyValuePair<K, V> temp;
        try {
        for (int i = 0;i<bucketSize;i++) {
                temp = buckets[hashvalue].dequeue();
                buckets[hashvalue].enqueue(temp);
                if (temp.getKey().equals(key)) { 
                    return temp.getValue();
                }
        }
        } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        V result = getValue(key);
        if (getValue(key) != null) {
            size--;
            int hashvalue = key.hashCode() % bucketsAmount;
            int bucketSize = buckets[hashvalue].getSize();
            KeyValuePair<K, V> temp;
            try {
            for (int i = 0;i<bucketSize;i++) {
                    temp = buckets[hashvalue].dequeue();
                    if (temp.getKey() == key) { 
                        result = temp.getValue();
                        break;
                    } else {
                        buckets[hashvalue].enqueue(temp);
                    }
            }
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
            bucketSize = buckets[hashvalue].getSize();
            if (bucketSize == 0) {
                buckets[hashvalue] = null;
            }
        } 
        return result;
    }


    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        KeyValuePair<K, V> result = null;
        if (size == 0) {
            throw new Exception("The set is empty!");
        } else {
            size--;
            for (int i = 0;i<bucketsAmount;i++) {
                if (buckets[i] != null) {
                    result = buckets[i].dequeue();
                    int bucketSize = buckets[i].getSize();
                    if (bucketSize == 0) {
                        buckets[i] = null;
                    }
                    break;
                }
                
            }  
        }
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
    buckets = new LinkedListQueue[bucketsAmount];
    size = 0;
    }

    @Override
    public int getNumberOfBuckets() {
        return bucketsAmount;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return size/bucketsAmount;
    }

    @Override
    public double getBucketSizeStandardDev() {
            double res, sum = 0, temp;
        for (int i = 0; i<bucketsAmount;i++) {
            try {
                temp = getBucketSize(i) - getLoadFactor();
            sum = sum + temp*temp;
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        res = Math.sqrt(sum/bucketsAmount);
        return res;
    }

    @Override
    public String bucketsToString() {
        String res = "";
        for (int i = 0;i<bucketsAmount;i++) {
            if (buckets[i] != null) {
                int bucketSize = buckets[i].getSize();
                KeyValuePair<K, V> temp;
                res = res + "[";
                try {
                for (int j = 0;j<bucketSize;j++) {
                    
                    temp = buckets[i].dequeue();
                    res = res + temp + " ";
                    buckets[i].enqueue(temp);
                }
                } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
                }   
                res = res + "]";
            }
        }
        return res;
    }
    @Override
    public String toString() {
        String res = "["; 
        for (int i = 0;i<bucketsAmount;i++) {
            if (buckets[i] != null) {
                int bucketSize = buckets[i].getSize();
                KeyValuePair<K, V> temp;
                try {
                for (int j = 0;j<bucketSize;j++) {
                    temp = buckets[i].dequeue();
                    res = res + temp + " ";
                    buckets[i].enqueue(temp);
                }
                } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }   
            }
        }
        return res + "]";
    }
}
