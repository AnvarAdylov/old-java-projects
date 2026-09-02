/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package.Sets_Package;

import csci152.impl.BSTSet;

/**
 *
 * @author Anvar Adylov
 */
public class SetBSTTest {
    public static void main(String[] args) {
        BSTSet<Integer> set = new BSTSet();
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(5);
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(12);
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(3);
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(6);
        set.add(14);
        set.add(2);
        set.add(-6);
        set.add(8);
        set.add(0);
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(14);
        set.add(-6);
        set.add(5);
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.contains(12));
        System.out.println(set.contains(7));
        System.out.println(set.contains(2));
        System.out.println(set.contains(-8));
        System.out.println(set.contains(5));
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.remove(0));
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.remove(6));
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.remove(3));
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(6);
        set.add(13);
        set.add(99);
        set.add(11);
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.remove(12));
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.remove(5));
        System.out.println(set);
        System.out.println(set.getSize());
        try {
        System.out.println(set.removeAny());
        System.out.println(set.removeAny());
        System.out.println(set.removeAny());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(set);
        System.out.println(set.getSize());
        set.clear();
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(55);
        set.add(24);
        set.add(78);
        set.add(51);
        System.out.println(set);
        System.out.println(set.getSize());
    }
}
