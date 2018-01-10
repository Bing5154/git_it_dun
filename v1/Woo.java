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

    // 
    public int[] getPos(){
	int[] retArray = new int[2];
	retArray[0] = row;
	retArray[1] = column;
	return retArray;
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
    public int chooseXCoord(){
	System.out.println("Choose your checkerpiece(row number).");
        row = Keyboard.readInt(); 
	return row;
    }


    //
    public int chooseYCoord(){
	System.out.println("Choose your checkerpiece(column number).");
	column = Keyboard.readInt();
	return column;
    }


    
    public void runGame(){
	System.out.println("Welcome to Checkers v1");
	while (ingame){
	    Board x = new Board();
	    x.initBoard();
	    x.printBoard();
	    chooseXCoord();
	    chooseYCoord();
	    System.out.println("You chose " + getPos());
	    System.out.println(row + "." + column);
	   
	    System.out.println("Choose a spot for the checkerpiece to move(x-coord)");
	    try{
		if(inBoardx(Keyboard.readInt())){
		    System.out.println("This will check for valid move and execute");
		}
	    } catch (Exception e){
	    }
	    System.out.println("Choose a spot for the checkerpiece to move(y-coord)");
	    try{
		if(inBoardy(Keyboard.readInt())){
		    System.out.println("This will check for valid move and execute");
		}
	    }catch (Exception e){
	    }
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

