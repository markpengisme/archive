/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

/**
 *
 * @author MarkPeng
 */
public class IDChecker {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ID id = new ID();
        String str = id.readFile("input.txt");
        id.writeFile("correct.txt","error.txt", str);
    }

}
