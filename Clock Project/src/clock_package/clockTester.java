/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock_package;

/**
 *
 * @author Anvar Adylov
 */
public class clockTester {
    public static void main(String[] args) {
        Clock c = new Clock();
        System.out.println(c);
        try {
        c.setSeconds(45);
        System.out.println(c);
        } catch (Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex.getMessage());
        }
        try {
            c.setSeconds(451);
        } catch (Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex.getMessage());
        }
        System.out.println(c);
    }
}
