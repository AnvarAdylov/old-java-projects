/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet_package;

/**
 *
 * @author Габдул
 */
public class Cat extends Pet {
    public Cat(String n) {
        super(n);
    }
    
    public void meow() {
        System.out.println("mew....meow.....");
    }
    
    public void eat() {
        System.out.println("slurp, slurp");
    }
    
    public String toString() {
        return "Cat named " + getName();
    }
}
