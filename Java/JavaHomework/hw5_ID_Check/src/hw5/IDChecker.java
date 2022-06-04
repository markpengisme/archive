/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

/**
 *
 * @author MarkPeng
 */
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author MarkPeng
 */
public class IDChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ID id;
        while (true) {
            System.out.println("********************");
            System.out.println("1.  Verify ID card number.");
            System.out.println("0.  Exit.");
            System.out.println("********************");
            System.out.print("Please select:");
            String choose = scanner.nextLine();
            System.out.println("");
            if (choose.equals("0")) {
                break;
            } else if (choose.equals("1")) {
                id = new ID();
                id.checkID();
            } else {
                System.out.println("Select error\n\n");
            }
        }
    }

}
