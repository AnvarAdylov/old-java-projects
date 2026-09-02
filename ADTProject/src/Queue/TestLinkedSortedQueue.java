/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import csci152.adt.SortedQueue;
import csci152.impl.LinkedListSortedQueue;

/**
 *
 * @author Anvar Adylov
 */
public class TestLinkedSortedQueue {
    public static void main(String[] args) {
        SortedQueue<Integer> Lottery = new LinkedListSortedQueue(); 
        try {
        System.out.println(Lottery.dequeue());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        
        for (int i = 9;i>0;i--) {
            Lottery.insert(i*10);
        }
        
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        
        try {
        System.out.println(Lottery.dequeue());
        System.out.println(Lottery.dequeue());
        System.out.println(Lottery.dequeue());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        
        for (int i = 1;i<9;i++) {
            Lottery.insert(i*100);
        }
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        try {
        System.out.println(Lottery.dequeue());
        System.out.println(Lottery.dequeue());
        System.out.println(Lottery.dequeue());
        System.out.println(Lottery.dequeue());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        for (int i = 0;i<92;i++) {
            Lottery.insert(5+i*10);
        }
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        try {
        for (int i = 0;i<102;i++) {
            System.out.println(Lottery.dequeue());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        for (int i = 0;i<3;i++) {
            Lottery.insert(i*345);
        } 
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        Lottery.clear();
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        for (int i = 0;i<4;i++) {
            Lottery.insert(i);
        } 
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
    }
}
