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
public class GradeBook {
    
    private double grade[];

    public GradeBook(int num) {
       grade = new double[num];
       for(int i = 0; i < grade.length; i++){
           grade[i] = 0;
       }
    }
    
    public void setGrade(){
        Scanner input = new Scanner(System.in);
        System.out.println("Plz input"+ grade.length + " student's grade");
        for (int i = 0; i < grade.length; i++){
            System.out.print("No" + (i+1) + ":");
            grade[i] = input.nextDouble();
        }
    }
    
    public void showGrade(){
        for (int i = 0; i < grade.length; i++){
            System.out.printf("No%d:%.2f\n", i+1, grade[i]);
        }
        System.out.println("");
    }
    
    public double getMean(){
        double average=0;
        for (int i = 0; i < grade.length; i++){
            average += grade[i];
        }
        average /= grade.length;
        return average;
    }
    
    public double getMax(){
        double max = Double.MIN_VALUE;
        for (int i = 0; i < grade.length; i++){
            if (grade[i] >= max){
                max = grade[i];
            }
        }
        return max;
    }
    
    public int getPassCount(){
        int count = 0;
        for (int i = 0; i < grade.length; i++){
            if (grade[i] >= 60){
                count++;
            }
        }
        return count;
    }
        
    
}
