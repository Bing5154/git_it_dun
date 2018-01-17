import java.util.ArrayList;
public class Board {
    //private instance variables
    private char whoseTurn;
    private final static int SIZE = 8;
    private Checkers[][] board;
    private int rLeft = 12;
    private int bLeft = 12;
    //posr stores the row number of potential checkers availiable for forced capture
    private ArrayList<Integer> posr = new ArrayList<Integer>(12);
    //posc stores the column number of potential checkers availiable for forced capture
    private ArrayList<Integer> posc = new ArrayList<Integer>(12);
    //posd stores teh row number of potential checkers availiable for forced capture
    private ArrayList<String> posd = new ArrayList<String>(12);

    //default constructor
    public Board() {
	board = new Checkers[SIZE][SIZE];
	whoseTurn = 'r';

    }

    //reset posr after every single move, because positions have changed
    public void clearposr(){
	posr = new ArrayList<Integer>(12);
	
    }

    //reset posc after every single move, because positions have changed
    public void clearposc(){
	posc = new ArrayList<Integer>(12);
    }

    //reset posd after every single move, because positions have changed
    public void clearposd() {
	posd = new ArrayList<String>(12);
    }

    //would be used in Woo to check if the checker has all properties availiable for forced capture
    public boolean checkF(int r, int c, String m) {
	for(int i = 0; i < posr.size(); i++) {
	    if(posr.get(i) == r && posc.get(i) == c && posd.get(i).equals(m)) {
		return true;
	    }
	}
	return false;
    }

    //accessor of posr
    public ArrayList<Integer> getposr() {
	return posr;
    }

    //accessor for posc
    public ArrayList<Integer> getposc() {
	return posc;
    }

    //accessor for posd
    public ArrayList<String> getposd() {
	return posd;
    }

    //accessor for number of red checkers left, helpful in end game
    public int getrLeft(){
	return rLeft;
    }

    //mutator for rLeft, substract 1 from total once jump is executed
    public void setrLeft(){
	rLeft -= 1;
    }

    //accessor for number of red checkers left, helpful in end game
    public int getbLeft(){
	return bLeft;
    }

    //mutator for bLeft, subtract 1 from total once jump is executed
    public void setbLeft() {
	bLeft -= 1;
    }

    
    public void initBoard() {
	//initialize all elements in the 2d array as Checkers
	//Checkers should have a toString that represent them as "_"
	for(int i = 0; i < SIZE; i++) {
	    for(int j = 0; j < SIZE; j++) {
		board[i][j] = new Checkers();
	    }
	}

	//after setting all elements into Checkers
	//set specific items of the arraylist into black checkers and red checkers
	for(int j = 1; j < SIZE; j+=2) {
	    board[1][j] = new BChecker();
	    board[5][j] = new RChecker();
	    board[7][j] = new RChecker();
	}

	for(int j = 0; j < SIZE; j+=2) {
	    board[0][j] = new BChecker();
	    board[2][j] = new BChecker();
	    board[6][j] = new RChecker();

	}
    }

    //the toString method of board
    public void printBoard() {
	System.out.println("  0  1  2  3  4  5  6  7 ");
	for(int i = 0; i < SIZE; i++) {
	    System.out.print(i + " ");
	    for(int j = 0; j < SIZE; j++) {
		System.out.print(board[i][j].toString() + "  ");
	    }
	    System.out.println();
	}
    }

    //check if regular forward left movement is valid
    public boolean flValid(int r, int c){
	boolean bol = true;
	//in range?
	if ( r == 0 || c == 0) {
	    bol = false;
	} else if(board[r-1][c-1].getColor() != '_') {
	    bol =  false;
	} else if (board[r][c] instanceof BChecker){
	    bol = false;
        }
	return bol;
    }

    //check if regular forward right movement is valid
    public boolean frValid(int r, int c) {
	boolean bol = true;
	//in range?
	if ( r == 0 || c == 7) {
	    bol = false;
	}
	//not blocked?
	else if(board[r-1][c+1].getColor() != '_') {
	    bol =  false;
	}
	//your side?
	else if (board[r][c] instanceof BChecker){
	    bol = false;
        }
	return bol;
    }

    //check if regular backward left movement is valid
    public boolean blValid(int r, int c) {
	boolean bol = true;
	if ( r == 7 || c == 0) {
	    bol = false;
	} else if(board[r+1][c-1].getColor() != '_') {
	    bol =  false;
	} else if (board[r][c] instanceof RChecker){
	    bol = false;
        }
	return bol;
    }

