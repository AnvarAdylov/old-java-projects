/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_package;

import java.util.Scanner;

/**
 *
 * @author Anvar Adylov
 */
public class Automobile {
    String licensePlateValue;
    boolean engineRunning;
    double acceleration;
    double speed;
    // Constructor
    /**Class that has four parameters: licensePlateValue, engineRunning and speed
     * The initial state of automobile engine is turned off.
     * And speed is 0. Then you should enter your acceleration, 
     * it is impossible to engine to acquire negative acceleration so all negative values will
     * cause an Exception message.
     *     
     * @param licensePlateValue allow user to distinguish cars
     */
    Automobile() throws Exception {
        System.out.println("Enter your license plate value: ");
        Scanner in = new Scanner(System.in);
        licensePlateValue = in.nextLine();
        engineRunning = false;
        System.out.println("Enter acceleration of the engine: ");
        acceleration = in.nextDouble();
        if (acceleration < 0) {
            throw new Exception("Engine cannot accelerate by negative value!");
        }
        speed = 0.0;
    }
    //Methods
    /**Turn the engine of the car on  
     * 
     */
    void startCar() {
        engineRunning = true;
    }
    /**Increase speed by the factor of acceleration parameter  
     * 
     */
    void pressGasPedal() {
        if (engineRunning) {
        speed = speed + acceleration;
        }
    }
    /**Slow down car to 0 speed 
     * 
     */
    void pressBreak() {
        speed = 0.0;
    }
    /**Turn the engine of the car off
     * 
     */
    void shutDown() {
        engineRunning = false;
    }
    /**Method which returns 1 if the engine is started.
     * 
     * @return 
     */
    boolean isEngineRunning() {
        return engineRunning;
    }
    /**Getter method for Speed  
     * 
     */
    double getSpeed() {
        return speed;
    }
    /**Getter method for acceleration value
     * 
     */
    double acceleration() {
        return acceleration;
    }
    /**
     * Changes the acceleration of the engine, given
     * that the argument has a value of positive double.
     * If the value of argument not within the allowed range, the original
     * value remains, and an exception is thrown.
     * 
     * @throws Exception if acceleration is negative
     */
    public void setAcceleration() throws Exception {
        double a; 
        System.out.println("Write new acceleration value:");
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        if (a < 0) {
            throw new Exception("Acceleration cannot be negative!");
        }
        this.acceleration = a;
    }
    /**The method which calculates distance, time should
     * always be the positive number, or an exception is thrown.
     * 
     * @param time 
     * @return The distance covered at the current speed over given time
     * @throws Exception if time given was negative
     */
    public void calculateDistance(double time) throws Exception {
        if (time < 0) {
            throw new Exception("Time cannot be negative!");
        }
        System.out.println("The distance covered by car \"" + licensePlateValue + "\":" + speed * time);
    } 
    /**The method which allow user to see all parameters in 
     * a user friendly form.
     * @return All parameters values
    */
    public String toString() {
        return "The car:" + licensePlateValue +
                "\nEngine running:" + engineRunning + 
                "\nSpeed:" + speed +
                "\nAcceleration:" + acceleration;
    }
}
