/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;
import java.util.Scanner;
/**
 *
 * Testing Account object
 * @author MarkPeng
 */
public class AccountTest {
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        /**
        *
        * input : User input
        * scanner : Scanner object
        * account : Account object
        */
        String input;
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        
        
        /**
        *
        * Four function,and exit.
        */
        do{
            System.out.println("***Main Menu***");
            System.out.println("1) Open an account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdrawal");
            System.out.println("4) Balance");
            System.out.println("0) Exit");
            System.out.println("Please enter a number [0,1,2,3,4]");
            
            input = scanner.next();
            
            switch(input){
                case "0":
                    break;
                case "1":
                    account.openAccount();
                    break;
                case "2":
                    account.deposit();
                    break;
                case "3":
                    account.withdraw();
                    break;
                case "4":
                   account.showBalance();
                    break;
                default:
                    System.out.println("input error\n");
                    break;
            }
        }while(!input.equals("0"));
    }
    
}
