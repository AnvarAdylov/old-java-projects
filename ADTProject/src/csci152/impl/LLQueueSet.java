/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Set;

/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class LLQueueSet<T> implements Set<T> {
    private Queue<T> con = new LinkedListQueue();
    
    
    public LLQueueSet() {
        
    } 
    
    @Override
    public void add(T value) {
        if (contains(value)) {
            
        } else {
            con.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        int sz;
        T temp;
        sz = con.getSize();
        try {
        for(int i = 0;i<sz;i++) {
            temp = con.dequeue();
            con.enqueue(temp);
            if (value.equals(temp)) {
                return true;
            }
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        int sz;
        T temp;
        sz = con.getSize();
        try {
        for(int i = 0;i<sz;i++) {
            temp = con.dequeue();
            if (value.equals(temp)) {
                return true;
            } else {
                con.enqueue(temp);
            }
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (con.getSize() == 0) {
            throw new Exception("The Set is empty!");
        } else {
        return con.dequeue();
        }    
    }

    @Override
    public int getSize() {
        return con.getSize();
    }

    @Override
    public void clear() {
        con.clear();
    }
    
    @Override
    public String toString() {
        String messg = "|";
        T x;
        if (con.getSize() == 0) {
            return "|null|";
        } else {
        try {
        x = con.dequeue();
        con.enqueue(x);
        messg = messg + x.toString();
        for (int i = 1;i<con.getSize();i++) { 
            x = con.dequeue();
            con.enqueue(x);
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
