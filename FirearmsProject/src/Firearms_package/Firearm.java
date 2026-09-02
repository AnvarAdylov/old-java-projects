/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Firearms_package;

/**
 *
 * @author Anvar Adylov
 */
public class Firearm {
    private String name;
    protected int maxLoad;
    protected int currentLoad;
    
    /**maxLoad - is responsible for bullet capacity of the gun
     * currentLoad - showing how many bullets left 
     * 
     * @param n Name of the Gun
     */
    public Firearm(String n) {
        name = n;
        maxLoad = 1;
        currentLoad = 0;
    }
    /**Reload your gun setting amount of ammunition to the maximum
     * 
     */
    public void reload() {
        currentLoad = maxLoad;
    }
    /**To make a shot from a gun, if you out of ammo 
     * it will give you "No ammo!" message instead of making a sound.
     * 
     */
    public void shot() {
        if (currentLoad > 0) {
            System.out.println("PUFF!!!");
            currentLoad--;
        } else {
        System.out.println("No ammo!");    
        }
    }
    /**Gun name getter
     * 
     * @return name of the gun
     */
    public String getName() {
        return name;
    }
    /**Getter for your current ammunition amount
     * 
     * @return currentLoad
     */
    public int getBullets() {
        return currentLoad;
    }
    /**Getter for your maximum possible ammunition amount
     * 
     * @return maxLoad
     */
    public int getCapacity() {
        return maxLoad;
    }
    /**To String function
     * 
     * @return Structured information about the gun.
     */
    public String toString() {
        return "The gun:" + name + "\nStatus:" + currentLoad + "/" + maxLoad;
    }
}
