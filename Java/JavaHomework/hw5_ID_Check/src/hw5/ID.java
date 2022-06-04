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
public class ID {

    /**
    *   id : ID card number
    *   numberArray : The city value represented by the first letter
    *   cityArray : The city name represented by the firest letter.
    */
    
    String id;
    static int[] numberArray = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 32};    //A~Z
    static String[] cityArray = {
        //A~Z
        "Taipei City",  
        "Taichung City",
        "Keelung City",
        "Tainan City",
        "Kaohsiung City",
        "New Taipei City",
        "Yilan County",
        "Taoyuan City",
        "Chiayi City",
        "Hsinchu County",
        "Miaoli County",
        "Taichung County",
        "Nantou County",
        "Changhua County",
        "Hsinchu City",
        "Yunlin County",
        "Chiayi County",
        "Tainan County",
        "Kaohsiung County",
        "Pingtung County",
        "Hualien County",
        "Taitung County",
        "Kinmen County",
        "Penghu County",
        "Yangmingshan Management Bureau Taipei City",
        "Lienchiang County"
    };

    /**
     * Initializes a new instance of ID .
     *
     */
    public ID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the id card number:");
        this.id = scanner.nextLine();
    }
    
    /**
     *  Check ID is legal or not.
     */
    public void checkID(){
        if (this.id.matches("[A-Z][1-2][0-9]{8}$")) {
            int sum = 0;
            int c = numberArray[id.charAt(0) - 65];

            // Start caculating the special value
            sum += c / 10 % 10 * 1;
            sum += c % 10 * 9;
            for (int i = 1; i < 9; i++) {
                sum += Character.getNumericValue(id.charAt(i)) * (9 - i);
            }
            sum += Character.getNumericValue(id.charAt(9));
            // End of the caculating

            if (sum % 10 == 0) {
                System.out.printf("Wow!This is a %s friend born in %s!\n\n\n",id.charAt(1)=='1'?"male":"female",
                        cityArray[id.charAt(0) - 65]);
            } else {
                System.out.println("Validation error\n\n");
            }
        } else {
            System.out.println("Format error.\n\n");
        }
    }

}