    //check if regular backward right movement is valid
    public boolean brValid(int r, int c) {
	boolean bol = true;
	if ( r == 7 || c == 7) {
	    bol = false;
	} else if(board[r+1][c+1].getColor() != '_') {
	    bol =  false;
	} else if (board[r][c] instanceof RChecker){
	    bol = false;
        }
	return bol;
    }

    //execute forward left movement
    public void flMove(int x, int y) {
	Checkers temp;
	//if regular checker reaches the opposite end, turn into king
	if (x - 1 == 0 && board[x][y].getColor() == 'r'){
	    temp = new RKing();
	} else{
	    temp = board[x][y];
	}
	//swap
	board[x][y] = board[x-1][y-1];
	board[x-1][y-1] = temp; 
    }
        
    //execute forward right movement
    public void frMove(int x, int y) {
	Checkers temp;
	if (x -1 == 0 && board[x][y].getColor() == 'r'){
	    temp = new RKing();
	}else {
	    temp = board[x][y];
	}
	board[x][y] = board[x-1][y+1];
	board[x-1][y+1] = temp;
    }

    //execute backward right movement
    public void brMove(int x, int y) {
	Checkers temp;
	if(x + 1 == 7 && board[x][y].getColor() == 'b'){
	    temp = new BKing();
	}else {
	    temp = board[x][y];
	}
	board[x][y] = board[x+1][y+1];
	board[x+1][y+1] = temp;
    }

    //execute backward left movement
    public void blMove(int x, int y) {
	Checkers temp;
	if(x + 1 == 7 && board[x][y].getColor() == 'b'){
	    temp = new BKing();
	}else {
	    temp = board[x][y];
	}
	board[x][y] = board[x+1][y-1];
	board[x+1][y-1] = temp;
    }

    //check if forward left jump is valid
    public boolean fljumpValid(int x, int y)  {
        boolean bol = false;
        char c = board[x][y].getColor();
        if (board[x][y] instanceof BChecker) {
            return false;
        }
        if (board[x - 1][y - 1].getColor() != '_' && board[x - 1][y - 1].getColor() != c && board[x-2][y-2].getColor() == '_') {
            bol = true;
        }
        return bol;
    }

    //check if forward right jump is valid
    public boolean frjumpValid(int x, int y) {
        boolean bol = false;
        char c = board[x][y].getColor();
        if (board[x][y] instanceof BChecker) {
            return false;
        }
        if(board[x - 1][y + 1].getColor() != '_' && board[x - 1][y + 1].getColor() != c && board[x-2][y+2].getColor() == '_') {
            bol = true;
        }
        return bol;
    }

    //check if backward right jump is valid
    public boolean brjumpValid(int x, int y){
        boolean bol = false;
        char c = board[x][y].getColor();
        if (board[x][y] instanceof RChecker) {
            return false;
        }
        if(board[x + 1][y + 1].getColor() != '_' && board[x + 1][y + 1].getColor() != c && board[x+2][y+2].getColor() == '_'){
            bol = true;
        }
        return bol;
    }

