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
public class Hero extends Unit {
    private int attack;
    private Boolean isRanged;
    
    public Hero(String n, Boolean ranged) {
         super(n);
         isRanged = ranged;
         if (isRanged) {
            hp = 75;
            attack = 30;
         } else {
            hp = 100;
            attack = 25;
         }         
         
    }
    public void say() {
        if (isRanged) {
        System.out.println("My arrows never miss!");
        } else {
        System.out.println("My sword is always ready!");
        }
    }
    public String toString() {
        return "Hero " + getName() + "\nHealth:" + hp + "\nÄttack:" + attack;
    }
}
