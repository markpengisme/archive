/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.util.Date;
/**
 *
 * @author MarkPeng
 */
public class TimeTool {

    public static void showCurrentTime(){
        Date now = new Date();
        System.out.println(now);
    }
    
    public  static  boolean isLeapYear(int year){
        
        boolean isLeapYear = false;
        
        if ((year%4 == 0) && (year%100 != 0) || year%400==0){
            isLeapYear =true;
        }
        return isLeapYear;
    }
}
