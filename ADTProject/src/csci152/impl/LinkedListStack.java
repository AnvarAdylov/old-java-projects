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
 */
public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    
    
    public LinkedListStack() {
        top = null;
        size = 0;
    }
    
    @Override
    public void push(T value) {
        if (size == 0) {
            Node<T> node = new Node(value);
            top = node;
            node.setLink(null);
        } else {
            Node<T> node = new Node(value);
            node.setLink(top);
            top = node;
        }
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack does not contain anything!");
        }
        size--;
        T result = top.getValue();
        top = top.getLink();
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        String messg;
        Node pr;
        pr = top;
        messg = "Top |" + pr;
        for (int i = 1;i<size;i++) {
            pr = pr.getLink();
            messg = messg + ", " + pr;     
        }
        return messg + "| Bottom";
    }
}
