import java.util.ArrayList;

public class Board {
    private String whoseTurn;
    private final static int SIZE = 8;
    private ArrayList<Arraylist<Checkers>> board;
    private ArrayList<Checkers> red;
    private ArrayList<Checkers> black;


    public Board() {
	board = new String[SIZE][SIZE];
	red = new ArrayList <rCheckers>(12);
	black = new ArrayList<Checkers>(12);	
  	whoseTurn = "r";
	
    }

    public void initBoard() {
	//initialize all elements in the 2d array as Checkers
	//Checkers should have a toString that represent them as "_"
	for(int i = 0; i < SIZE; i++) {
	    for(int j = 0; j < SIZE; j++) {
		board.get(i).set(j, new Checkers());
	    }
	}

	//after setting all elements into Checkers
	//set specific items of the arraylist into black checkers and red checkers
	for(int j = 1; j < SIZE; j+=2) {
	    board.get(1).set(j,new bCheckers());
	    board.get(5).set(j,new rCheckers());
	    board.get(7).set(j,new rCheckers());
	}

	for(int j = 0; j < SIZE; j+=2) {
	    board.get(0).set(j,new bCheckers());
	    board.get(2).set(j,new bCheckers());
	    board.get(6).set(j,new rCheckers());
	}
    }

    public void printBoard() {
	System.out.println("  0 1 2 3 4 5 6 7 ");
	for(int i = 0; i < SIZE; i++) {
	    System.out.print(i + " ");
	    for(int j = 0; j < SIZE; j++) {
		System.out.print(board.get(i).get(j).toString() + "  ");	
	    }
	    System.out.println();
	}
    }

    public static void main(String args[]) {
	Board hey = new Board();
	hey.initBoard();
	hey.printBoard();
	
    }
}
