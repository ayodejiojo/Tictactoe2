package com.example.lola.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Single2Activity extends AppCompatActivity {

    private DameBoard board = null;

    private int moveCount = 0, xloc = 0, yloc = 0;
    private String mark = "X", aiMark = "O";
    private boolean isOver = false;
    private AIC ai = null;
    private int playerxPoints;
    private int playeraiPoints;
    private TextView playerX;
    private TextView playerO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single2);



        //Set up a new board and AI and assign the initial variables
        board = new DameBoard();

        ai = new AIC(aiMark);
    }

    public void resetClick(View v) {


        clear();
        if (aiMark == "X") getAIMove(board);


    }

    public void backToMenu(View view){
        Intent i = new Intent(Single2Activity.this,MainActivity.class);
        startActivity(i);
    }

    //Action for when a cell is clicked. Determines which cell has been clicked and passed that
// information on the the virtual game board.
    public void cellClick(View v) {
//Get the id of the clicked object and assign it to a Textview variable
        TextView sell = (TextView) findViewById(v.getId());
//Check the content and make sure the cell is empty and that the game isn't over
        String content = (String) sell.getText();
        if (content == "" && !isOver) {


//Find the X Y location values of the particular cell that was clicked
            switch (sell.getId()) {


                case R.id.sell11:
                    xloc = 0;
                    yloc = 0;
                    break;
                case R.id.sell12:
                    xloc = 0;
                    yloc = 1;
                    break;
                case R.id.sell13:
                    xloc = 0;
                    yloc = 2;
                    break;
                case R.id.sell14:
                    xloc = 0;
                    yloc = 3;
                    break;
                case R.id.sell15:
                    xloc = 0;
                    yloc = 4;
                    break;
                case R.id.sell21:
                    xloc = 1;
                    yloc = 0;
                    break;
                case R.id.sell22:
                    xloc = 1;
                    yloc = 1;
                    break;
                case R.id.sell23:
                    xloc = 1;
                    yloc = 2;
                    break;
                case R.id.sell24:
                    xloc = 1;
                    yloc = 3;
                    break;
                case R.id.sell25:
                    xloc = 1;
                    yloc = 4;
                    break;
                case R.id.sell31:
                    xloc = 2;
                    yloc = 0;
                    break;
                case R.id.sell32:
                    xloc = 2;
                    yloc = 1;
                    break;
                case R.id.sell33:
                    xloc = 2;
                    yloc = 2;
                    break;
                case R.id.sell34:
                    xloc = 2;
                    yloc = 3;
                    break;
                case R.id.sell35:
                    xloc = 2;
                    yloc = 4;
                    break;

                case R.id.sell41:
                    xloc = 3;
                    yloc = 0;
                    break;
                case R.id.sell42:
                    xloc = 3;
                    yloc = 1;
                    break;
                case R.id.sell43:
                    xloc = 3;
                    yloc = 2;
                    break;
                case R.id.sell44:
                    xloc = 3;
                    yloc = 3;
                    break;
                case R.id.sell45:
                    xloc = 3;
                    yloc = 4;
                    break;
                case R.id.sell51:
                    xloc = 4;
                    yloc = 0;
                    break;
                case R.id.sell52:
                    xloc = 4;
                    yloc = 1;
                    break;
                case R.id.sell53:
                    xloc = 4;
                    yloc = 2;
                    break;
                case R.id.sell54:
                    xloc = 4;
                    yloc = 3;
                case R.id.sell55:
                    xloc = 4;
                    yloc = 4;


            }

        }
        //Place the player's mark on the specific X Y location on both the virtual and displayed board
        board.placeMark(xloc, yloc, mark);
        sell.setText(mark);

        //Increment move Count because a move was just made
        moveCount++;


//Check to see if the game is over
        isOver = checkEnd(mark);


//if the game game is over get the AI's move
        if (!isOver)
            getAIMove(board);
    }

    public void onRadioButtonClicked(View view) {
//Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


//Check which radio button was clicked
        switch (view.getId()) {


//If the user wants to be X just clear the board and wait for his move
            case R.id.radio_X:


                if (checked)
                    mark = "X";
                aiMark = "O";
                clear();

                break;


//If the user wants to be O's then clear the board and get the AI's opening move
            case R.id.radio_O:


                if (checked)
                    mark = "O";
                aiMark = "X";
                clear();
                getAIMove(board);

                break;


        }


    }

    //Checks to see if the game has ended provided with the last player to make a move
    private boolean checkEnd(String player) {
//Checks the virtual board for a winner if there's a winner announce it with the provided player
        if (board.isWinner()) {


            announce(true, player);
            return true;
        } else if (board.isWinner()) {


            announce(true, player);
        }


//Check to see if we've reached our move total meaning it's a draw
        else if (moveCount >= 25) {


            announce(false, player);
            return true;


        }
//If neither win or draw then the game is still on
        return false;


    }


    //Announce the winner, given a boolean for whether it was a win or a draw
