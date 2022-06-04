/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw10;

/**
 *
 * @author MarkPeng
 */
import java.util.Scanner;

public class AlarmClock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         System.out.println(java.time.LocalDateTime.now()); 
         setTime();
    }
    public static void setTime() 
    {
        while(true)
        {
            try
            {

                Time time =new Time();
                Scanner scanner = new Scanner(System.in);
                String input;
                
                System.out.println("Please set the alarm time(HH:mm:ss)");
                input = scanner.next();
                
                if(!input.matches("\\d{2}:\\d{2}:\\d{2}"))
                    throw new TimeFormatException("format error");
                
                time.setHr(Integer.parseInt(input.substring(0,2)));
                time.setMin(Integer.parseInt(input.substring(3,5)));
                time.setSec(Integer.parseInt(input.substring(6,8)));
                time.buildTime();
                time.showTime();
                break;

            }catch(TimeFormatException e){
                System.out.println("TimeFormatException: "+e.getMessage());
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
}
