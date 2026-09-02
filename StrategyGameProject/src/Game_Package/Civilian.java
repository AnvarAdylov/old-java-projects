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
public class Civilian extends Unit {
    private Boolean isWorking;
    public Civilian(String n) {
         super(n);
         hp = 25;
         isWorking = false;
    }
    
    public void giveOrder() {
        
    }
    public void say() {
        if (isWorking) {
        System.out.println("My lord, work is in progress!");    
        } else {
        System.out.println("Yes milord?");
        }
    }
    public String toString() {
        return getName() + "\nHealth:" + hp + "Current status:"  ;
    }
}
