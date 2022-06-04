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
public class TimeLength {

    private static final int HOUR_TO_SECONDS = 3600;
    private static final int HOUR_TO_MINTUES = 60;
    private static final int MINUTE_TO_SECONDS = 60;
    private int seconds;

    /**
     * Constructor and set default time is 0;
     */
    public TimeLength() {
        this.seconds = 0;
    }

    /**
     * Recognize user input is (+/-)second or (+/-)hh:mm:ss
     * @param s
     * @return
     */
    public static int whichType(String s) {
        if (s.matches("[+]?\\d+")) {
            return 1; // postive seconds
        } else if (s.matches("-\\d+")) {
            return 2; // negative_seconds
        } else if (s.matches("[+]?\\d{2,}:[0-5][0-9]:[0-5][0-9]")) {
            return 3;// postive hh:mm:ss
        } else if (s.matches("-\\d{2,}:[0-5][0-9]:[0-5][0-9]")) {
            return 4;// negative hh:mm:ss
        }else{
            return -1; // error"
        }
    }

    /**
     * Use (+/-)seconds to set the time
     * @param sec
     */
    public void setTime(int sec) {
        seconds = sec;
    }

    /**
     * Use (+/-)hh:mm:ss to set the time
     * @param hr
     * @param min
     * @param sec
     */
    public void setTime(int hr, int min, int sec) {
        seconds = hr * HOUR_TO_SECONDS + min * MINUTE_TO_SECONDS + sec;
    }

    /**
     * combine whichType() and setTime()
     * @param type
     * @param s
     */
    public void setTimeLength(int type, String s) {

        if (type == 1 || type == 2) {
            setTime(Integer.parseInt(s));
        } else if (type == 3) {
            String[] units = s.split(":");
            int hr = Integer.parseInt(units[0]);
            int min = Integer.parseInt(units[1]);
            int sec = Integer.parseInt(units[2]);
            setTime(hr, min, sec);
        } else if (type == 4) {
            s = s.substring(1);
            String[] units = s.split(":");
            int hr = Integer.parseInt(units[0]);
            int min = Integer.parseInt(units[1]);
            int sec = Integer.parseInt(units[2]);
            setTime(hr, min, sec);
            seconds *= -1;
        } else {
            System.out.println("input error");
        }

    }

    /**
     * Use (+/-)seconds to adjust the time
     * @param sec
     */
    public void adjustTime(int sec) {
        seconds += sec;
    }

    /**
     * Use (+/-)hh:mm:ss to adjust the time
     * @param hr
     * @param min
     * @param sec
     */
    public void adjustTime(int hr, int min, int sec) {
        seconds += (hr * HOUR_TO_SECONDS + min * MINUTE_TO_SECONDS + sec);
    }

    /**
     * Combine whichType() and adjustTime()
     * @param type
     * @param s
     */
    public void adjustTimeLength(int type, String s) {
        if (type == 1 || type == 2) {
            adjustTime(Integer.parseInt(s));
        } else if (type == 3) {
            String[] units = s.split(":");
            int hr = Integer.parseInt(units[0]);
            int min = Integer.parseInt(units[1]);
            int sec = Integer.parseInt(units[2]);
            adjustTime(hr, min, sec);
        } else if (type == 4) {
            s = s.substring(1);
            String[] units = s.split(":");
            int hr = -1 * Integer.parseInt(units[0]);
            int min = -1 * Integer.parseInt(units[1]);
            int sec = -1 * Integer.parseInt(units[2]);
            adjustTime(hr, min, sec);
        } else {
            System.out.println("input error");
        }
    }

    /**
     * Display the time in two formats.
     */
    public void showTime() {

        System.out.printf("The current length of time <seconds> : %d\n", seconds);
        if (seconds >= 0) {
            int hr = seconds / HOUR_TO_SECONDS;
            int min = (seconds / MINUTE_TO_SECONDS) % HOUR_TO_MINTUES;
            int sec = seconds % MINUTE_TO_SECONDS;
            System.out.printf("The current length of time <hh:mm:ss> : %02d:%02d:%02d\n\n", hr, min, sec);
        } else {
            int temp_seconds = -1 * seconds;
            int hr = temp_seconds / HOUR_TO_SECONDS;
            int min = (temp_seconds / MINUTE_TO_SECONDS) % HOUR_TO_MINTUES;
            int sec = temp_seconds % MINUTE_TO_SECONDS;
            System.out.printf("The current length of time <hh:mm:ss> : -%02d:%02d:%02d\n\n", hr, min, sec);
        }
    }
}
