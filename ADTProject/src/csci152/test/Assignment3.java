/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.test;

import csci152.adt.Set;
import csci152.impl.BSTSet;
import csci152.impl.LLQHashTableSet;

/**
 *
 * @author Anvar Adylov
 */
public class Assignment3 {
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> temp1 = new LLQHashTableSet(10);
        Set<Integer> temp2 = new LLQHashTableSet(10);
        int s1 = set1.getSize();
        int x;
        boolean sub = true;
        if (s1>set2.getSize()) {
            return false;
        }
        for(int i = 0;i<s1;i++) {
            try {
            temp1.add(set1.removeAny());
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        for(int i = 0;i<s1;i++) {
            try {
            x = temp1.removeAny();
            set1.add(x);
            if (!set2.contains(x)) {
                sub = false;
            }
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        return sub;
    }
    
    public static Set<String> union(Set<String> set1, Set<String> set2) {
        Set<String> result = new LLQHashTableSet(10);
        Set<String> temp1 = new LLQHashTableSet(10);
        Set<String> temp2 = new LLQHashTableSet(10);
        int s1,s2,sz;
        String val;
        s1 = set1.getSize();
        s2 = set2.getSize();
        sz = s1+s2;
        for(int i = 0;i<s1;i++) {
            try {
            temp1.add(set1.removeAny());
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        for(int i = 0;i<s2;i++) {
            try {
            temp2.add(set2.removeAny());
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        for (int i = 0;i<sz;i++) {
            try{
            if(i<s1) {
                val = temp1.removeAny();
                set1.add(val);
            } else {
                val = temp2.removeAny();
                set2.add(val);
            }
            result.add(val);
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        return result;
    }
    
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> temp1 = new LLQHashTableSet(10);
        Set<Integer> temp2 = new LLQHashTableSet(10);
        Set<Integer> result = new LLQHashTableSet(10);
        int s1 = set1.getSize();
        int x;
        for(int i = 0;i<s1;i++) {
            try {
            temp1.add(set1.removeAny());
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        for(int i = 0;i<s1;i++) {
            try {
            x = temp1.removeAny();
            set1.add(x);
            if (set2.contains(x)) {
                result.add(x);
            }
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        return result;
    }
    
    public static boolean areAllPrime(Set<Integer> pset) {
        Set<Integer> temp1 = new LLQHashTableSet(10);
        Set<Integer> temp2 = new LLQHashTableSet(10);
        int s1 = pset.getSize();
        int x, div;
        boolean prime = true;
        for(int i = 0;i<s1;i++) {
            try {
            temp1.add(pset.removeAny());
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        for(int i = 0;i<s1;i++) {
            try {
            x = temp1.removeAny();
            pset.add(x);
            div = (int)Math.sqrt(x);
            for( int j=2;j <= div;j++) {
            if (x%j == 0) {
                prime = false;
            }
            }
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        }
        return prime;
    }
    
    public static boolean isPrime(int num) {
    int div = (int)Math.sqrt(num);
        for( int j=2;j <= div;j++) {
            if (num%j == 0) {
                 return false;
            }
        } 
        return true;
    }
    public static boolean arePrimeDivisors(int num, Set<Integer> pset) throws Exception {
        int sz;
        Set<Integer> temp = new LLQHashTableSet(10);
        if (num <= 1) {
            throw new Exception("This number cannot have Prime Divisors!");
        }
        sz = pset.getSize();
        if (!areAllPrime(pset)) {
            return false;
        }
        
        int div = (int)Math.sqrt(num);
        for(int i = 2;i<div;i++) {
            if (isPrime(i)) {
                if (num%i == 0) {
                    temp.add(i);
                }
            }
        }
        if (isSubset(temp, pset) && isSubset(pset, temp)) {
            return true;
        } else {
            return false;
        }
    }
    
public static void main(String[] args) {
    //  {-12} and {8, 33, 5} and {1, 33, 2, 5} are all subsets of {22, 33, 1, 5 -12, 2, 8}, but {22, 33, 99}
    Set<Integer> bset = new BSTSet();
    bset.add(22);
    bset.add(33);
    bset.add(1);
    bset.add(5);
    bset.add(-12);
    bset.add(2);
    bset.add(8);
    Set<Integer> subset1 = new BSTSet();
    Set<Integer> subset2 = new BSTSet();
    Set<Integer> subset3 = new BSTSet();
    Set<Integer> notsubset = new BSTSet();
    subset1.add(-12);
    subset2.add(8);
    subset2.add(33);
    subset2.add(5);
    subset3.add(1);
    subset3.add(33);
    subset3.add(2);
    subset3.add(5);
    notsubset.add(22);
    notsubset.add(33);
    notsubset.add(99);
    System.out.println(isSubset(subset1, bset));
    System.out.println(isSubset(subset2, bset));
    System.out.println(isSubset(subset3, bset));
    System.out.println(isSubset(notsubset, bset));
    System.out.println(subset1);
    System.out.println(subset2);
    System.out.println(subset3);
    System.out.println(notsubset);
    System.out.println(bset);
    
    Set<String> set1 = new BSTSet();
    Set<String> set2 = new BSTSet();
    Set<String> unionset = new BSTSet();
    set1.add("Billy");
    set1.add("Willy");
    set1.add("Johnny");
    set2.add("Billy");
    set2.add("Brian");
    set2.add("Thomas");
    unionset = union(set1, set2);
    System.out.println(set1);
    System.out.println(set2);
    System.out.println(unionset);
    
    Set<Integer> intset1 = new BSTSet();
    Set<Integer> intset2 = new BSTSet();
    Set<Integer> set4 = new BSTSet();
    Set<Integer> set5 = new BSTSet();
    set4.add(13);
    set4.add(25);
    set4.add(7);
    set5.add(16);
    set5.add(45);
    set5.add(2);
    set5.add(18);
    intset1 = intersection(subset2, subset3);
    System.out.println(subset2);
    System.out.println(subset3);
    System.out.println(intset1);
    intset2 = intersection(set4, set5);
    System.out.println(set4);
    System.out.println(set5);
    System.out.println(intset2);
    
    System.out.println(areAllPrime(intset2));
    System.out.println(areAllPrime(intset1));
    System.out.println(areAllPrime(set4));
    System.out.println(intset1);
    System.out.println(set4);
    System.out.println(intset2);
    Set<Integer> set6 = new BSTSet();
    set6.add(7);
    set6.add(2);
    set6.add(11);
    set6.add(3);
    try {
    System.out.println(arePrimeDivisors(1848, set6));
    } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
    }
    System.out.println(set6);
}
}
