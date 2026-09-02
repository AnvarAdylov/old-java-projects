/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package.Sets_Package;

import Excercises_Package.Student;
import csci152.adt.Set;
import csci152.impl.LLQueueSet;

/**
 *
 * @author Anvar Adylov
 */
public class SetTest {
    public static void main(String[] args) {
        /*
        Set<Integer> set = new LLQueueSet();
        set.add(11);
        set.add(55);
        set.add(35);
        
        System.out.println(set);
        
        set.add(55);
        System.out.println(set);
        System.out.println(set.remove(35));
        System.out.println(set);
                
        Set<String> set = new LLQueueSet();
        try {
        System.out.println(set.removeAny());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(set.getSize());
        set.add("John Cena");
        set.add("Scooby Doo");
        set.add("Blade");
        System.out.println(set);
        System.out.println(set.getSize());
        try {
        System.out.println(set.removeAny());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(set);
        System.out.println(set.getSize());
        set.add("Blade");
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.remove("Scooby Doo"));
        System.out.println(set);
        System.out.println(set.getSize());
        */
        Set<Student> set = new LLQueueSet();
        try {
        System.out.println(set.removeAny());
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(new Student("John Cena", 1234));
        set.add(new Student("Dunkan McLaud", 5268));
        set.add(new Student("Stan Lee", 5722));
        set.add(new Student("Moishe Berenbaum", 1942));
        set.add(new Student("Van Hohenheim", 4444));
        System.out.println(set);
        System.out.println(set.getSize());
        
        Student t = new Student("Stan Lee", 5722);
        set.remove(t);
        
        System.out.println(set);
        System.out.println(set.getSize());
        set.remove(t);
        
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(new Student("John Cena", 1234));
        set.add(new Student("Dunkan McLaud", 5268));
        System.out.println(set);
        System.out.println(set.getSize());
        set.add(new Student("Kung Lao", 2346));
        set.add(new Student("Kenshi Takahashi", 1004));
        set.add(new Student("Kukusyamba Vavatumba", 6273));
        System.out.println(set);
        System.out.println(set.getSize());
        try {
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
        set.add(new Student("Bob Marley", 3786));
        set.add(new Student("Rick Spanish", 666));
        System.out.println(set);
        System.out.println(set.getSize());
                
    }
}
