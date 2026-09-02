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
public class AccountImpl implements Account {
    protected long accountNumber;
    protected int balance;
    
    public AccountImpl() {
        balance = 0;    
    }
    
    @Override
    public void deposit(int a) {
        balance = balance + a;
    }

    @Override
    public void withdraw(int b) throws Exception {
        if(b>balance) {
            throw new Exception("You don't have enough balance to perform current operation!");
        } else {
            balance = balance - b;
        }
    }

    

    @Override
    public long getAccNumber() {
        return accountNumber;
    }

    @Override
    public void monthlyAccrual() {
    }
    
}
