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
public class Rifle extends Firearm {
    private Boolean safety;
    private Boolean silencer;
    /**The rifle which could be upgraded with silencer and has 
     * safe mode. 
     * 
     * @param n name of the rifle
     * @param saf is safe mode on
     * @param sil is silencer equipped
     */
    public Rifle(String n, Boolean saf, Boolean sil) {
        super(n);
        safety = saf;
        silencer = sil;
    }
    /** The rifle has safety switch which allow you 
     * to avoid undesired shooting.
     * If safety was already enabled it will 
     * disable it.
     * 
     */
    public void switchSafety() {
        if (safety) {
            safety = false;
        } else {
            safety = true;
        }
    }
    
    /**This function is responsible for silencer
     * if silencer was equipped it will take it off,
     * or otherwise will put it on.
     * 
     */    
    public void putOrRemoveSilencer() {
        if (silencer) {
            silencer = false;
        } else {
            silencer = true;
        }
    }
    /**If safety was enabled mechanism will prevent rifle from shooting.
     * 
     */
    public void shot() {
        if (safety) {
        System.out.println("Clack!");
        } else {
        if (getBullets() > 0) {
          if (silencer) {
              System.out.println("PHT!");
          } else {
              System.out.println("TAFF!!!");
          }
        currentLoad--;
        } else {
        System.out.println("No ammo!");    
        }
        }
    }
    
    public String toString() {
        if (silencer) {
            if (safety) {
                return "Rifle " + getName() + 
                "\nStatus:" + getBullets() + "/" + getCapacity() 
                + "\nHas a silencer, and currently in the safe mode.";
            } else {
                return "Rifle " + getName() + 
                "\nStatus:" + getBullets() + "/" + getCapacity() 
                + "\nHas a silencer.";
            }
        } else if (safety) {
                return "Rifle " + getName() + 
                "\nStatus:" + getBullets() + "/" + getCapacity() 
                + "\nCurrently in the safe mode.";
        } else {
                return "Rifle " + getName() + 
                "\nStatus:" + getBullets() + "/" + getCapacity();
        }
        
    }
}
