/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import csci152.adt.Stack;
import csci152.impl.LinkedListStack;

/**
 *
 * @author Anvar Adylov
 */
public class TestLinkedStack {
    public static void main(String[] args) {
        Stack<Integer> Lottery = new LinkedListStack(); 
        try {
        System.out.println(Lottery.pop());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        for (int i = 0;i<12;i++) {
            Lottery.push(i + 1);
        }
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        for (int i = 0;i<7;i++) {
        try {
        System.out.println(Lottery.pop());
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        }
        Lottery.clear();
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
        for (int i = 0;i<22;i++) {
            Lottery.push(i + 1);
        }
        System.out.println(Lottery);
        System.out.println(Lottery.getSize());
    }
}
