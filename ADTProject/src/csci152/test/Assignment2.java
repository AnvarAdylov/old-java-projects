/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.test;

import csci152.adt.Queue;
import csci152.adt.Stack;
import csci152.impl.LinkedListQueue;
import csci152.impl.LinkedListStack;

/**
 *
 * @author Anvar Adylov 
 */
public class Assignment2 {
//Method allowing to check does Stack contents are in ascending order.
public static boolean isIncreasing(Stack<Integer> st) {
        Stack<Integer> temp = new LinkedListStack();
        int size;
        int x1,x2;
        size = st.getSize();
        boolean inc = true;
        try {
        for (int i=0;i<size;i++) {
            temp.push(st.pop());
        }
        x1 = temp.pop();
        st.push(x1);
        for (int i=1;i<size;i++) {
            x2 = x1;
            x1 = temp.pop();
            if (x2>x1) {
                inc = false;
            }
            st.push(x1);
        }
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        return inc;
    }
//Method which sorts Stack by absolute value
public static void absSort(Stack<Integer> st) throws Exception {
    if (isIncreasing(st) == false) {
        throw new Exception("The stack is not sorted");
    } else {
    Stack<Integer> postemp = new LinkedListStack();
    Queue<Integer> negtemp = new LinkedListQueue();
    int x, size;        
    size = st.getSize();
        for (int i=0;i<size;i++) {
           x = st.pop();
           if (x<0) {
               negtemp.enqueue(x);
           } else {
               postemp.push(x);
           }
        }
        int p,n,sp,sn;
        sp = postemp.getSize();
        sn = negtemp.getSize();
        p = postemp.pop();
        n = negtemp.dequeue();
        for (int i=0;i<size;i++) {
            if (sp == 0) {
                st.push(n);
                sn--;
                if (sn != 0) {
                n = negtemp.dequeue();
                }
            } else if (sn == 0) {
                st.push(p);   
                sp--;
                if (sp != 0) {
                p = postemp.pop();
                }
            } else if (p<-n) {
                st.push(p);   
                sp--;
                if (sp != 0) {
                p = postemp.pop();
                }
            } else if (-n<p) {
                st.push(n);
                sn--;
                if (sn != 0) {
                n = negtemp.dequeue();
                }
            } else if (-n==p){
                st.push(n);
                st.push(p);
                sn--;
                sp--;
                i++;
                if (sn != 0) {
                n = negtemp.dequeue();
                }
                if (sp != 0) {
                p = postemp.pop();
                }
            }
            
        }
    }
}
// Old methods from lesson 8 implemented to make easier implementation of isPalindrom
public static Queue copyQueue(Queue<Character> orig) {
        Queue copy = new LinkedListQueue();
        int s; 
        Character x;
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
public static void reverseQueue(Queue<Character> toRev) {
        Stack<Character> temp = new LinkedListStack();
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
// Actual implementation of isPalindrom
public static boolean isPalindrome(Queue<Character> q) {
        int s = q.getSize();
        if (s == 0) {
            return true;
        }
        Queue<Character> temp1 = new LinkedListQueue();
        Queue<Character> temp2 = new LinkedListQueue();
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
// Selection sort is used.
public static Double findMin(Queue<Double> q) throws Exception {
    int sz;
        sz = q.getSize();
        Double min, temp;
        
        min = q.dequeue();
        if (sz == 1) {
            return min;
        }
        try {
        for (int i=0;i<sz;i++) {
            temp = q.dequeue();
            if (min < temp) {
                q.enqueue(temp);
            } else {
                q.enqueue(min);
                min = temp;
            }
        }
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }  
    return min;
}
public static void sort(Queue<Double> q) {
    Stack<Double> tempst = new LinkedListStack();
    int sz = q.getSize();
    try {
    for (int i=0;i<sz;i++) {
        tempst.push(findMin(q));
    }
    for (int i=0;i<sz;i++) {
        q.enqueue(tempst.pop());
    }
    } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
    }  
}
// To make easier checking 
public static boolean isLegal(Queue<Character> q) {
    int size;
    
    boolean legal = true;
    size = q.getSize();
    try {
        char x;
        for (int i = 0;i<size;i++) {
            x = q.dequeue();
            if (x == '(' || x == '[' || x == '{' || x == ')' || x == ']' || x == '}') {
                
            } else {
                legal = false;
            }
            q.enqueue(x);
        }
    } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
    }  
    return legal;
}
//
public static boolean isClosedPair(Queue<Character> q, char x) {
    char y;
    try {
        y = q.dequeue();
    
    if (x == '(') {
        if (y == '(' || y == '[' || y == '{') {
            if (isClosedPair(q, y)) {
                return isClosedPair(q, x);
            }
        } else if (y == ')') {
            return true;
        } else {
            return false;
        }
    } else if (x == '[') {
        if (y == '(' || y == '[' || y == '{') {
            if (isClosedPair(q, y)) {
              return isClosedPair(q, x);
            }
        } else if (y == ']') {
            return true;
        } else {
            return false;
        }
    } else if (x == '{') {
        if (y == '(' || y == '[' || y == '{') {
            if (isClosedPair(q, y)) {
                return isClosedPair(q, x);
            }
        } else if (y == '}') {
            return true;
        } else {
            return false;
        }
        }
    } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
    }  
    return false;
}
// Method checking balanced or not
public static boolean isBalanced(Queue<Character> q) throws Exception {
   boolean balanced = true;
   Queue<Character> copy = new LinkedListQueue();
   char x;
   int sz, csz;
   sz = q.getSize();
   if (isLegal(q) == false) {
        throw new Exception("Illegal character");
    } else {
   if (sz == 0) {
       return balanced;
   } else if (sz%2 != 0) {
       return false;
   }
   for (int i = 0;i<sz;i++) {
       x = q.dequeue();
       q.enqueue(x);
       copy.enqueue(x);
   }    
   csz = copy.getSize();
    
        while (csz != 0) {
            x = copy.dequeue();
            if (x == '(' || x == '[' || x == '{') {
                if (isClosedPair(copy, x) == false) {
                    return false;
                }
            } else { 
                return false;
            }
            csz = copy.getSize();
        }
    }
    return balanced;
}
//
public static void main(String[] args) { 
        Stack<Integer> test = new LinkedListStack();
        
        for (int i=5;i>0;i--) {
            test.push(-4*i);
        }
        for (int i=2;i<7;i++) {
            test.push(i*5);
        }
        System.out.println(test);
        System.out.println(isIncreasing(test));
        System.out.println(test);
        try {
        absSort(test);
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }     
        System.out.println(test);
        Queue<Double> test1 = new LinkedListQueue();
        for (int i=5;i>0;i--) {
            test1.enqueue(-4.0*i);
        }
        for (int i=2;i<7;i++) {
            test1.enqueue(i*5.0);
        }
        System.out.println(test1);
        sort(test1);
        System.out.println(test1);
        Queue<Character> test2 = new LinkedListQueue();
        System.out.println(test2);
        test2.enqueue('(');
        test2.enqueue('[');
        test2.enqueue('{');
        test2.enqueue('[');
        test2.enqueue('(');
        test2.enqueue('{');
        test2.enqueue('}');
        test2.enqueue(')');
        test2.enqueue(']');
        test2.enqueue('}');
        test2.enqueue(']');
        test2.enqueue(')');
        System.out.println(test2);
        Queue<Character> test3 = new LinkedListQueue();
        test3.enqueue('(');
        test3.enqueue('[');
        test3.enqueue('A');
        test3.enqueue('[');
        test3.enqueue('(');
        System.out.println(isPalindrome(test2));
        System.out.println(isPalindrome(test3));
        try {
        System.out.println(isBalanced(test2));
        System.out.println(isBalanced(test3));
        } catch(Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
        }   
        System.out.println(test2);
    }
}