// and given the last player to make a mark
    private void announce(boolean endState, String player) {
//Check for if it's a win or a draw. if it's a win amend player with wins!
// if it's a lose replace player with it's a draw! I did this just because why
// declare another String when I can just reuse the one I have?


        if (endState == true)


            player = aiMark + " wins!";


        if (endState == true)


            player = mark + " wins";


        if (endState != true)


            player = "It's a draw!";


//Get the application Context and setup the Toast notification with the end state info
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, player, Toast.LENGTH_LONG);
        toast.show();


    }

    //Clears the game Board
    private void clear() {
//Get the id list of all the TextView cells
        int[] idList = {R.id.sell11, R.id.sell12, R.id.sell13, R.id.sell14, R.id.sell15, R.id.sell21, R.id.sell22,
                R.id.sell23, R.id.sell24, R.id.sell25, R.id.sell31, R.id.sell32, R.id.sell33, R.id.sell34, R.id.sell35,
                R.id.sell41, R.id.sell42, R.id.sell43, R.id.sell44, R.id.sell45, R.id.sell51, R.id.sell52, R.id.sell53, R.id.sell54, R.id.sell55};
        TextView cell;
//For each cell clear the text with an empty string
        for (int item : idList) {


            cell = (TextView) findViewById(item);
            cell.setText("");


        }


//Reset the game state and clear the virtual board
        isOver = false;
        moveCount = 0;

        board.clear();

    }

    //Gets the AI's next move giving the current state of the board
    private void getAIMove(DameBoard board) {
//Send the board to the AI for it to determine and return the move in an array {x,y}
        int[] move = ai.move(board, aiMark);
        TextView sell = null;
//Determine the right cell to use by id first go to the right row then the right column
        switch (move[0]) {
            case 0:


                switch (move[1]) {
                    case 0:


                        sell = (TextView) findViewById(R.id.sell11);
                        break;


                    case 1:


                        sell = (TextView) findViewById(R.id.sell12);
                        break;


                    case 2:


                        sell = (TextView) findViewById(R.id.sell13);
                        break;

                    case 3:
                        sell = findViewById(R.id.sell14);
                        break;

                    case 4:
                        sell = findViewById(R.id.sell15);


                }
                break;


            case 1:


                switch (move[1]) {
                    case 0:


                        sell = (TextView) findViewById(R.id.sell21);
                        break;


                    case 1:


                        sell = (TextView) findViewById(R.id.sell22);
                        break;


                    case 2:


                        sell = (TextView) findViewById(R.id.sell23);
                        break;


                    case 3:

                        sell = findViewById(R.id.sell24);
                        break;


                    case 4:

                        sell = findViewById(R.id.sell25);


                }
                break;


            case 2:


                switch (move[1]) {
                    case 0:


                        sell = (TextView) findViewById(R.id.sell31);
                        break;


                    case 1:


                        sell = (TextView) findViewById(R.id.sell32);
                        break;


                    case 2:


                        sell = (TextView) findViewById(R.id.sell33);
                        break;

                    case 3:


                        sell = (TextView) findViewById(R.id.sell34);
                        break;


                    case 4:


                        sell = (TextView) findViewById(R.id.sell35);


                }
                break;


            case 3:


                switch (move[1]) {
                    case 0:


                        sell = (TextView) findViewById(R.id.sell41);
                        break;


                    case 1:


                        sell = (TextView) findViewById(R.id.sell42);
                        break;


                    case 2:


                        sell = (TextView) findViewById(R.id.sell43);
                        break;

                    case 3:


                        sell = (TextView) findViewById(R.id.sell44);
                        break;


                    case 4:


                        sell = (TextView) findViewById(R.id.sell45);


                }
                break;


            case 4:


                switch (move[1]) {
                    case 0:


                        sell = (TextView) findViewById(R.id.sell51);
                        break;


                    case 1:


                        sell = (TextView) findViewById(R.id.sell52);
                        break;


                    case 2:


                        sell = (TextView) findViewById(R.id.sell53);
                        break;

                    case 3:


                        sell = (TextView) findViewById(R.id.sell54);
                        break;


                    case 4:


                        sell = (TextView) findViewById(R.id.sell55);


                }
                break;


        }


//Make sure there's nothing already in the cell
// then place the mark with the ai's Mark, increment move count
// and check to see if the game's over
        if (sell != null && sell.getText() == "") {


            board.placeMark(move[0], move[1], aiMark);
            sell.setText(aiMark);
            moveCount++;
            isOver = checkEnd(aiMark);


        }


    }

    public void updatePoints() {
        playerX.setText("Player X: " + playerxPoints);
        playerO.setText("Player O: " + playeraiPoints);
    }

}
