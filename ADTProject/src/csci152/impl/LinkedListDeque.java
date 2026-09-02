/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Deque;

/**
 *
 * @author Anvar Adylov
 */
public class LinkedListDeque<T> implements Deque<T> {
    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    private int size;
    
    public LinkedListDeque() {
        front = null;
        back = null;
        size = 0;
    }
    
    @Override
    public void pushToFront(T value) {
        if (size == 0) {
            DoublyLinkedNode<T> node = new DoublyLinkedNode(value);
            front = node;
            back = node;
        } else {
            DoublyLinkedNode<T> node = new DoublyLinkedNode(value);
            front.setPrevious(node);
            front.getPrevious().setNext(front);
            front.getPrevious().setPrevious(null);
            front = node;
        }
        
        size++;
    }

    @Override
    public void pushToBack(T value) {
        if (size == 0) {
            DoublyLinkedNode<T> node = new DoublyLinkedNode(value);
            front = node;
            back = node;
        } else {
            DoublyLinkedNode<T> node = new DoublyLinkedNode(value);
            back.setNext(node);
            back.getNext().setPrevious(back);
            back.getNext().setNext(null);
            back = node;
        }
        
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
        T value;
        if (size == 0) {
            throw new Exception("Deque is empty!");
        }
        value = front.getValue();
        if (size == 1) {
            front = null;
            back = null;
        } else {
        front = front.getNext();
        front.getPrevious().setNext(null);
        front.setPrevious(null);
        }
        
        size--;
        return value;
    }

    @Override
    public T popFromBack() throws Exception {
        T value;
        if (size == 0) {
            throw new Exception("Deque is empty!");
        }
        value = back.getValue();
        if (size == 1) {
            front = null;
            back = null;
        } else {
        back = back.getPrevious();
        back.getNext().setPrevious(null);
        back.setNext(null);
        }
        
        size--;
        return value;
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
        String text;
        DoublyLinkedNode pr;
        pr = front;
        text = "Front |" + pr;
        for (int i = 1;i<size;i++) {
            pr = pr.getNext();
            text = text + ", " + pr;
        }
        return text + "| Back";
    }
}
