/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.util.Scanner;
/**
 *
 * @author MarkPeng
 */
public class TimeToolTest {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String input;
        Scanner scanner = new Scanner(System.in);
        
        do{
            System.out.println("Main Menu");
            System.out.println("1.Show current Time");
            System.out.println("2.Leap Year");
            System.out.println("0.Exit");
            System.out.println("");
            System.out.println("Please enter a number 0~2");
            
            input = scanner.next();
            int num = Integer.parseInt(input);
            
            switch(num){
                case 1:
                    TimeTool.showCurrentTime();
                    break;
                case 2:
                    System.out.println("Please enter the number of year\n");
                    int year = scanner.nextInt();
                    
                    if (TimeTool.isLeapYear(year)){
                        System.out.println(year + " is a leap year\n");
                    }
                    else{
                        System.out.println(year + " is  not a leap year\n");
                    }
            }
        }while(!input.equals("0"));
    }
}
