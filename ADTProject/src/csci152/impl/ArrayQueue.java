/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.impl;


import csci152.adt.Queue;

/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] values;
    private int size;
    private int front;
    private int back;
    private int max;
    
    public ArrayQueue() {
        values = (T[])new Object[5];
        size = 0;
        front = 0;
        back = 0;
        max = 5;
    }
    @Override
    public void enqueue(T value) {
        if (size < back && back == max) {
            back = 0;
        }
        if (size >= max) {
            T[] temp = (T[])new Object[max];
            for (int i=0;i<max;i++) {
                temp[i] = values[front];
                front++;
                if (front == max) {
                    front = 0;
                }
            }
            max = size*2;
            values = (T[])new Object[max];
            System.arraycopy(temp, 0, values, 0, max/2);
            front = 0;
            back = max/2;
        }
        values[back] = value;
        size++;
        back++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("No values in Queue!");
        }
        T result = values[front];
        values[front] = null;
        front = (front+1) % values.length;
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
       values = (T[])new Object[5];
        size = 0;
        front = 0;
        back = 0;
        max = 5;
    }
    
    @Override
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
