/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;

/**
 *
 * @author Anvar Adylov
 */
public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;
    
    
    public LinkedListQueue() {
        front = null;
        back = null;
        size = 0;
    }
    
    
    @Override
    public void enqueue(T value) {
        if (back == null) {
            Node<T> node = new Node(value);
            back = node;
            front = node;
            node.setLink(null);
        } else if (front == null) {
            Node<T> node = new Node(value);
            front = node;
            back.setLink(node);
            back = node;
        } else {
        Node<T> node = new Node(value);
        back.setLink(node);
        back = node;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
       if (size == 0) {
            throw new Exception("Queue is empty!");
       }
       T result;
       result = front.getValue();
       front = front.getLink();
       size--;
       return result;
    }

    @Override
    public int getSize() {
         return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        String messg;
        Node pr;
        pr = front;
        messg = "Front |" + pr;
        for (int i = 1;i<size;i++) {
            pr = pr.getLink();
            messg = messg + ", " + pr;
        }
        return messg + "| Back";
    }
    
}
