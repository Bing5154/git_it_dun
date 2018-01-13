
public class Board {
    private String whoseTurn;
    private final static int SIZE = 8;
    private Checkers[][] board;
    private int rLeft = 12;
    private int bLeft = 12;
 

    public Board() {
	board = new Checkers[SIZE][SIZE];	
  	whoseTurn = "r";
	
    }

    public int getrLeft(){
	return rLeft;
    }

    public void setrLeft(){
	rLeft -= 1;
    }


    public int getbLeft(){
	return bLeft;
    }

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

    public boolean flValid(int x, int y){
	boolean bol = true;
	if (board[x][y].getColor() == 'b' || board[x][y].getColor() == '_' ){
	    bol = false;
	}
	if ( x-1 < 0 || y-1 < 0) {
	    bol = false;
	} else if(board[x-1][y-1].getColor() != '_') {
	    bol =  false;
	}
	return bol;
    }

    public boolean frValid(int x, int y) {
	boolean bol = true;
	if (board[x][y].getColor() == 'b' || board[x][y].getColor() == '_' ){
	    bol = false;
	}
	if ( x-1 < 0 || y+1 > 7) {
	    bol = false;
	}else if(board[x-1][y+1].getColor() != '_') {
	    bol =  false;
	}
	return bol;
    }

        public boolean blValid(int x, int y) {
	boolean bol = true;
	if (board[x][y].getColor() == 'r' || board[x][y].getColor() == '_' ){
	    bol = false;
	}
	if ( x+1 > 7 || y-1 < 0) {
	    bol = false;
	}else if(board[x+1][y-1].getColor() != '_') {
	    bol =  false;
	}
	return bol;
    }

        public boolean brValid(int x, int y) {
	boolean bol = true;
	if (board[x][y].getColor() == 'r' || board[x][y].getColor() == '_' ){
	    bol = false;
	}
	if ( x+1 > 7 || y+1 > 7) {
	    bol = false;
	}else if(board[x+1][y+1].getColor() != '_') {
	    bol =  false;
	}
	return bol;
    }

    
    public static void main(String args[]) {
	Board hey = new Board();
	hey.initBoard();
	hey.printBoard();
	System.out.println( hey.flValid(5,1));
	System.out.println( hey.flValid(2,2));
	System.out.println( hey.frValid(5,3));
	System.out.println( hey.flValid(6,0));
	System.out.println( hey.blValid(5,1));

		     
    }
}
