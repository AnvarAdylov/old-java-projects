/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock_Package;

import java.util.Scanner;

/**
 *
 * @author Anvar Adylov
 */
public class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    
    // Constructor
    public Clock(int h, int m, int s) {
        hours = h;
        minutes = m;
        seconds = s;
        if (hours > 24 || hours < 0 ||minutes > 60 || minutes < 0 || seconds > 60 || seconds < 0) {
            resetToMidnight();
        }
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
                minutes = 0;
                hours++;
                if (hours>=24) {
                    resetToMidnight();
                }
            }
        }
    }

    
    public String toString() {
        if (hours < 10) {
            if (minutes < 10) {
                if (seconds < 10) {
                return "0" + hours + ":0" + minutes + ":0" + seconds;
                }
            return "0" + hours + ":0" + minutes + ":" + seconds;
            }
            return "0" + hours + ":" + minutes + ":" + seconds;
        } else if (minutes < 10) {
                if (seconds < 10) {
                return hours + ":0" + minutes + ":0" + seconds;
                }
             return hours + ":0" + minutes + ":" + seconds;
        } else if (seconds < 10) {
             return hours + ":" + minutes + ":0" + seconds;
        } else {
        return hours + ":" + minutes + ":" + seconds;
        }
    } 
    
    void setClock(int h, int m, int s) {
        if (h < 24 || h >= 0) {
            hours = h;
        }
        
        if (m < 60 || m >= 0) {
            minutes = m;
        }
        
        if (s < 60 || s >= 0) {
            seconds = s;
        }
    }
    int getHours() {
        return hours;
    }
    int getMinutes() {
        return minutes;
    }
    int getSeconds() {
        return seconds;
    }
}
