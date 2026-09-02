/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;




/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] values;
    private int size;
    private int max;
    public ArrayStack() {
        values = (T[])new Object[10];
        size = 0;
        max = 10;
    }
    
    @Override
    public void push(T value) {
        if (size==max) {
            T[] temp = (T[])new Object[max];
            System.arraycopy(values, 0, temp, 0, max);
            max = size*2;
            values = (T[])new Object[max];
            System.arraycopy(temp, 0, values, 0, max/2);
        }
        values[size]= value;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack does not contain anything!");
        }
        
        size--;
        T result = values[size];
        values[size] = null;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[])new Object[10];
        size = 0;
        max = 10;
    }
    
    @Override
    public String toString() {
        String stack;
        stack = "" + values[0];
        for (int i = 1;i<size;i++) {
        stack = stack + "," + values[i];
        }
        return "bottom[" + stack + "]top";
    }

}
