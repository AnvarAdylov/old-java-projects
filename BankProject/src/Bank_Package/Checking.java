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
public class Checking extends AccountImpl {
    private int nWithdrawals;
    
    public Checking(long n) {
        accountNumber = n;
        balance = 0;  
        nWithdrawals = 0;
    }
    
    @Override
    public void withdraw(int b) throws Exception {
        
            if(b>balance) {
               throw new Exception("You don't have enough balance to perform current operation!");
            } else {
               nWithdrawals++;   
                if (nWithdrawals>3) {
                    balance = (int)(balance - 101.0*b/100);
                } else {
                    balance = balance - b;
                }
        }
        
    }
    
    @Override
    public void monthlyAccrual() {
       nWithdrawals = 0;
    }
    @Override
    public String toString() {
        return "Checking account:" + accountNumber + "\nCurrent balance:" + balance;
    }
}
