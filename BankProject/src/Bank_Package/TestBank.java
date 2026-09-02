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
public class TestBank {
    public static void main(String[] args) {
        Bank nationalBank = new Bank();
        try {
        nationalBank.newSaving(10001, 10);
        System.out.println(nationalBank);
        nationalBank.newCredit(10002, 5000);
        nationalBank.newChecking(10003);
        nationalBank.newChecking(10001);
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
        System.out.println(nationalBank);
        try {
        nationalBank.depositM(10001, 5000);
        nationalBank.depositM(10003, 5000);
        nationalBank.withdrawM(10002, 5000);
        nationalBank.withdrawM(10003, 1000);
        nationalBank.withdrawM(10003, 1000);
        nationalBank.withdrawM(10003, 1000);
        nationalBank.withdrawM(10003, 1000);
        nationalBank.withdrawM(10003, 1000);
        System.out.println(nationalBank);
        nationalBank.monthlyAccrualAll();
        System.out.println(nationalBank);
        nationalBank.monthlyAccrualAll();
        System.out.println(nationalBank);
        } catch(Exception ex) {
        System.out.println("I caught an exception!");
        System.out.println(ex);
        }
       
        
    }
}
