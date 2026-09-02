/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package.Sets_Package;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Anvar Adylov
 */
public class SetBSTTestJavaAPI {
    public static void main(String[] args) {
       Set<Integer> set = new  HashSet();
        System.out.println(set);
        System.out.println(set.size());
        set.add(5);
        System.out.println(set);
        System.out.println(set.size());
        set.add(12);
        System.out.println(set);
        System.out.println(set.size());
        set.add(3);
        System.out.println(set);
        System.out.println(set.size());
        set.add(6);
        set.add(14);
        set.add(2);
        set.add(-6);
        set.add(8);
        set.add(0);
        System.out.println(set);
        System.out.println(set.size());
        set.add(14);
        set.add(-6);
        set.add(5);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(12));
        System.out.println(set.contains(7));
        System.out.println(set.contains(2));
        System.out.println(set.contains(-8));
        System.out.println(set.contains(5));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.remove(0));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.remove(6));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.remove(3));
        System.out.println(set);
        System.out.println(set.size());
        set.add(6);
        set.add(13);
        set.add(99);
        set.add(11);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.remove(12));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.remove(5));
        System.out.println(set);
        System.out.println(set.size());
        set.clear();
        System.out.println(set);
        System.out.println(set.size());
        set.add(55);
        set.add(24);
        set.add(78);
        set.add(51);
        System.out.println(set);
        System.out.println(set.size());
    }
}
