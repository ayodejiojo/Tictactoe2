package com.example.lola.tictactoe;

/**
 * Created by Lola on 4/16/2018.
 */

public class DameBoard {
    private String[][] theBoard = new String[5][5];

    DameBoard() {
        //Initiate the game board with blanks
        for (int i = 0; i < 5; i++) {


            for (int j = 0; j < 5; j++) {
                theBoard[i][j] = "";
            }


        }


    }




    //Checks to make sure a mark doesn't already exist before placing the mark.
    public void placeMark(int xloc, int yloc, String mark) {
        if (theBoard[xloc][yloc] == "") theBoard[xloc][yloc] = mark;


    }



    //Determines if there is a winner or not checks each diagonal then loops through each row/column
    public boolean isWinner() {
        // Check Diagonals
        if (theBoard[0][0] == theBoard[1][1] && theBoard[0][0] == theBoard[2][2] && theBoard[0][0] == theBoard[3][3] &&
                theBoard[0][0] == theBoard[4][4] && theBoard[0][0] != "")


            return true;


        if (theBoard[4][0] == theBoard[3][1] && theBoard[4][0] == theBoard[2][2] && theBoard[4][0] ==theBoard[1][3] &&
                theBoard[4][0]==theBoard[0][4] &&
                theBoard[4][0] != "")


            return true;


        for (int i = 0; i < 5; i++) {


            // Check Rows
            if (theBoard[i][0] == theBoard[i][1] && theBoard[i][1] == theBoard[i][2] && theBoard[i][2] == theBoard[i][3] &&
                    theBoard[i][3] == theBoard[i][4] &&
                    theBoard[i][0] != "")


                return true;


            // Check Columns
            if (theBoard[0][i] == theBoard[1][i] && theBoard[1][i] == theBoard[2][i] && theBoard[2][i] == theBoard[3][i] &&
                    theBoard[3][i] == theBoard[4][i] &&
                    theBoard[0][i] != "")


                return true;


        }


        return false;
    }

    //Clears the game board by looping through each row and column and puts the empty string
    public void clear() {
        for (int i = 0; i < 5; i++) {


            for (int j = 0; j < 5; j++) {


                theBoard[i][j] = "";


            }


        }


    }


    //getter that returns the virtual board
    public String[][] getBoard() {
        return theBoard;


    }

}
