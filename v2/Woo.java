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


    //get the row number and the column number
    public int[] getPos(){
	int[] retArray = new int[2];
	retArray[0] = row;
	retArray[1] = column;
	return retArray;
    }

    //print the row number and the column number that the user chose
    public void printPos(){
	System.out.print("[" + row + "," + column + "]" + "\n");
    }

    //accessor for the number of move red has done
    public int getrnumMove(){
	return rnumMove;
    }

    //accessor for the number of move black has done
    public int getbnumMove() {
	return bnumMove;
    }

    //accessor for the first username
    public String getUserName1(){
	return userName1;
    }

    //accessor for the second username
    public String getUserName2() {
	return userName2;
    }

    //check if the row number user entered is in the range of board
    public boolean inBoardx(int x){
	return x >= 0 && x <= 7;
    }

    //check if the column number user entered is in the range of board 
    public boolean inBoardy(int y){
	return y >= 0 && y <= 7;
    }

    //ask user for row number
    //use inBoardx, and keep asking the user for row until it is in the range
    public void chooseXCoord(){
	System.out.print(whoseturn + ") " +  "Choose the row number of your checkerpiece: ");
	row = Keyboard.readInt();
	if(inBoardx(row) == false) {
	    System.out.println("out of the board");
	    chooseXCoord();
	}
    }

    //ask user for column number
    //use inBoardy, and keep asking the user for column until it is in the range
    public void chooseYCoord(){
	System.out.print(whoseturn + ")" +  "Choose the column number of your checkerpiece.. ");
	column = Keyboard.readInt();
	if(inBoardy(column) == false) {
	    System.out.println("out of the board");
	    chooseYCoord();
	}
    }

    //Check color of the chosen checker, so that user are not picking checker not from their side
    public boolean validChecker(Board b){
        if((b.boardCheckerColor(row, column) == 'r') && (whoseturn == 'r')) {
            return true;
        } else if((b.boardCheckerColor(row,column) == 'b') && (whoseturn == 'b')){
            return true;
        }
	return false;
    }

    //incorporate all check methods    
    public void chooseChecker(Board b){
        chooseXCoord();    //check range of x coord
        chooseYCoord();    //check range of y coord
        System.out.print("You chose ");
        printPos();
	//check forced capture, if false, recurse
	if(b.forcedCapture(row,column,whoseturn)) {
	    if(b.getposr().contains(row) == false || b.getposc().contains(column) == false) {
		System.out.println("You have a forced capture availiable " + "on the " + whoseturn + " side, " +  "please check the board again." + "\n");
		chooseChecker(b);
	    }
	}
	//check color, if false, recurse
	if(! (validChecker(b))) {
	    System.out.println("Invalid Checker! Choose again!" + "\n");
	    b.printBoard();
	    chooseChecker(b);
	}
    }

    //incorporate all simple movement methods in board so that they flow according to flowchart
    public void movements(Board name) {
	System.out.print("Choose your movement (fl,fr,br,bl):  ");
	move = Keyboard.readString(); //store user input
	//compare user input with each of the movement valid method
	//if movement is valid, execute the move
	//if movement not valid, keep asking for move until true
	if(move.equals("fl")) {
	    if(name.flValid(row,column)) {
		name.flMove(row,column);
	
	    } else {
		movements(name);
	    }
	} else if(move.equals("bl")) {
	    if(name.blValid(row,column)) {
	        name.blMove(row,column);
		
	    } else {
		movements(name);
	    }
	} else if(move.equals("br")) {
	    if(name.brValid(row,column)) {
		name.brMove(row,column);
		
	    } else {
		movements(name);
	    }
	} else if(move.equals("fr")) {
	    if(name.frValid(row,column)) {
		name.frMove(row,column);
		
	    } else {
		movements(name);
	    }
	} 
    }

    //incorporate all jump methods in Board so that it flows according to the flowchart
    public void jump(Board name) {
	System.out.println("You can jump your checker now, please enter (fl,fr,bl,br) to indicate direction");
	move = Keyboard.readString();
	//check if the user input match with the characteristic of the checkers availiable
	//to do force capture
	if(name.checkF(row,column,move)) {
	    //check if the direction of jump the user enters make sense
	    //if it makes sense, execute the jump
	    if(move.equals("br")) {
		if(name.brjumpValid(row,column)) {
		    name.brJump(row,column);
			
		}
	    } if(move.equals("bl")) {
		if(name.bljumpValid(row,column)) {
		    name.blJump(row,column);
			
		}
	    } if(move.equals("fr")) {
		if(name.frjumpValid(row,column)) {
		    name.frJump(row, column);
			
		}							 
	    } if(move.equals("fl")) {
		if(name.fljumpValid(row,column)) {
		    name.flJump(row,column);
					    
		}
							 
	    }
	}
	//if the user input did not match with the characteristics of the checkers availiable to do force capture, then their jump is invalid
	else {
	    System.out.println("invalid jump, might be out of board");
	    jump(name);
	}

    }
    



    //run the game
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
	    x.clearposd();
        chooseChecker(x);
	if(x.forcedCapture(row,column,whoseturn)) {
	    jump(x); 
	} else {
	    movements(x);
	}

	//switch turns
	if(whoseturn == 'r') {
	    whoseturn = 'b';
	    bnumMove++;
	} else {
	    whoseturn = 'r';
	    rnumMove++;
	}

	//end game
	if(x.getrLeft() == 0){
	    ingame = false;
	    System.out.println(userName2 + "Wins!");
	}
	if(x.getbLeft() == 0){
	    ingame = false;
	    System.out.println(userName1 + " wins!");
	}
	
	}
    }
    

    public static void main(String[] args){
	Woo game = new Woo();
		
		
    }
}


