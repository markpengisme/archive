/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Scanner;

/**
 *
 * @author wahaha
 */
public class AccountTest {

    public static void main(String[] args) {
        
        //display
        Account account1 = new Account(50);
        Account account2 = new Account(-7);
        System.out.printf("account1 balance: $%.2f\n", account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n", account2.getBalance());

        //deposit
        Scanner input = new Scanner(System.in);
        double depositAmount;
        System.out.print("Enter deposit amount for account1: ");
        depositAmount = input.nextDouble();
        System.out.printf("\nAdding %.2f to account1 balance\n\n",depositAmount);
        account1.credit(depositAmount);
        
        //display
        System.out.printf("account1 balance: $%.2f\n", account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n", account2.getBalance());
        
        System.out.print("Enter deposit amount for account2: ");
        depositAmount = input.nextDouble();
        System.out.printf("\nAdding %.2f to account1 balance\n\n",depositAmount);
        account2.credit(depositAmount);
        
        //display
        System.out.printf("account1 balance: $%.2f\n", account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n", account2.getBalance());
        
    }

}
