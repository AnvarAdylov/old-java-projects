/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstjavaproject;

/**
 *
 * @author Габдул
 */
public class Clock {
    // Fields
    private int hours;
    private int minutes;
    private int seconds;
    
    // Constructor
    public Clock(int h, int m, int s) {
        hours = h;
        minutes = m;
        seconds = s;
    }
    // Methods
    public void resetToMidnight() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    
    public boolean isMorning() {
        return hours < 12;
    }
    
    public void tick() {
        seconds++;
        if (seconds>=60) {
            seconds = 0;
            minutes++;
            if (minutes>=60) {
                hours++;
                if (hours>=24) {
                    resetToMidnight();
                }
            }
        }
    }
}
