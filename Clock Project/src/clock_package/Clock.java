/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock_package;

/**
 *
  * @author Anvar Adylov
 */
public class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    
    // Constructor
    /**
     * Class that has three parameters: hours, minutes and time
     * used to represent time in a way electric watches do.
     * You can set the initial time yourself or leave parenthesis hollow
     * it will automatically set time to midnight.
     * If you will enter values of the incorrect range to the field an 
     * Exception will be thrown.
     * 
     * @param h hours parameter 
     * @param m minutes parameter
     * @param s seconds parameter
     * @throws Exception if values are not within the correct ranges.
     */
    public Clock(int h, int m, int s) throws Exception {
        hours = h;
        minutes = m;
        seconds = s;
        if (hours > 23 || hours < 0) {
            throw new Exception("Hourss is not in range!");
        }
        if (minutes > 59 || minutes < 0) {
            throw new Exception("Minutes is not in range!");
        }
        if (seconds > 59 || seconds < 0) {
            throw new Exception("Seconds is not in range!");
        }
    }
    public Clock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    // Methods
    /** This method allow to set time to 00:00:00 or midnight.
     * 
     */
    public void resetToMidnight() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    /**This method returns 1 if there is morning.
     * 
     * @return 
     */
    public boolean isMorning() {
        return this.hours < 12;
    }
    /**This method simulating work process in the clock allowing you
     * realistically make your clock going.
     * 
     */
    public void tick() {
        this.seconds++;
        if (this.seconds>=60) {
            this.seconds = 0;
            this.minutes++;
            if (this.minutes>=60) {
                this.minutes = 0;
                this.hours++;
                if (this.hours>=24) {
                    resetToMidnight();
                }
            }
        }
    }

    /**Method which is responsible for the standard ??:??:?? output
     * 
     * @return time in a form of ??:??:??
     */
    public String toString() {
        if (this.hours < 10) {
            if (this.minutes < 10) {
                if (this.seconds < 10) {
                return "0" + this.hours + ":0" + this.minutes + ":0" + this.seconds;
                }
            return "0" + this.hours + ":0" + this.minutes + ":" + this.seconds;
            }
            return "0" + this.hours + ":" + this.minutes + ":" + this.seconds;
        } else if (this.minutes < 10) {
                if (this.seconds < 10) {
                return this.hours + ":0" + this.minutes + ":0" + this.seconds;
                }
             return this.hours + ":0" + this.minutes + ":" + this.seconds;
        } else if (this.seconds < 10) {
             return this.hours + ":" + this.minutes + ":0" + this.seconds;
        } else {
        return this.hours + ":" + this.minutes + ":" + this.seconds;
        }
    } 

    /**Getter allowing to get separate value of hours fields
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Changes the hours field to the parameter argument, given
     * that the argument has a value of integer between 0 to 23 inclusive. 
     *  If the value of argument not within the allowed range, field will remain
     * unchanged, and an exception is thrown.
     *
     * @param hours the hours to set
     * @throws Exception if hours is not in range
     */
    public void setHours(int hours) throws Exception {
        if (hours > 23 || hours < 0) {
            throw new Exception("Hourss is not in range!");
        }
        this.hours = hours;
    }

    /**Getter allowing to get separate value of minutes fields
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Changes the minutes field to the parameter argument, given
     * that the argument has a value of integer between 0 to 59 inclusive.
     *  If the value of argument not within the allowed range, field will remain
     * unchanged, and an exception is thrown.
     * 
     * @param minutes the minutes to set
     * @throws Exception if minutes is not in range
     */
    public void setMinutes(int minutes) throws Exception {
        if (minutes > 59 || minutes < 0) {
            throw new Exception("Minutes is not in range!");
        }
        this.minutes = minutes;
    }

    /**Getter allowing to get separate value of seconds fields
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Changes the seconds field to the parameter argument, given
     * that the argument has a value of integer between 0 to 59 inclusive.
     *  If the value of argument not within the allowed range, field will remain
     * unchanged, and an exception is thrown.
     * 
     * @param seconds the seconds to set
     * @throws Exception if seconds is not in range
     */
    public void setSeconds(int seconds) throws Exception {
        if (seconds > 59 || seconds < 0) {
            throw new Exception("Seconds is not in range!");
        }
        this.seconds = seconds;
    }
}