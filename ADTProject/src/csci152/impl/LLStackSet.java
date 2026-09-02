/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;
import csci152.adt.Set;

/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class LLStackSet<T> implements Set<T> {
    private Stack<T> con = new LinkedListStack();
    
    
    public LLStackSet() {
        
    } 
    
    @Override
    public void add(T value) {
        if (contains(value)) {
            
        } else {
            con.push(value);
        }
    }

    @Override
    public boolean contains(T value) {
        int sz;
        Stack<T> temp = new LinkedListStack();
        sz = con.getSize();
        boolean cont = false;
        T x;
        try {
        for(int i = 0;i < sz;i++) {
            x = con.pop();
            temp.push(x);
            if (value.equals(x)) {
                cont = true;
            }
        }
        
        for(int i = 0;i < sz;i++) {
            con.push(temp.pop());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        return cont;
    }

    @Override
    public boolean remove(T value) {
        int sz;
        Stack<T> temp = new LinkedListStack();
        sz = con.getSize();
        T x;
        int j=0;
        boolean cont = false;
        try {
        for(int i = 0;i < sz;i++) {
            x = con.pop();
            if (value.equals(x)) {
                cont = true;
            } else {
                j++;
                temp.push(x);
            }
            
        }
        for(;j > 0;j--) {
            con.push(temp.pop());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        return cont;
    }

    @Override
    public T removeAny() throws Exception {
        if (con.getSize() == 0) {
            throw new Exception("The Set is empty!");
        } else {
        return con.pop();
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
        Stack<T> temp = new LinkedListStack();
        int sz = con.getSize();
        if (con.getSize() == 0) {
            return "|null|";
        } else {
        try {
        x = con.pop();
        temp.push(x);
        messg = messg + x.toString();
        for (int i = 1;i<sz;i++) { 
            x = con.pop();
            temp.push(x);
            messg = messg + ", " + x.toString();
            
        }
        for(int i = 0;i < sz;i++) {
            con.push(temp.pop());
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        return messg + "|";
        }
    }
}
