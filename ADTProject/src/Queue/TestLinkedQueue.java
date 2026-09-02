/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import csci152.adt.Queue;
import csci152.impl.LinkedListQueue;

/**
 *
 * @author Anvar Adylov
 */
public class TestLinkedQueue {
    public static void main(String[] args) {
        Queue<Integer> Lottery = new LinkedListQueue(); 
        try {
        System.out.println(Lottery.dequeue());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        
        for (int i = 0;i<8;i++) {
            Lottery.enqueue(i + 1);
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
        
        for (int i = 0;i<9;i++) {
            Lottery.enqueue(i + 1);
            Lottery.enqueue(i + 1);
            try {
                System.out.println(Lottery.dequeue());
                System.out.println(Lottery.dequeue());
            } catch(Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
            System.out.println(Lottery);
            System.out.println(Lottery.getSize());
        }
        Lottery.clear();
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        for (int i = 0;i<22;i++) {
            Lottery.enqueue(i + 1);
        }
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
         
    }
}
