/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Package;

/**
 *
 * @author Anvar Adylov
 */
public class Unit {
    private String name;
    public int hp;
    
    /**
     * 
     * @param n 
     */
    public Unit(String n) {
         name = n;
         hp = 20;
    }
    // Methods
    public String getName() {
        return name;
    }
    
    public void say() {
        System.out.println("Yes?");
    }
    
    public String toString() {
        return name + "\nHealth:" + hp;
    }
}
