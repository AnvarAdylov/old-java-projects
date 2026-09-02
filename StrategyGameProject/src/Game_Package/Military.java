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
public class Military extends Unit {
    private int attack;
    private Boolean isRanged;
    
    /**
     * 
     * @param n
     * @param type responsible for unit combat type melee/ranged, depending 
     * on type basic stats will be decided.  
     */
    public Military(String n, Boolean type) {
         super(n);
         isRanged = type;
         if (isRanged) {
            hp = 25;
            attack = 15;
         } else {
            hp = 50;
            attack = 10;
         }         
    }
    public void say() {
        if (isRanged) {
        System.out.println("Our aim is ready!");
        } else {
        System.out.println("Aye Commander!");
        }
    }
    
    public String toString() {
        return getName() + "\nHealth:" + hp + "\nÄttack:" + attack;
    }
}
