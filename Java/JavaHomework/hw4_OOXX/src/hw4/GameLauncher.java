/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

/**
 *
 * @author MarkPeng
 */
import java.util.Scanner;
public class GameLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe board = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("********* Game Start *********");
        do {
            // check input (x,y) is legal, if not, then retry 
            System.out.printf("Player-%c,enter you move (row[1,3],col[1-3]):",
                    board.whichPlayer() ? board.NOUGHT:board.CROSS);
            String input = scanner.next();
            if (!input.matches("[1-3]{1},[1-3]{1}") || 
                    board.getBoard(Character.getNumericValue(input.charAt(0)),Character.getNumericValue(input.charAt(2))) != ' ') {
                System.out.println("The value you entered is invalid!Please try again");
                continue;
            }
            
            // Input "O" or "X" in(x,y)
            // Until the end,ask the user if they want to play again.
            board.inputBoard(Character.getNumericValue(input.charAt(0)),Character.getNumericValue(input.charAt(2)));
            if (board.isEnd())
            {
                System.out.print("Play Again (Y/N):");
                input = scanner.next();
                if(input.equals("Y") || input.equals("y")){
                    board.resetBoard();
                    System.out.println("********* Game Start *********");
                }else{
                    // Not 'y' or 'Y' is judged as N meanig not to play again.
                    break;
                }
            }
        } while (true);
    }
}
