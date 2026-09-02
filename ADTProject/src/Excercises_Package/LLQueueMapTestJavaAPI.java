/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Anvar Adylov
 */
public class LLQueueMapTestJavaAPI {
    public static void main(String[] args) {
        Map<Integer, String> test1 = new TreeMap();
        System.out.println(test1);
        System.out.println(test1.size());
        test1.put(25, "Toronto");
        test1.put(12, "Farron");
        test1.put(31, "Bingo");
        test1.put(5, "Pentagon");
        test1.put(1, "Uno");
        System.out.println(test1);
        System.out.println(test1.size());
        test1.remove(12);
        System.out.println(test1);
        System.out.println(test1.size());
        test1.remove(33);
        System.out.println(test1);
        System.out.println(test1.size());
        test1.put(5, "Pentan");
        test1.put(1, "Methan");
        System.out.println(test1);
        System.out.println(test1.size());
        test1.put(2, "Ethil");
        test1.put(15, "Formaline");
        test1.put(32, "Octadecahedron");
        System.out.println(test1);
        System.out.println(test1.size());
        test1.clear();
        System.out.println(test1);
        System.out.println(test1.size());
        test1.put(9, "Nailed");
        test1.put(7, "It");
        System.out.println(test1);
        System.out.println(test1.size());
    }
}
