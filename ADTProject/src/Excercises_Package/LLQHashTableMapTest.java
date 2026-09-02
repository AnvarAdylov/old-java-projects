/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

import csci152.impl.LLQHashTableMap;
import csci152.adt.Map;
import csci152.impl.LLQueueMap;

/**
 *
 * @author Anvar Adylov
 */
public class LLQHashTableMapTest {
    public static void main(String[] args) {
        Map<Integer, String> test1 = new LLQHashTableMap(10);
        System.out.println(test1);
        System.out.println(test1.getSize());
        try {
        test1.removeAny();
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(test1);
        System.out.println(test1.getSize());
        test1.define(25, "Toronto");
        test1.define(12, "Farron");
        test1.define(31, "Bingo");
        test1.define(5, "Pentagon");
        test1.define(1, "Uno");
        System.out.println(test1);
        System.out.println(test1.getSize());
        test1.remove(12);
        System.out.println(test1);
        System.out.println(test1.getSize());
        test1.remove(33);
        System.out.println(test1);
        System.out.println(test1.getSize());
        test1.define(5, "Pentan");
        test1.define(1, "Methan");
        System.out.println(test1);
        System.out.println(test1.getSize());
        test1.define(2, "Ethil");
        test1.define(15, "Formaline");
        test1.define(32, "Octadecahedron");
        System.out.println(test1);
        System.out.println(test1.getSize());
        try {
        System.out.println(test1.removeAny());
        System.out.println(test1.removeAny());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(test1);
        System.out.println(test1.getSize());
        test1.clear();
        System.out.println(test1);
        System.out.println(test1.getSize());
        test1.define(9, "Nailed");
        test1.define(7, "It");
        System.out.println(test1);
        System.out.println(test1.getSize());
    }
}
