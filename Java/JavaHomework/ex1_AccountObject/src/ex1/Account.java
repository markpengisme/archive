/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author wahaha
 */
public class Account {
    
    private double balance;

    public Account(double balance) {
        if (balance > 0.0)
        {
            this.balance = balance;
        }
    }
    
    public void credit(double amount)
    {
        balance += amount;
    }
   
    public double getBalance()
    {
        return balance;
    }
    
}
