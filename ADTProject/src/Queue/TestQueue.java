/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import Queue.impl.ArrayQueue;
import csci152.adt.Queue;

/**
 *
 * @author Anvar Adylov
 */
public class TestQueue {
    public static void main(String[] args) {
        int b;
        Queue<Integer> queue = new ArrayQueue();
        try {
        queue.dequeue();
        }catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        for (int i = 0;i<8;i++) {
        queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.getSize());
        try {
        for (int i = 0;i<3;i++) {
            queue.dequeue();
        }
        System.out.println(queue);
        System.out.println(queue.getSize());
        }catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        try {
        for (int i = 0;i<9;i++) {
        queue.enqueue(i);
        queue.enqueue(i);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getSize());
        }
        }catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        queue.clear();
        System.out.println(queue);
        System.out.println(queue.getSize());
        for (int i = 0;i<22;i++) {
        queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.getSize());
    }
}
