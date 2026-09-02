/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.impl;

import csci152.adt.IntQueue;

/**
 *
 * @author Anvar Adylov
 */
public class ArrayIntQueue implements IntQueue {

    private int[] values;
    private int size;
    private int front;
    private int back;
    private int max;
    
    public ArrayIntQueue() {
        values = new int[5];
        size = 0;
        front = 0;
        back = 0;
        max = 5;
    }
    @Override
    public void enqueue(int value) {
        if (size < back && back == max) {
            back = 0;
        }
        if (size >= max) {
            int[] temp = new int[max];
            for (int i=0;i<max;i++) {
                temp[i] = values[front];
                front++;
                if (front == max) {
                    front = 0;
                }
            }
            max = size*2;
            values = new int[max];
            System.arraycopy(temp, 0, values, 0, max/2);
            front = 0;
            back = max/2;
        }
        values[back] = value;
        size++;
        back++;
    }

    @Override
    public int dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("No values in Queue!");
        }
        int result = values[front];
        front++;
        if (front == max) {
            front = 0;
        }
        size--;
        if (front == back) {
            clear();
        }
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
       values = new int[5];
        size = 0;
        front = 0;
        back = 0;
        max = 5;
    }
    
    public String toString() {
        String stack;
        int x;
        if (front == back) {
            return "front[0]back";
        }
        if (front >= max) {
            x = 0;
        }
        stack = "" + values[front];
        for (x = front + 1;x!=back;x++) {
        if (x == max) {
            x = 0;
        }
        stack = stack + "," + values[x];
        }
        return "front[" + stack + "]back";
    }
}
