/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

import Stack.*;
import csci152.adt.Stack;
import csci152.impl.ArrayListStack;

/**
 *
 * @author Anvar Adylov
 */
public class TestArrayListStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayListStack();
        
        try {
        stack.pop();
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        for (int i=0;i<11;i++) {
        stack.push(1+i);
        System.out.println(stack); 
        }
        try {
        for (int i=0;i<5;i++) {
        System.out.println(stack.pop());
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        System.out.println(stack);
        }
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);
    }
}
