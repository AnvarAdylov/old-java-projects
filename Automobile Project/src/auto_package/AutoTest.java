/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_package;

/**
 *
 * @author Anvar Adylov
 */
import java.util.Scanner;
public class AutoTest {
    public static void main(String []args) {
        try {
        Automobile car1 = new Automobile();
        Automobile car2 = new Automobile();
     
        car1.startCar();
        car2.startCar();
        car1.pressGasPedal();
        car1.pressGasPedal();
        car2.pressGasPedal();   
     
        Scanner in = new Scanner(System.in);
        System.out.println("Write time:");
        double time;
        time = in.nextDouble();
        System.out.println(car1);
        car1.calculateDistance(time);
        System.out.println(car2);
        car1.pressBreak();
        car2.setAcceleration();
        car2.shutDown();
        System.out.println(car2);
        System.out.println(car1);
        car1.shutDown();   
        } catch (Exception ex) {
            System.out.println("I caught an Exception!");
            System.out.println(ex.getMessage());
        }
    }
}
