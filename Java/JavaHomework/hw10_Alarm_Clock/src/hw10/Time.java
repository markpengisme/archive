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
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Month;
public class Time {
    private int hr;
    private int min;
    private int sec;
    private LocalDateTime time;

    public void setHr(int hr) throws TimeFormatException{
        if(hr<0 || hr>24)
            throw new TimeFormatException("hour setting error");
        this.hr = hr;
    }

    public void setMin(int min) throws TimeFormatException{
        if(min<0 || min>60)
            throw new TimeFormatException("minute setting error");
        this.min = min;
    }

    public void setSec(int sec)  throws TimeFormatException{
        if(sec<0||sec>60)
            throw new TimeFormatException("second setting error");
        this.sec = sec;
    }
    public void buildTime(){
        time=LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),hr,min,sec);
        if(time.compareTo(LocalDateTime.now())<0)
            time=time.plusDays(1);
        
        
    }
    public void showTime(){
        Duration d1 = Duration.between(LocalDateTime.now(),time);
        System.out.printf("The alarm has been set to after %d hours and %d minutes.",d1.getSeconds()/3600,d1.getSeconds()/60%60);

    }
    
    
}
