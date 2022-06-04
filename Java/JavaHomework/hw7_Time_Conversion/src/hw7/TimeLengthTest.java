/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7;

/**
 *
 * @author MarkPeng
 */
import java.util.Scanner;

/**
 *
 * @author MarkPeng
 */
public class TimeLengthTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeLength userTimeLength = new TimeLength();
        Scanner scanner = new Scanner(System.in);
        String input = new String();
        String time = new String();
        int type = 0;

        do {
            showMenu();
            input = scanner.next(); // get user input
            if (input.matches("[0-3]")) {
                try{      
                    switch (input) {
                        case "1": //set time
                            System.out.println("Please enter a time <seconds> or <hh:mm:ss>");
                            time = scanner.next();
                            type = TimeLength.whichType(time);
                            userTimeLength.setTimeLength(type, time);
                            break;
                        case "2": // adjust time
                            System.out.println("Please enter a time <seconds> or <hh:mm:ss>");
                            time = scanner.next();
                            type = TimeLength.whichType(time);
                            userTimeLength.adjustTimeLength(type, time);
                            break;
                        case "3": // show time
                            userTimeLength.showTime();
                            break;
                        case "0": // Exit
                            break;
                    }
                }catch(NumberFormatException ex){
                    System.out.println("The time out of range");
                }catch(Exception ex){
                    System.out.println("Some errors");
                }
            } else {
                System.out.println("Please enter a valid number.\n");
            }
        } while (!input.equals("0"));
    }

    /**
     * Show menu.1
     */
    public static void showMenu() {
        System.out.println("***Time Conversion***");
        System.out.println("1) Set a length of time.");
        System.out.println("2) Adjust length of time.");
        System.out.println("3) Show the length of time in different units.");
        System.out.println("0) Exit.");
        System.out.println();
        System.out.print("Please enter a number in [1,2,3,0]: ");
    }

}
