/*
  Team git-it-dun
  Driver Class
*/

// Importing necessary classes
import java.io.*;
import java.util.*;
import cs1.Keyboard;


public class Woo{
		
    // Instance vars
    private boolean ingame;
    private int row;
    private int column;
    private String move;
    private int rnumMove;
    private int bnumMove;
    private char whoseturn;
    private String userName;

    // Default Constructor
    public Woo(){
	ingame = true;
	rnumMove = 0;
	bnumMove = 0;
	whoseturn = 'r';
	runGame();
    }


    //
    public int[] getPos(){
	int[] retArray = new int[2];
	retArray[0] = row;
	retArray[1] = column;
	return retArray;
    }

    //
    public void printPos(){
	System.out.println("[" + row + "," + column + "]");
    }

    //
    public int getrnumMove(){
	return rnumMove;
    }

    public int getbnumMove() {
	return bnumMove;
    }

    //
    public String getUserName(){
	return userName;
    }

    //
    public boolean inBoardx(int x){
	return x >= 0 && x <= 7;
    }

    //
    public boolean inBoardy(int y){
	return y >= 0 && y <= 7;
    }

    //
    public void chooseXCoord(){
	System.out.println("Choose the row number of your checkerpiece.");
	row = Keyboard.readInt();
	if(inBoardx(row) == false) {
	    System.out.println("out of the board");
	    chooseXCoord();
	}
    }

    //
    public void chooseYCoord(){
	System.out.println("Choose the column number of your checkerpiece..");
	column = Keyboard.readInt();
	if(inBoardy(column) == false) {
	    System.out.println("out of the board");
	    chooseYCoord();
	}
    }

    public boolean validChecker(Board b){
        if((b.boardCheckerColor(row, column) == 'r') && (whoseturn == 'r')) {
            return true;
        } else if((b.boardCheckerColor(row,column) == 'b') && (whoseturn == 'b')){
            return true;
        } else {
            return false;
        }
    }

	public void chooseChecker(Board b){
        chooseXCoord();
        chooseYCoord();
        System.out.println("You chose ");
        printPos();
        if(! (validChecker(b))) {
            System.out.println("Invalid Checker! Choose again!");
            b.printBoard();
            chooseChecker(b);
        }
    }

     public void movements(Board name) {
	System.out.println("Choose your movement (fl,fr,br,bl): ");
	move = Keyboard.readString();
	if(move.equals("fl")) {
	    if(name.flValid(row,column) == true) {
		name.flMove(row,column);
		whoseturn = 'b';
		rnumMove++;
	    } else {
		movements(name);
	    }
	} else if(move.equals("bl")) {
	    if(name.blValid(row,column) == true) {
	        name.blMove(row,column);
		whoseturn = 'r';
		bnumMove++;
	    } else {
		movements(name);
	    }
	} else if(move.equals("br")) {
	    if(name.brValid(row,column) == true) {
		name.brMove(row,column);
		whoseturn = 'r';
		bnumMove++;
	    } else {
		movements(name);
	    }
	} else if(move.equals("fr")) {
	    if(name.frValid(row,column) == true) {
		name.frMove(row,column);
		whoseturn = 'b';
		rnumMove++;
	    } else {
		movements(name);
	    }
	} else {
	    System.out.println("movement you entered is not valid");
	}
    }




    public void runGame(){
	System.out.println("Welcome to Checkers v1");
	Board x = new Board();
	x.initBoard();
	while (ingame){
	    x.printBoard();
        chooseChecker(x);
	    movements(x);	    

	    if(x.getrLeft() == 0){
		ingame = false;
		System.out.println("You lost!");
	    }
	    if(x.getbLeft() == 0){
		ingame = false;
		System.out.println("You win!");
	    }
			
	}
    }

    public static void main(String[] args){
	Woo game = new Woo();
		
		
    }
}


