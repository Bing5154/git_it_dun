/*
  Team git-it-dun
  Driver Class

UNFINISHED
*/

// Importing necessary classes
import java.io.*;
import java.util.*;

public class Woo{
    // Instance vars
    private boolean ingame;
    private int checkerX;
    private int checkerY;
    private InputStreamReader isr;
    private BufferedReader in;
    // Default Constructor
    public Woo(){
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	ingame = true;
	runGame();
    }
    public void runGame(){
	System.out.println("Welcome to Checkers v1");
	while (ingame){
	    Game x = new Game();
	    x.initBoard();
	    x.printBoard();
	    System.out.println("Choose your checkerpiece(x-coord)");
	    try{
		checkerX = Integer.parseInt( in.readLine() );
	    } catch (Exception e){
	    }
	    System.out.println("Choose your checkerpiece(y-coord)");
	    try{
		checkerY = Integer.parseInt( in.readLine() );
	    } catch (Exception e){
	    }
	    System.out.println("Choose a spot for the checkerpiece to move(x-coord)");
	    try{

	    } catch (Exception e){
	    }
	    System.out.println("Choose a spot for the checkerpiece to move(y-coord)");
	    try{

	    }catch (Exception e){
	    }
	    if(x.RLeft == 0){
		ingame = false;
		System.out.println("You lost!");
	    }
	    if(x.BLeft == 0){
		ingame = false;
		System.out.println("You win!");
	}
    }
    public static void main(String[] args){
	Woo game = new Woo();
	
	
    }
}
