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
public class testArms {
    public static void main(String[] args) {
        Firearm gun1 = new Firearm("Gun");
        gun1.shot();
        gun1.reload();
        gun1.shot();
        gun1.shot();
        System.out.println(gun1);
        
        // Checking polymorphism and shotgun subclass
        Firearm gun2 = new Shotgun("Two Barrels", true);
        gun2.reload();
        gun2.shot();
        // Dynamic dispatch
        System.out.println(gun2);
        gun2.shot();
        gun2.shot();
        
        // Rifle subclass test
        Rifle sniperRifle = new Rifle("Vintorez",true,true);
        System.out.println(sniperRifle);
        sniperRifle.switchSafety();
        // Here we can see example of inheritance, rifle uses 
        // reload method defined for all firearms. 
        sniperRifle.reload();
        sniperRifle.shot();
        sniperRifle.reload();
        sniperRifle.putOrRemoveSilencer();
        sniperRifle.shot();
        sniperRifle.switchSafety();
        sniperRifle.shot();
        System.out.println(sniperRifle);
        
        // Handgun subclass testing
        try {
            Handgun beretta = new Handgun("Beretta");
            System.out.println(beretta);
            beretta.reload();
            beretta.shot();
            System.out.println(beretta);
        } catch(Exception en) {
            System.out.println("I caught an exception!");
            System.out.println(en);
        }
        
        // Carbine testing
        Carbine AK = new Carbine("Kalashnikov");
        AK.reload();
        AK.switchSemiautomatic();
        AK.shot();
        System.out.println(AK);
        AK.switchAutomatic();
        System.out.println(AK);
        AK.shot();
        AK.switchSingle();
        System.out.println(AK);
        AK.reload();
        AK.shot();
    }
}
