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
public class Bank {
    private Account[] customers = new Account[10];
    private int size;
    public Bank() {
        size = 0;
    }
    
    public void newSaving(long n, int ir) throws Exception {
        Boolean dub = true;
        for (int i = 0;i<size;i++) {
            if (customers[i].getAccNumber() == n) {
                dub = false;
            }
        }
        if (dub) {
        if (n<0) {
            throw new Exception("Account number cannot be negative!");
        }
        customers[size] = new Savings(n,ir);
        size++;
        } else {
            throw new Exception("Such account already exist!");
        }
    }
    public void newChecking(long n) throws Exception {
        Boolean dub = true;
        for (int i = 0;i<size;i++) {
            if (customers[i].getAccNumber() == n) {
                dub = false;
            }
        }
        if (dub) {
        if (n<0) {
            throw new Exception("Account number cannot be negative!");
        }
        customers[size] = new Checking(n);
        size++;
        } else {
            throw new Exception("Such account already exist!");
        }
    }
    public void newCredit(long n,int d) throws Exception {
        Boolean dub = true;
        for (int i = 0;i<size;i++) {
            if (customers[i].getAccNumber() == n) {
                dub = false;
            }
        }
        if (dub) {
        if (n<0) {
            throw new Exception("Account number cannot be negative!");
        }
        customers[size] = new Credit(n, d);
        size++;
        } else {
            throw new Exception("Such account already exist!");
        }
    }
    public void depositM(long x, int m) throws Exception {
        if (m<0) {
            throw new Exception("Y cannot deposit negative value!");
        } else {
        Boolean f = false;
        for (int i = 0;i<size;i++) {
            if (customers[i].getAccNumber() == x) {
                    customers[i].deposit(m);
                    f = true;
            }
        }
        if (f=false) {
            throw new Exception("No such account!");
        }
        }
    }
    public void withdrawM(long x, int m) throws Exception {
        if (m<0) {
            throw new Exception("Y cannot withdraw negative value!");
        } else {
        Boolean f = false;
        for (int i = 0;i<size;i++) {
            if (customers[i].getAccNumber() == x) {
                    try {
                        customers[i].withdraw(m);
                    } catch(Exception ex) {
                        System.out.println("I caught an exception!");
                        System.out.println(ex);
                    }
                    f = true;
            }
        }
        
        if (f=false) {
            throw new Exception("No such account!");
        }
        }
    }
    public void monthlyAccrualAll() {
        for (int i=0;i<size;i++) {
        customers[i].monthlyAccrual(); 
        }
    }
    public String toString() {
        String stack;
        stack = "";
        for (int i = 0;i<size;i++) {
            stack = stack + "\n" + customers[i];
        }
        return stack;
    }
}
