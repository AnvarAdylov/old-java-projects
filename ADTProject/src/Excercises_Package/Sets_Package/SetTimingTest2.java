/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package.Sets_Package;

import csci152.adt.HashTableSet;
import csci152.impl.LLQHashTableSet;
import java.util.Random;


/**
 *
 * @author Anvar Adylov
 */
public class SetTimingTest2 {

public static void main(String[] args) {
    Random num = new Random();
    HashTableSet<Integer> set = new LLQHashTableSet(10); 
    
     System.out.println("Starting timing tests...");
     long time1, time2, duration;
     time1 = System.currentTimeMillis();
     
     for (int i = 0; i < 500000; i++) {
         set.add(i);
                 
         // set.add(num.nextInt(500000));
     }
   
     time2 = System.currentTimeMillis();
     duration = time2 - time1;
 
     System.out.println("Time taken in ms: " + duration);
     System.out.println(set.getLoadFactor());
     System.out.println(set.getBucketSizeStandardDev());
} 
}
