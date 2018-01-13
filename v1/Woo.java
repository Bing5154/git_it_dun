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
    private int numMove;
    private String userName;
		
    // Default Constructor
    public Woo(){
	ingame = true;
	runGame();
    }

    public int getCol() {
	return column;
    }

    public int getRow() {
	return row;
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
    public int getnumMove(){
	return numMove;
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


     public void movements(Board name) {
	System.out.println("Choose your movement (fl,fr,br,bl): ");
	move = Keyboard.readString();
	if(move.equals("fl")) {
	    if(name.flValid(row,column) == true) {
		System.out.println("execute movements");
	    } else {
		movements(name);
	    }
	} else if(move.equals("bl")) {
	    if(name.blValid(row,column) == true) {
		System.out.println("execute movements");
	    } else {
		movements(name);
	    }
	} else if(move.equals("br")) {
	    if(name.brValid(row,column) == true) {
		System.out.println("execute movements");
	    } else {
		movements(name);
	    }  
	} else if(move.equals("fr")) {
	    if(name.frValid(row,column) == true) {
		System.out.println("execute movements");
	    } else {
		movements(name);
	    }
	} else {
	    System.out.println("movements not valid");  
	}		 	  
    }
   


		
    public void runGame(){
	System.out.println("Welcome to Checkers v1");
	while (ingame){
	    Board x = new Board();
	    x.initBoard();
	    x.printBoard();
	    chooseXCoord();
	    chooseYCoord();
	    System.out.println("You chose ");
	    printPos();
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

