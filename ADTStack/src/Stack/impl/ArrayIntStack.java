/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack.impl;

import csci152.adt.IntStack;

/**
 *
 * @author Anvar Adylov
 */
public class ArrayIntStack implements IntStack {
    private int[] values;
    private int size;
    private int max;
    public ArrayIntStack() {
        values = new int[10];
        size = 0;
        max = 10;
    }
    
    @Override
    public void push(int value) {
        if (size==max) {
            int[] temp = new int[max];
            for (int i = 0;i<max;i++) {
                temp[i] = values[i];
            }
            max = size*2;
            values = new int[max];
            for (int i = 0;i<max/2;i++) {
               values[i] =  temp[i];
            }
        }
        values[size]= value;
        size++;
    }

    @Override
    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack does not contain anything!");
        }
        
        size--;
        int result = values[size];
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = new int[10];
        size = 0;
        max = 10;
    }
    
    public String toString() {
        String stack;
        stack = "" + values[0];
        for (int i = 1;i<size;i++) {
        stack = stack + "," + values[i];
        }
        return "bottom[" + stack + "]top";
    }
    
}
