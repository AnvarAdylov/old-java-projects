/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet_package;

/**
 *
 * @author Anvar Adylov
 */
public class Dog extends Pet {
    private Boolean isBig;
    
    public Dog(String n,Boolean bg) {
        super(n);
        isBig = bg;
    }
    
    public void bark() {
        if (isBig) {
            System.out.println("WOOF!!!");
        } else {
            System.out.println("Guf, guf.");
        }
    }
    
    public void eat() {
             if (isBig) {
            System.out.println("MURF!!");
        } else {
            System.out.println("Chump chump.");
        }
    }
    
    public String toString() {
        return "Dog named " + getName();
    }
}
