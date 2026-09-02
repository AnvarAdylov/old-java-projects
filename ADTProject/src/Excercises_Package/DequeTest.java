/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

import csci152.impl.LinkedListDeque;

/**
 *
 * @author Anvar Adylov
 */
public class DequeTest {
    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque();
        
        try {
        System.out.println(deque.popFromBack());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(deque);
        System.out.println(deque.getSize());
        try {
        System.out.println(deque.popFromFront());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(deque);
        System.out.println(deque.getSize());
        for (int i=0;i<5;i++) {
            deque.pushToFront(i);
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        try {
        for (int i=0;i<5;i++) {
            System.out.println(deque.popFromFront());
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        for (int i=0;i<6;i++) {
            deque.pushToFront(i);
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        try {
        for (int i=0;i<6;i++) {
            System.out.println(deque.popFromBack());
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        for (int i=0;i<7;i++) {
            deque.pushToBack(i);
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        try {
        for (int i=0;i<7;i++) {
            System.out.println(deque.popFromBack());
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        for (int i=0;i<8;i++) {
            deque.pushToBack(i);
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        try {
        for (int i=0;i<8;i++) {
            System.out.println(deque.popFromFront());
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        for (int i=0;i<10;i++) {
            deque.pushToFront(i+5);
            deque.pushToBack(i);
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        try {
        for (int i=0;i<8;i++) {
            System.out.println(deque.popFromFront());
            System.out.println(deque.popFromBack());
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        deque.clear();
        System.out.println(deque);
        System.out.println(deque.getSize());
        for (int i=0;i<10;i++) {
            if (i%2 == 0) {
            deque.pushToFront(i+1);
            } else {
            deque.pushToBack(i+1);
            }
            System.out.println(deque);
            System.out.println(deque.getSize());
        }
    }
}
