/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package.Sets_Package;

import csci152.adt.HashTableSet;
import csci152.adt.HashTableStats;
import csci152.adt.Set;
import csci152.impl.LLQHashTableSet;


/**
 *
 * @author Anvar Adylov
 */
public class LLQHashTableSetTest {
    public static void tester(HashTableSet<Integer> set) {
        System.out.println(set.getNumberOfBuckets());
        System.out.println(set.getLoadFactor());
        try {
        System.out.println(set.getBucketSize(1));
        } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
    }
        System.out.println(set.getBucketSizeStandardDev());
        System.out.println(set.bucketsToString());
    }
    public static void main(String[] args) {
    LLQHashTableSet s = new LLQHashTableSet(10);
    try {
    s.removeAny();
    } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
    }
    System.out.println(s);
    for (int i = 1;i<21;i++) {
        s.add(i);
    }
    System.out.println(s);
    System.out.println(s.getSize());
    for (int i = 1;i < 11;i++) {
        s.remove(i*2);
    }
    System.out.println(s);
    System.out.println(s.getSize());
    System.out.println(s.remove(10));
    System.out.println(s.remove(100));
    System.out.println(s);
    System.out.println(s.getSize());
    for (int i = 1;i<31;i++) {
        s.add(i);
    }
    System.out.println(s);
    System.out.println(s.getSize());
    try {
    for (int i = 0;i<10;i++) {
        System.out.println(s.removeAny());
        System.out.println(s);
        System.out.println(s.getSize());
    }
    } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
    }
    s.clear();
    System.out.println(s);
    System.out.println(s.getSize());
    for (int i = 0;i<15;i++) {
        s.add(51 + 2*i);
    }
    System.out.println(s);
    System.out.println(s.getSize());
    tester(s);
}
}
