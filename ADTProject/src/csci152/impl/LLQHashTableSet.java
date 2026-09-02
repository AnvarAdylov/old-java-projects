/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.HashTableSet;



/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class LLQHashTableSet<T> implements HashTableSet<T> {
    private LinkedListQueue<T>[] buckets;
    private int size;
    private int bucketsAmount;
    
    
public LLQHashTableSet(int numBuckets) {
    buckets = new LinkedListQueue[numBuckets];
    size = 0;
    bucketsAmount = numBuckets;
}
    @Override
    public void add(T value) {
        if (!contains(value)) {
            size++;
            int hashvalue = value.hashCode() % bucketsAmount;
            if (hashvalue < 0) {
            hashvalue = -hashvalue;
            }
            if (buckets[hashvalue] == null) {
                buckets[hashvalue] = new LinkedListQueue();
                buckets[hashvalue].enqueue(value);
            } else {
                buckets[hashvalue].enqueue(value);
            }
        }
    }

    @Override
    public boolean contains(T value) {
        int hashvalue = value.hashCode() % bucketsAmount;
        if (hashvalue < 0) {
            hashvalue = -hashvalue;
        }
        if (buckets[hashvalue] == null) {
            return false;
        } else  {
        int bucketSize = buckets[hashvalue].getSize();
        T temp;
        try {
        for (int i = 0;i<bucketSize;i++) {
                temp = buckets[hashvalue].dequeue();
                buckets[hashvalue].enqueue(temp);
                if (temp == value) { 
                    return true;
                }
        }
        } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        boolean с = false;
        if (contains(value)) {
            size--;
            int hashvalue = value.hashCode() % bucketsAmount;
            int bucketSize = buckets[hashvalue].getSize();
            T temp;
            try {
            for (int i = 0;i<bucketSize;i++) {
                    temp = buckets[hashvalue].dequeue();
                    if (temp == value) { 
                        с = true;
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
        return с;
    }

    @Override
    public T removeAny() throws Exception {
        boolean e = false;
        T result = null;
        for (int i = 0;i<bucketsAmount;i++) {
            if (buckets[i] != null) {
                e = true;
            }
        }    
        if (!e) {
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
    public String toString() {
        String res = "["; 
        for (int i = 0;i<bucketsAmount;i++) {
            if (buckets[i] != null) {
                int bucketSize = buckets[i].getSize();
                T temp;
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

    @Override
    public int getNumberOfBuckets() {
        return bucketsAmount;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index < 0 || index >= bucketsAmount) {
            throw new Exception("Inapropriate index assigned!");
        } else {
            if (buckets[index] != null) {
            return buckets[index].getSize();
            } else {
                return 0;
            }
        }
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
                T temp;
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
    
}
