/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

import java.util.*;

/**
 *
 * @author MarkPeng
 */

public class CaesarTest {

    // main
    public static void main(String[] args) {

        // Declare var
        String plainText;
        int key;
        
        // Make Caesar and Scanner object
        Caesar caesar = new Caesar();
        Scanner input = new Scanner(System.in);
        
        // Input plaintext and offset,and encrypt plaintext
        System.out.println("Enter:plainText");
        plainText = input.next();
        caesar.setPlainText(plainText);
        System.out.println("Enter:key");
        key = Integer.parseInt(input.next());
        caesar.setKey(key);
        caesar.generateCypher(plainText, key);
        
        // Display Caesar object
        caesar.displayCypher();
    }
}
