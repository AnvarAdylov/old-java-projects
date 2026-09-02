/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Firearms_package;

import java.util.Scanner;

/**
 *
 * @author Anvar Adylov
 */
public class Handgun extends Firearm {
    private double caliber;
    
    
    /**The constructor for handgun 
     * with a magazine for 9 bullets
     * User enter caliber which is a positive double with a maximum of 12.7 mm,
     * and minimum 2.00 mm.
     * If improper range of values written exception will be thrown
     * 
     * @param n
     * @throws Exception Value between 2.00 and 12.7 mm.
     */
    public Handgun(String n) throws Exception {
        super(n);
        maxLoad = 9;
        System.out.println("Input caliber of the handgun:");
        Scanner in = new Scanner(System.in);
        caliber = in.nextDouble();
        if (caliber < 2.00 || caliber > 12.7) {
            throw new Exception("The caliber should be positive value, "
                    + "within the range of 2.00 mm and 12.7 mm!");
        }
    }
    
    public void shot() {
        if (getBullets() > 0) {
            if(caliber < 8.00) {
                System.out.println("P-TAFF!!!");
            } else {
                System.out.println("POOMB!!!");
            }
            currentLoad--;
        } else {
        System.out.println("No ammo!");    
        }
    }

    public String toString() {
        return "Handgun " + getName() + "\nStatus:" + getBullets() + 
                "/" + getCapacity() + "\nCaliber:" + caliber + " mm";
    }
    
    
}
