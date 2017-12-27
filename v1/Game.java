public class Game {
    private String whoseTurn;
    private final static int SIZE = 8;
    private int Rleft;
    private int Bleft;
    private String[][] board;


    public Game() {
	board = new String[SIZE][SIZE];
	Bleft = 12;
	Rleft = 12;
	whoseTurn = "R";
	
    }

    public void initBoard() {
	for(int i = 0; i < SIZE; i++) {
	    for(int j = 0; j < SIZE; j++) {
		board[i][j] = "_";
	    }
	}

	for(int j = 1; j < SIZE; j+=2) {
	    board[1][j] = "B";
	    board[5][j] = "R";
	    board[7][j] = "R";	
	}

	for(int j = 0; j < SIZE; j+=2) {
	    board[0][j] = "B";
	    board[2][j] = "B";
	    board[6][j] = "R";
	}
    }

    public void printBoard() {
	System.out.println(" 0 1 2 3 4 5 6 7 ");
	for(int i = 0; i < SIZE; i++) {
	    System.out.print(i + " ");
	    for(int j = 0; j < SIZE; j++) {
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public int getBLeft() {
	return Bleft;	
    }

    public int getRLeft() {
	return Rleft;
    }

    public String getWhoTurn() {
	return whoseTurn;
    }

    public static void main(String args[]) {
	Game hey = new Game();
	hey.initBoard();
	hey.printBoard();
	
    }
}
