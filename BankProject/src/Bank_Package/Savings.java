/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_Package;

/**
 *
 * @author Anvar Adylov
 */
public class Savings extends AccountImpl {
    private int monthlyIR;
    
    public Savings(long n, int ir) {
        accountNumber = n;
        monthlyIR = ir;
        balance = 0;    
    }
    
    @Override
    public void monthlyAccrual() {
       int x = (int)(balance*monthlyIR/100.0); 
       balance = balance + x;
    }
    @Override
    public String toString() {
        return "Saving account:" + accountNumber + "\nCurrent balance:" + balance +
                "\nInterest rate is " + monthlyIR + " percent.";
    }
}
