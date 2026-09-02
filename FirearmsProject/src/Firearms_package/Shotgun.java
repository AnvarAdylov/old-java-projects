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
public class Shotgun extends Firearm {
    private Boolean isDoubleBarreled;
    
    /**The shotgun type constructor
     * 
     * @param n name of the shotgun
     * @param type responsible for the type of shotgun 
     * is it single or double barreled
     */
    public Shotgun(String n, Boolean type) {
        super(n);
        isDoubleBarreled = type;
        if (isDoubleBarreled) {
         maxLoad = 2;   
        } else {
         maxLoad = 1;   
        }
        currentLoad = 0;
    }

    public void shot() {
        if (getBullets() > 0) {
        System.out.println("BAM!!!");
        currentLoad--;
        } else {
        System.out.println("No ammo!");    
        }
    }
    
    public String toString() {
        return "Shotgun " + getName() + "\nStatus:" + getBullets() + "/" + getCapacity();
    }
}
