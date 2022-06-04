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
public class TicTacToe {
    
    
    /**
     *  
     * board : A Two-dimensional array of characters
     * count : Total input times
     * player : Who is the player, O or X
     * NOUGHT : char'O'
     * CROSS : char'X
     * end : check game is over or not.
     */
    private char[][] board= {{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '}};
    private int count=0;
    private boolean player = false; // true=O-play, false=X-play
    public static final char NOUGHT='O';
    public static final char CROSS='X';
    private boolean end = false;

    /**
     *
     * @param x row
     * @param y col
     * @return
     */
    public char getBoard(int x,int y) {
        return board[x][y];
    }

    /**
     *
     * @return player
     */
    public boolean whichPlayer() {
        return player;
    }

    /**
     *
     * @return Is end or not.
     */
    public boolean isEnd() {
        return end;
    }
    
    /**
     *
     * @param row
     * @param col
     * Input the 'X' or 'O' to the board(row,col)
     */
    public void inputBoard(int row, int col){
        count++;
        if(player==true){
            board[row][col]=NOUGHT;
            showBoard();
            checkBoard(NOUGHT);
        }else{
            board[row][col]=CROSS;
            showBoard();
            checkBoard(CROSS);
        }
        player =!player;
    }

    /**
     *  
     * @param input
     * Check if the game is over.
     */
    public void checkBoard(char input){
        if( (board[1][1]==input && board[1][2]==input && board[1][3]==input)||
            (board[2][1]==input && board[2][2]==input && board[2][3]==input)||
            (board[3][1]==input && board[3][2]==input && board[3][3]==input)||
            (board[1][1]==input && board[2][1]==input && board[3][1]==input)||
            (board[1][2]==input && board[2][2]==input && board[3][2]==input)||
            (board[1][3]==input && board[2][3]==input && board[3][3]==input)||
            (board[1][1]==input && board[2][2]==input && board[3][3]==input)||
            (board[1][3]==input && board[2][2]==input && board[3][1]==input)){
            end = true;
            System.out.printf("Player-%c is the winner!",whichPlayer() ? NOUGHT:CROSS);
        }else if(count==9){
            System.out.println("It's a draw");
            end = true;
        }
    }

    /**
     *  Show the current board-looking.
     */
    public void showBoard(){
        System.out.printf(" %c | %c | %c \n",board[1][1],board[1][2],board[1][3]);
        System.out.println("-----------");
        System.out.printf(" %c | %c | %c \n",board[2][1],board[2][2],board[2][3]);
        System.out.println("-----------");
        System.out.printf(" %c | %c | %c \n",board[3][1],board[3][2],board[3][3]);
    }

    /**
     *  Clean the board,and reset the end to false, the count to 0.
     */
    public void resetBoard(){
        for(int i=1;i<board.length;i++){
            for(int j=1;j<board.length;j++){
                board[i][j]=' ';
            }   
        }
        end = false;
        count=0;
    }
    
}
