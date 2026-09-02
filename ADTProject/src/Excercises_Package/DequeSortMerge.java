/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

import csci152.adt.Deque;
import csci152.impl.LinkedListDeque;

/**
 *
 * @author Anvar Adylov
 */
public class DequeSortMerge {
public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
    /* assuming d1 and d2 are sorted, merge their contents
    into a single sorted Deque, and return it */
    int sz1,sz2,x1,x2,rsz;
    Deque<Integer> result = new LinkedListDeque();
    sz1 = d1.getSize();
    sz2 = d2.getSize();
    rsz = sz1+sz2;
    try { 
    x1 = d1.popFromFront();
    x2 = d2.popFromFront();
        
    for (int i = 0;i<rsz;i++) {
        if (x1>x2 && sz1 > 0) {
            result.pushToBack(x1);
            sz1--;   
            if(sz1!=0) {
                x1 = d1.popFromFront();    
            } 
            
        } else if (x1<x2 && sz2 > 0) {
            result.pushToBack(x2);
            sz2--; 
            if(sz2!=0) {
            x2 = d2.popFromFront();
            }
            
        } else if (x1==x2) {
            result.pushToBack(x1);
            result.pushToBack(x2);
            sz1--;
            sz2--;
            if(sz1!=0) {
                x1 = d1.popFromFront();
            }
            if(sz2!=0) {
                x2 = d2.popFromFront();
            }
            i++;
        } else if (sz1 <= 0 && sz2 > 0 ) {
                result.pushToBack(x2);     
                sz2--;
                if(sz2!=0) {
                    x2 = d2.popFromFront();
                }
        } else if (sz2 <= 0 && sz1 > 0) {
                result.pushToBack(x1);   
                sz1--;
                if(sz1!=0) {
                    x1 = d1.popFromFront();
                }
        }
        
    }
    } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
    }
    return result;
} 
public static Deque<Integer> mergeSort(Deque<Integer> deq) {
    int sz, x1, x2;
    sz = deq.getSize();
    Deque<Integer> result = new LinkedListDeque();
    Deque<Integer> d1 = new LinkedListDeque();
    Deque<Integer> d2 = new LinkedListDeque();
    try {
    //Step 0:  base case???
    if (sz == 1) {
        return deq;
    } else if (sz == 2) {
        x1 = deq.popFromFront();
        x2 = deq.popFromBack();
        if (x1>x2) {
            result.pushToBack(x1);
            result.pushToBack(x2);
            deq = result;
            return result;
        } else {
            result.pushToBack(x2);
            result.pushToBack(x1);
            deq = result;
            return result;
        }
    } else {
    //Step 1:  split deq into two Deques of relatively equal size
        if (sz%2 == 0) {
            for (int i=0;i<sz/2;i++) {
                d1.pushToBack(deq.popFromFront());
                d2.pushToFront(deq.popFromBack());    
            }
            //Step 2:  pass both of these Deques into mergeSort
            d1 = mergeSort(d1);
            d2 = mergeSort(d2);
            //Step 3:  pass the resulting Deques into merge, and return the result
            result = merge(d1,d2);
            deq.clear();
            for (int i = 0;i<sz;i++) {
                x1 = result.popFromFront();
                deq.pushToBack(x1);
                result.pushToBack(x1);
            }
            return result;
        } else {
            d1.pushToBack(deq.popFromFront());
            for (int i=0;i<(sz-1)/2;i++) {
                d1.pushToBack(deq.popFromFront());
                d2.pushToFront(deq.popFromBack());    
            }
            //Step 2:  pass both of these Deques into mergeSort
            d1 = mergeSort(d1);
            d2 = mergeSort(d2);
            //Step 3:  pass the resulting Deques into merge, and return the result
            result = merge(d1,d2);
            deq.clear();
            for (int i = 0;i<sz;i++) {
                x1 = result.popFromFront();
                deq.pushToBack(x1);
                result.pushToBack(x1);
            }
            return result;
        }
    }
    } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
    } 
    return result;
}

public static void main(String[] args) {

    Deque<Integer> deque = new LinkedListDeque();
    for (int i=0;i<10;i++) {
        if (i%2 == 0) {
            deque.pushToFront(i*2+1);
        } else {
            deque.pushToBack((i+1)*2);
        }
    }
    System.out.println(deque);
    System.out.println(deque.getSize());
    mergeSort(deque);
    System.out.println(deque);
    System.out.println(deque.getSize());

}
}
