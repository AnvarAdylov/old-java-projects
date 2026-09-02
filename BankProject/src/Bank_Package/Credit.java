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
public class Credit extends AccountImpl {
    private int debtLimit; 
    public Credit(long n, int debt) {
        accountNumber = n;
        balance = 0;   
        debtLimit = debt;
    }
    @Override
    public void withdraw(int b) throws Exception {
        if(balance - b <= -debtLimit) {
            balance = balance - b;
            throw new Exception("Your balance gone below the debt limit!");
        } else {
        balance = balance - b;
        }
    }
    @Override
    public void monthlyAccrual() {
        if (balance<0) {
            int x = balance/10;
            balance = balance + x;
        }
    }
    @Override
    public String toString() {
        return "Credit account:" + accountNumber + "\nCurrent balance:" + balance + "\nThe debt limit:" + debtLimit;
    }
}
