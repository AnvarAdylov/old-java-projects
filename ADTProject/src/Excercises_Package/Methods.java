/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

import Queue.impl.ArrayIntQueue;
import csci152.impl.ArrayIntStack;
import csci152.adt.IntQueue;
import csci152.adt.IntStack;

/**
 *
 * @author Anvar Adylov
 */
public class Methods {
    
    
    public static int evenCount(IntStack stk) {
        IntStack  temp = new ArrayIntStack();
        int x, s;
        int c = 0;
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
                stk.push(temp.pop());
        }
        } catch(Exception ex) {
           System.out.println("I caught an exception!");
           System.out.println(ex);
        }
        return c;
    }
    public static IntStack copyStack(IntStack orig) {
        IntStack temp = new ArrayIntStack();
        IntStack copy = new ArrayIntStack();
        int s, x;
        s = orig.getSize();
        try {
        for (int i = 0;i<s;i++) {
            temp.push(orig.pop());
        }
        for (int i = 0;i<s;i++) {
            x = temp.pop();
            copy.push(x);
            orig.push(x);
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        return copy;
    }
    public static IntQueue copyQueue(IntQueue orig) {
        IntQueue copy = new ArrayIntQueue();
        int s, x;
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
    public static void reverseStack(IntStack toRev) {
        IntQueue temp = new ArrayIntQueue();
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
    public static void reverseQueue(IntQueue toRev) {
        IntStack temp = new ArrayIntStack();
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
    public static boolean isPalindrome(IntQueue q) {
        int s = q.getSize();
        IntQueue temp1 = new ArrayIntQueue();
        IntQueue temp2 = new ArrayIntQueue();
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
    public static void insert(IntStack st, int pos, int val) {
        IntStack temp = new ArrayIntStack();
        int s, x;
        s = st.getSize();
        try {
        for (int i=0;i<s;i++) {
            temp.push(st.pop());
        }
        for (int i = 0;i<s+1;i++) {
            if (i+1 == pos) {
                st.push(val);
            } else {
            x = temp.pop();
            st.push(x);
            }
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }
        
    }
    public static IntStack merge(IntStack s1, IntStack s2) {
        int size1,size2,x,y,a = 1,b = 1;
        size1 = s1.getSize();
        size2 = s2.getSize();
        IntStack copy1 = new ArrayIntStack();
        IntStack copy2 = new ArrayIntStack();
        IntStack result = new ArrayIntStack();
        copy1 = copyStack(s1);
        copy2 = copyStack(s2);
        reverseStack(copy1);
        reverseStack(copy2);
        try {
        x = copy1.pop();
        y = copy2.pop();
        for (int i=1;i<size1+size2;i++) {
            if (x<y) {
                if (a == size1) {
                    x = 1000000;
                } else {
                result.push(x);
                x = copy1.pop();
                a++;
                }
            } else if (y<x) {
                if (b == size2) {
                    y = 1000000;
                } else {
                result.push(y);
                y = copy2.pop();
                b++;
                }
            } else if (y==x) {
                result.push(x);
                result.push(x);
                if (a == size1) {
                    x = 1000000;
                } else {
                x = copy1.pop();
                
                }
                if (b == size2) {
                    y = 1000000;
                } else {
                y = copy2.pop();
                
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
    IntStack stack = new ArrayIntStack();
    IntStack stack3 = new ArrayIntStack();
    IntStack stack4 = new ArrayIntStack();
    IntQueue queue = new ArrayIntQueue();
    IntQueue queue3 = new ArrayIntQueue();
    for (int i=0;i<10;i++) {
    stack.push(i+1);
    stack3.push(i+10);
    queue.enqueue(i+1);
    queue3.enqueue(2);
    }
  
    System.out.println(stack);
    System.out.println(evenCount(stack));
    System.out.println(stack);
    IntStack stack2 = copyStack(stack3);
    System.out.println(stack2);
    System.out.println(stack3);
    System.out.println(copyStack(stack));
    
    System.out.println(queue);
    IntQueue queue2 = copyQueue(queue);
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
