/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;
import java.util.Scanner;
/**
 *
 * @author MarkPeng
 */
public class GradeBookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("How many people are there:");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        
        GradeBook gb = new GradeBook(num);
        gb.setGrade();
        System.out.println("*************");
        gb.showGrade();
        System.out.println("平均:"+gb.getMean());
        System.out.println("最大:"+gb.getMax());
        System.out.println("及格:"+gb.getPassCount());
    }
    
}
