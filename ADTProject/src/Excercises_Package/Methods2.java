/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;


import Queue.impl.ArrayQueue;
import csci152.impl.ArrayStack;
import csci152.adt.Queue;
import csci152.adt.Stack;

/**
 *
 * @author Anvar Adylov
 * @param <T>

 */
public class Methods2<T> {
    
    public static int evenCount(Stack<Integer> stk) {
        Stack  temp = new ArrayStack();
        Integer x;
        int s, c = 0;
        s = stk.getSize();
        try {
            for (int i = 0;i<s;i++) {
               x = stk.pop();
               temp.push(x);
               if (x%2==0) {
                   c++;
               }
            }
        for (int i = 0;i<s;i++) {
                x = (Integer) temp.pop();
                stk.push(x);
        }
        } catch(Exception ex) {
           System.out.println("I caught an exception!");
           System.out.println(ex);
        }
        return c;
    }
    public static Stack copyStack(Stack<Integer> orig) {
        Stack temp = new ArrayStack();
        Stack copy = new ArrayStack();
        Integer x;
        int s;
        s = orig.getSize();
        try {
        for (int i = 0;i<s;i++) {
            temp.push(orig.pop());
        }
        for (int i = 0;i<s;i++) {
            x = (Integer) temp.pop();
            copy.push(x);
            orig.push(x);
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        return copy;
    }
    public static Queue copyQueue(Queue<Integer> orig) {
        Queue copy = new ArrayQueue();
        int s; 
        Integer x;
        s = orig.getSize();
        try {
        for (int i = 0;i<s;i++) {
            x = orig.dequeue();
            copy.enqueue(x);
            orig.enqueue(x);
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        return copy;
    }
    public static void reverseStack(Stack<Integer> toRev) {
        Queue<Integer> temp = new ArrayQueue();
        int s;
        s = toRev.getSize();
        try {
        for (int i = 0;i<s;i++) {
            temp.enqueue(toRev.pop());    
        }
        for (int i = 0;i<s;i++) {
            toRev.push(temp.dequeue());    
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
    }
    public static void reverseQueue(Queue<Integer> toRev) {
        Stack<Integer> temp = new ArrayStack();
        int s;
        s = toRev.getSize();
        try {
        for (int i = 0;i<s;i++) {
            temp.push(toRev.dequeue());    
        }
        for (int i = 0;i<s;i++) {
            toRev.enqueue(temp.pop());    
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
    }
    public static boolean isPalindrome(Queue<Integer> q) {
        int s = q.getSize();
        Queue<Integer> temp1 = new ArrayQueue();
        Queue<Integer> temp2 = new ArrayQueue();
        temp1 = copyQueue(q); 
        temp2 = copyQueue(temp1);
        reverseQueue(temp2);
        try {
        for (int i=0;i<s;i++) { 
            if (temp1.dequeue() != temp2.dequeue()) {
                return false;
            }
        } 
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        return true;    
    }
    public static void insert(Stack<Integer> st, int pos, Integer val) {
        Stack<Integer> temp = new ArrayStack();
        int s;
        Integer x;
        s = st.getSize();
        try {
        for (int i=0;i<s;i++) {
            temp.push(st.pop());
        }
        for (int i = 0;i<s+1;i++) {
            if (i+1 == pos) {
                st.push(val);
            } else {
            st.push(temp.pop());
            }
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        
    }
    public static Stack merge(Stack<Integer> s1, Stack<Integer> s2) {
        int size1,size2,x,y,a = 1,b = 1;
        size1 = s1.getSize();
        size2 = s2.getSize();
        Stack<Integer> copy1 = new ArrayStack();
        Stack<Integer> copy2 = new ArrayStack();
        Stack<Integer> result = new ArrayStack();
        copy1 = copyStack(s1);
        copy2 = copyStack(s2);
        reverseStack(copy1);
        reverseStack(copy2);
        try {
        x = (int) copy1.pop();
        y = (int) copy2.pop();
        for (int i=1;i<size1+size2;i++) {
            if (x<y) {
                if (a == size1) {
                    x = 1000000;
                } else {
                result.push(x);
                x = (int) copy1.pop();
                a++;
                }
            } else if (y<x) {
                if (b == size2) {
                    y = 1000000;
                } else {
                result.push(y);
                y = (int) copy2.pop();
                b++;
                }
            } else if (y==x) {
                result.push(x);
                result.push(x);
                if (a == size1) {
                    x = 1000000;
                } else {
                x = (int) copy1.pop();
                }
                if (b == size2) {
                    y = 1000000;
                } else {
                y = (int) copy2.pop();
                }
            }
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        return result;
        
    }
    
    
    public static void main(String[] args) { 
    Stack<Integer> stack = new ArrayStack();
    Stack<Integer> stack3 = new ArrayStack();
    Stack<Integer> stack4 = new ArrayStack();
    Queue<Integer> queue = new ArrayQueue();
    Queue<Integer> queue3 = new ArrayQueue();
    for (int i=0;i<10;i++) {
    stack.push(i+1);
    stack3.push(i+10);
    queue.enqueue(i+1);
    queue3.enqueue(2);
    }
  
    System.out.println(stack);
    System.out.println(evenCount(stack));
    System.out.println(stack);
    Stack<Integer> stack2 = copyStack(stack3);
    System.out.println(stack2);
    System.out.println(stack3);
    System.out.println(copyStack(stack));
    
    System.out.println(queue);
    Queue<Integer> queue2 = copyQueue(queue);
    System.out.println(queue2);
    System.out.println(queue);
    reverseStack(stack2);
    System.out.println(stack2);
    reverseQueue(queue2);
    System.out.println(queue2);
    System.out.println(isPalindrome(queue));
    System.out.println(isPalindrome(queue3));
    
    insert(stack3, 5, 20);
    System.out.println(stack3);
    stack4 = merge(stack,stack3); 
    System.out.println(stack4);
    System.out.println(stack);
    System.out.println(stack3);
    }
    
}
