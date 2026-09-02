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
public interface Account {
    /**Getter for Account number field
     * 
     * @return Account number
     */
    public long getAccNumber();
    /**Setter for Account number field
     * 
     * @param a value you want to deposit
     */
    public void deposit(int a);
    /**Take money from balance
     * @throws Exception if not enough money on a balance, 
     * excepting Credits account because of allowed negative balance.
     * @param b amount you want to withdraw
     */
    public void withdraw(int b) throws Exception;
    /**Monthly increases balance by some percentage.
     * 
     */
    public void monthlyAccrual();
}
