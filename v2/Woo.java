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
    private String userName1;
    private String userName2;
    

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
    public String getUserName1(){
	return userName1;
    }

    public String getUserName2() {
	return userName2;
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
	System.out.println(whoseturn + ") " +  "Choose the row number of your checkerpiece.");
	row = Keyboard.readInt();
	if(inBoardx(row) == false) {
	    System.out.println("out of the board");
	    chooseXCoord();
	}
    }

    //
    public void chooseYCoord(){
	System.out.println(whoseturn + ")" +  "Choose the column number of your checkerpiece..");
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
        } else if(b.forcedCapture()) {
	    if(b.getposr().contains(row) == false || b.getposc().contains(column) == false) {
		return false;
	    }
	}
	return false;
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
	} 
    }


    public void jump(Board name) {
	if(name.getposr().contains(row) && name.getposc().contains(column)) {
	    System.out.println("You can jump your checker now, please enter (fl,fr,bl,br) to indicate direction");
	    move = Keyboard.readString();
		if(move.equals("br")) {
		    if(name.brjumpValid(row,column)) {
			name.brJump(row,column);
			whoseturn = 'r';
			bnumMove++;
		    }
		} if(move.equals("bl")) {
		    if(name.bljumpValid(row,column)) {
			name.blJump(row,column);
			whoseturn = 'r';
			bnumMove++;
		    }
		} if(move.equals("fr")) {
		    if(name.frjumpValid(row,column)) {
			name.frJump(row, column);
			whoseturn = 'b';
			rnumMove++;
		    }							 
		} if(move.equals("fl")) {
		    if(name.fljumpValid(row,column)) {
			name.flJump(row,column);
			whoseturn = 'b';
			bnumMove++;			    
		    }
							 
		}
	    	    
	}
    }



    public void runGame(){
	System.out.println("Welcome to Checkers v1");
	System.out.print("Player 1, please enter your username: ");
	userName1 = Keyboard.readString();

        System.out.print("Player 2, please enter your username: ");
        userName2 = Keyboard.readString();

	System.out.print("\n");
	System.out.println("Players, please spend some time and read the instructions of the game carefully.");
	System.out.println("1. Red Checkers always start first, so decide among yourself who would be the one to hold red");
	System.out.println("2. The basic movement is to move a checker one diagonally forward or backward based on the color of your checker. For example, a black checker can only move backward, while a red checker can only move forward. You can execute movement by entering fl (forward left), fr(forward right), bl(backward left), br (backward right)");
	System.out.println("3. If a jump is available for one of your pieces, you must make that jump (cannot move other pieces). If more jumps are available with that same piece, you must continue to jump with it until it can jump no more. When there is a jump avaliable, we will notify you and you can execute the jump with the same commands as simple movements");
	System.out.println("4.When one of your checkers reaches the opposite side of the board, it is crowned and becomes a King. A King can move backward as well as forward along the diagonals");
        System.out.println("\n");
	System.out.println("Sounds fun, right? Let's get to it!");
	System.out.print("Please type 'yay' to start, and ctrl-c to quit: ");
	String ans = Keyboard.readString();
    	
				    
	Board x = new Board();
	x.initBoard();
	while (ingame){
	    x.printBoard();
	    x.clearposr();
	    x.clearposc();
        chooseChecker(x);
	if(x.forcedCapture()) {
	    jump(x); 
	} else {
	    movements(x);
	}
	    if(x.getrLeft() == 0){
		ingame = false;
		System.out.println("Black Wins!");
	    }
	    if(x.getbLeft() == 0){
		ingame = false;
		System.out.println("Red wins!");
	    }
			
	}
    }

    public static void main(String[] args){
	Woo game = new Woo();
		
		
    }
}


