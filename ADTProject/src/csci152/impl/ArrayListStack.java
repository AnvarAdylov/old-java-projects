/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;
import java.util.ArrayList;




/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class ArrayListStack<T> implements Stack<T> {
    private ArrayList<T> values;
    private int size;
    private int max;
    public ArrayListStack() {
        values = new ArrayList(10);
        size = 0;
        max = 10;
    }
    
    @Override
    public void push(T value) {
        if (size == max) {
            values.ensureCapacity(size*2);
        }
        values.add(0 ,value);
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack does not contain anything!");
        }
        
        size--;
        T result = values.get(0);
        values.remove(0);
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values.clear();
        values.ensureCapacity(10);
        size = 0;
        max = 10;
    }
    
    @Override
    public String toString() {
        String stack;
        stack = "" + values;
        return "top" + stack + "bottom";
    }

}
