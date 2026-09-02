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
public class Carbine extends Firearm {
    private Boolean automatic;
    private Boolean semiautomatic;
    private Boolean single;
    /**The carbine type constructor
     * it has magazine for 30 bullets 
     * and originally set to the single fire mode.
     * 
     * @param n 
     */
    public Carbine(String n) {
        super(n);
        maxLoad = 30;
        
        single = true;
        automatic = false;
        semiautomatic = false;
    }
    /**Sets mode where you will shot one bullet at a time.
     * 
     */
    public void switchSingle() {
        single = true;
        automatic = false;
        semiautomatic = false;
    }
    /**Sets mode where you will shot several bullets at a time.
     * 
     */
    public void switchSemiautomatic() {
        single = false;
        automatic = false;
        semiautomatic = true;
    }
    /**Sets mode where you will shot all magazine.
     * 
     */
    public void switchAutomatic() {
        single = false;
        automatic = true;
        semiautomatic = false;
    }
    
    
     public void shot() {
        if (getBullets() > 0) {
          if (single || getBullets() == 1) {
              System.out.println("TAFF!!!");
              currentLoad--;
          } else if (semiautomatic) {
              System.out.println("BRATATAT!!!");
              if (currentLoad > 5) {
              currentLoad = currentLoad - 4;
              } else {
              currentLoad = 0;
              }
          } else {
              System.out.println("RATATATATATATATATATATATATATATATATATA!!!"); 
              currentLoad = 0;
          }
        } else {
        System.out.println("No ammo!");    
        }
    }
     
    public String toString() {
        if (single) {
        return "Carbine " + getName() + "\nStatus:" + getBullets() + "/" + getCapacity() 
                + "\nCurrently in the singular fire mode.";
        } else if (automatic) {
        return "Carbine " + getName() + "\nStatus:" + getBullets() + "/" + getCapacity() 
                + "\nCurrently in the automatic fire mode.";    
        } else {
        return "Carbine " + getName() + "\nStatus:" + getBullets() + "/" + getCapacity() 
                + "\nCurrently in the semi-automatic fire mode.";    
        }
    }
}
