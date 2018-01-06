/*
  Team git-it-dun
  Driver Class
*/

// Importing necessary classes
import java.io.*;
import java.util.*;

public class Woo{
    
    // Instance vars
    private boolean ingame;
    private int xpos;
    private int ypos;
    private InputStreamReader isr;
    private BufferedReader in;
    private String move;
    private int numMove;
    private String userName;
    
    // Default Constructor
    public Woo(){
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	ingame = true;
	runGame();
    }

    // 
    public int[] getPos(){
	int[] retArray = new int[2];
	retArray[0] = xpos;
	retArray[1] = ypos;
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
	System.out.println("Choose your checkerpiece(x-coord).");
	try{
	    Object x = Integer.parseInt( in.readLine() );
	    if (! (x instanceof Integer)){
		System.out.println("Please type in an integer");
		chooseXCoord();
	    }		    
	    if(inBoardx((int)x)){
		xpos = (int) x;
	    } else{
		System.out.println("That coordinate is not on the board!");
		chooseXCoord();    
	    }} catch (Exception e){
	}
	return xpos;
    }


    //
    public int chooseYCoord(){
	System.out.println("Choose your checkerpiece(y-coord).");
	try{
	    Object y = Integer.parseInt( in.readLine() );
	    if (! (y instanceof Integer)){
		System.out.println("Please type in an integer");
		chooseYCoord();
	    }		    
	    if(inBoardy((int)y)){
		ypos = (int)y;
	    } else{
		System.out.println("That coordinate is not on the board!");
		chooseYCoord();    
	    }} catch (Exception e){
	}
	return ypos;
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
	   
	    System.out.println("Choose a spot for the checkerpiece to move(x-coord)");
	    try{
		if(inBoardx(Integer.parseInt( in.readLine() ))){
		    System.out.println("This will check for valid move and execute");
		}
	    } catch (Exception e){
	    }
	    System.out.println("Choose a spot for the checkerpiece to move(y-coord)");
	    try{
		if(inBoardy(Integer.parseInt( in.readLine() ))){
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