    //check if backward left jump is valid
    public boolean bljumpValid(int x, int y){
        boolean bol = false;
        char c = board[x][y].getColor();
        if (board[x][y] instanceof RChecker) {
            return false;
        }
        if(board[x + 1][y - 1].getColor() != '_' && board[x + 1][y - 1].getColor() != c && board[x+2][y-2].getColor() == '_'){
            bol = true;
        }
        return bol;
    }

    
    //check for forced capture
    public boolean forcedCapture(int row, int col, char comp){
        boolean boo = false;
	//loop through the entire checkerboard --> kinda insufficient, but don't know alternative ways to do it
        for(int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
		//special check for the Kings
                if(board[r][c].getColor() == comp) {
		    if (!(board[r][c] instanceof BChecker) && board[r][c].getColor() != '_') {
			//checkers in this area (restrictions below) could only move fr
			if (c < 2 && r > 1) {
			    if (frjumpValid(r, c)) {
				//remember the properties of checkers availiable for forced capture
				//so that it can be checked against user input 
				posr.add(r);
				posc.add(c);
				posd.add("fr");
				boo = true;
			    }
			}
			//checkers in this area (restriction below) could only move fl
			if (c > 5 && r > 1) {
			    if (fljumpValid(r, c)) {
				posr.add(r);
				posc.add(c);
				posd.add("fl");
				boo = true;
			    }
			}
			//checkers in this area (restriction below) could move fl and fr
			if(r > 1 && c >= 2 && c <= 5){
			    if (fljumpValid(r, c)) {
				posr.add(r);
				posc.add(c);
				posd.add("fl");
				boo = true;
			    }
			    if (frjumpValid(r, c)) {
				posr.add(r);
				posc.add(c);
				posd.add("fr");
				boo = true;
			    }
			}
		    }
		    if (!(board[r][c] instanceof RChecker) && board[r][c].getColor() != '_') {
			if (c < 2 && r < 6) {
			    if (brjumpValid(r, c)) {
				//checkers in this area (restriction below) could move br
				posr.add(r);
				posc.add(c);
				posd.add("br");
				boo = true;
			    }
			}
			//checkers in this area (restriction below) could only move bl
			if (c > 5 && r < 6) {
			    if (bljumpValid(r, c)) {
				posr.add(r);
				posc.add(c);
				posd.add("bl");
				boo = true;
			    }
			}
			//checkers in this area (restriction below) could only move br and bl
			if (r < 6 && c >= 2 && c <= 5) {
			    if (brjumpValid(r, c)) {
				posr.add(r);
				posc.add(c);
				posd.add("br");
				boo = true;
			    }
			    if (bljumpValid(r, c)) {
				posr.add(r);
				posc.add(c);
				posd.add("bl");
				boo = true;
			    }
			}
		    }
		}
	    }
	}
	return boo;
    }


    //execute forward left jump
    public void flJump(int x, int y){
	Checkers space = new Checkers();
	Checkers temp;
	//turn into a king when jump into the last row on the opposite side
	if (x - 2 == 0 && board[x][y].getColor() == 'r') {
	    temp = new RKing();
	} else {
	    temp = board[x][y];
	}
	board[x][y] = board[x - 2][y - 2];
	board[x - 1][y - 1] = space;
	board[x - 2][y - 2] = temp;
	setbLeft();
    }


    //execute forward right jump
    public void frJump(int x, int y){
	Checkers space = new Checkers();
	Checkers temp;
	//turn into king
	if( x - 2 == 0 && board[x][y].getColor() == 'r'){
	    temp = new RKing();
	}else {
	    temp = board[x][y];
        }
        board[x][y] = board[x-2][y+2];
        board[x-1][y+1] = space;
        board[x-2][y+2] = temp;
	setbLeft();
	
    }

    //execute backward left jump
    public void blJump(int x, int y){
        Checkers space = new Checkers();
        Checkers temp;
        if( x + 2 == 7 && board[x][y].getColor() == 'b'){
	    temp = new BKing();
        }else{
            temp = board[x][y];
        }
	board[x][y] = board[x+2][y-2];
	board[x+1][y-1] = space;
	board[x+2][y-2] = temp;
	setrLeft();
    }

    //execute backward right jump
    public void brJump(int x, int y){
        Checkers space = new Checkers();
        Checkers temp;
        if( x + 2 == 7 && board[x][y].getColor() == 'b'){
	    temp = new BKing();
        }else{
	    temp = board[x][y];
        }
        board[x][y] = board[x+2][y+2];
        board[x+1][y+1] = space;
        board[x+2][y+2] = temp;
	setrLeft();
    }


    //debug purpose, useful in validChecker
    public char boardCheckerColor(int row, int column) {
        if (board[row][column].getColor() == 'r') {
	    /*debug
	      System.out.println("r");
	    */
	    return 'r';
        } else if (board[row][column].getColor() == 'b') {
	    /* debug
	       System.out.println("b");
	    */
	    return 'b';
        } else {
	    /* debug
	       System.out.println("_");
	    */
	    return '_';
        }
    }

    public static void main(String args[]) {
        Board hey = new Board();
        hey.initBoard();
        hey.printBoard();
        // Testing Jumping Methods
        hey.frMove(5,1);
        hey.blMove(2,4);
        hey.printBoard();
        System.out.println(hey.bljumpValid(4,2))	;
        System.out.println(hey.fljumpValid(4,2)) ;
        System.out.println(hey.brjumpValid(4,2));
        System.out.println(hey.frjumpValid(4,2));
        /*System.out.println( hey.flValid(5,1));
	  System.out.println( hey.flValid(2,2));
	  System.out.println( hey.frValid(5,3));
	  System.out.println( hey.flValid(6,0));
	  System.out.println( hey.blValid(5,1));

	  hey.frMove(5,1);
	  hey.blMove(2,4);
	  System.out.println("hello");
	  System.out.println(hey.jumpValid(4,2));
	  hey.printBoard();

	  hey.flMove(6,2);
	  hey.brMove(2,0);
	  System.out.println(hey.jumpValid(5,1));
	  hey.printBoard();

	  System.out.println(hey.jumpValid(7,7));

	  System.out.println(hey.jumpValid(7,5));

	  System.out.println(hey.jumpValid(6,1));
        */

    }
}
