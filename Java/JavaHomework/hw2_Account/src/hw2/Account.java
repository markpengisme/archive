/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.Scanner;

/**
 * Account class with open an account,deposit money,withdraw money,show balance
 * @author MarkPeng
 */
public class Account {

    /**
     *  
     * balance : Account balance
     * flag : Whether have an account
     * input : User input
     * scanner : Scanner object
     */
    private int balance;
    private boolean flag;
    String input;
    Scanner scanner = new Scanner(System.in);

    /**
     *
     * @return Account balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     *
     * @param balance 
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     *
     * @return Whether have an account or not, if have it, return true 
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     *
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * This method is used to open an account. 
     */
    public void openAccount() {
        if (this.getFlag() == true) 
            System.out.println("Already open the account!\n");
        else 
        {
            System.out.println("Please enter the opening deposit: ");
            input = scanner.next();

            if (!input.matches("-*[0-9]+")) {
                System.out.println("Please input integer!\n");
            } else if (Integer.parseInt(input) <= 0) {
                System.out.println("Please enter a number greater than 0!\n");
            } else if (Integer.parseInt(input) < 1000) {
                System.out.println("Not enough to open an account, must be greater than $1000!\n");
            } else {
                setFlag(true);
                setBalance(this.getBalance()+Integer.parseInt(input));
                System.out.print("Successful opening an account, ");
                System.out.printf("Deposit $%s\n\n", input);
                
            }
        }

    }

    /**
     * This method is used to deposit money.
     */
    public void deposit() {
        if (this.getFlag() == false) 
            System.out.println("Not open the account yet!\n");
        else 
        {
            System.out.println("Please enter the deposit money: ");
            input = scanner.next();

            if (!input.matches("-*[0-9]+")) {
                System.out.println("Please input integer!\n");
            } else if (Integer.parseInt(input) <= 0) {
                System.out.println("Please enter a number greater than 0!\n");
            } else {
                setBalance(this.getBalance()+Integer.parseInt(input));
                System.out.printf("Deposit $%s successfully.\n\n", input);
            }
        }
    }

    /**
     * This method is used to withdraw money.
     */
    public void withdraw() {
        if (this.getFlag() == false) 
            System.out.println("Not open the account yet!\n");
        else 
        {
            System.out.println("Please enter the withdraw money: ");
            input = scanner.next();

            if (!input.matches("-*[0-9]+")) {
                System.out.println("Please input integer!\n");
            } else if (Integer.parseInt(input) <= 0) {
                System.out.println("Please enter a number greater than 0!\n");
            } else if (Integer.parseInt(input) > this.getBalance()){
                System.out.printf("Withdraw unsuccessfully.You don't have enough money\n\n", input);
            } else{
                setBalance(this.getBalance()-Integer.parseInt(input));
                System.out.printf("Deposit $%s successfully.\n\n", input);
            }
        }
    }
    
    /**
     * This method is used to show account balance.
     */
    public void showBalance(){
        if (this.getFlag() == false) 
            System.out.println("Not open the account yet!\n");
        else 
            System.out.printf("Account balance:$%d\n\n",this.getBalance());
    }
}
