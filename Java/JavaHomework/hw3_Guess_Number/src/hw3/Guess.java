/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.Scanner;

/**
 *
 * @author MarkPeng
 */
public class Guess {

    /**
     *  
     * min : lower limit
     * max : higher limit
     * times : user can guess times
     * count : user has guessed times
     * answer : guess answer
     * guessHistory[] : user has guessed number
     */
    private int min;
    private int max;
    private int times;
    private int count;
    private final int answer;
    private final int guessHistory[];

    /**
     *  Initialization parameters
     */
    public Guess() {
        do{
            System.out.println("***** Guess Number *****");
            System.out.println("Input the min number:");
            min = checkInputisInt();
            System.out.println("Input the max number:");
            max = checkInputisInt();
            System.out.println("Input the guess times limit:");
            times = checkInputisInt();
            if (min>max){System.out.println("Error : Min > Max");}
        }while(min < 0 || max < 0 || times < 0 ||  min > max);
        answer = (int) (Math.random() * (max - min + 1) + min);
        guessHistory = new int[times];
//[TEST]display answer        System.out.printf("Answer:%d",answer);
    }

    /**
     *  Start the game
     */
    public void gameStart() {
        System.out.println("***** Game Start *****");
        count = 0;
        boolean flag = false;
        while (count < times && flag == false) {
            System.out.printf("Number range: %d ~ %d\n", min, max);
            System.out.print("Input the guess number:");
            int guess = checkInputisInt();
            guessHistory[count] = guess;
            flag = guessLogic(guess);
            count++;
        }
    }

    /**
     *
     * @param guess guess number
     * @return Guess it or not
     */
    public boolean guessLogic(int guess) {
        if (guess == answer) {
            System.out.println("Congratulations! You guess right");
            return true;
        } else if (guess >= max) {
            System.out.println("You guess wrong. "
                    + "Your guess number is greater than or equal to upper limit");
        } else if (guess <= min) {
            System.out.println("You guess wrong. "
                    + "Your guess number is smaller than or equal to lower limit");
        } else if (guess > min && guess < max && guess < answer) {
            System.out.println("You guess wrong. "
                    + "Your guess number is smaller than answer");
            min = guess;
        } else if (guess > min && guess < max && guess > answer) {
            System.out.println("You guess wrong. "
                    + "Your guess number is greater than answer");
            max = guess;
        } else {
        }
        return false;
    }

    /**
     *  Display game stats
     */
    public void gameEnd() {
        System.out.println("***** Game Over *****");
        for (int i = 0; i < count; i++) {
            if(guessHistory[i] != -1)
                System.out.printf("No.%d guess : %d \n", i + 1, guessHistory[i]);
            else
                System.out.printf("No.%d guess : illegal \n",i+1);
        }
        System.out.println("---");
        System.out.printf("Guess times limit : %d \n", times);
        System.out.printf("Your Guess times : %d \n", count);
        System.out.printf("Answer : %d \n", answer);
    }

    /**
     *
     * @return legal nonnegative integer, if not return -1
     */
    public static int checkInputisInt() {
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.next();

        if (!input.matches("[0-9]+")) {
            System.out.println("Please input nonnegative integer!");
            return -1;
        }
        return Integer.parseInt(input);
    }

}
