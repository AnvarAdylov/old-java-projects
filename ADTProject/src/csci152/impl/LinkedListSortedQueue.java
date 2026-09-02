/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.SortedQueue;

/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {
    private Node<T> front;
    private int size;
    
    
    public LinkedListSortedQueue() {
        front = null;
        size = 0;
    }
    
    
    @Override
    public void insert(T value) {
        Node<T> newNode = new Node(value);
        Node<T> pointer; 
        if (size == 0) {
            front = newNode;
        } else {
            if (value.compareTo(front.getValue()) <= 0) {
                newNode.setLink(front);
                front = newNode;
            } else {
            pointer = front;
                while (pointer.getLink() != null) {
                    if (value.compareTo(pointer.getLink().getValue()) < 0) {
                        newNode.setLink(pointer.getLink());
                        pointer.setLink(newNode);
                        break;
                    } else {
                        pointer = pointer.getLink();
                    }
                }
            if (pointer.getLink() == null) {
                    pointer.setLink(newNode);
            }    
                
            
            }
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
