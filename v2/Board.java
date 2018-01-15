public class Board {
	private char whoseTurn;
	private final static int SIZE = 8;
	private Checkers[][] board;
	private int rLeft = 12;
	private int bLeft = 12;
    private int[] posr = new int[12];
    private int[] posc = new int[12];



	public Board() {
		board = new Checkers[SIZE][SIZE];
		whoseTurn = 'r';

	}

	public String getposr(){
	    String retStr = "[ ";
	    for (int r: posr){
	        retStr += r + " , ";
        }
        retStr += " ]";
	    return retStr;
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

    public boolean forcedCapture() {
        boolean bol = false;
        int i = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c].getColor() == 'r') {
                    if (c < 6 && r > 1) {
                        if (board[r - 1][c + 1].getColor() == 'b' && board[r - 2][c + 2].getColor() == '_') {
                            bol = true;
                            posr[i] = r;
                            posc[i] = c;
                            i++;
                        }
                    }
                    if (c > 1 && r > 1) {
                        if (board[r - 1][c - 1].getColor() == 'b' && board[r - 2][c - 2].getColor() == '_') {
                            bol = true;
                            posr[i] = r;
                            posc[i] = c;
                            i++;
                        }
                    }
                    if (c < 6 && r < 6) {
                        if (board[r + 1][c + 1].getColor() == 'r' && board[r + 2][c + 2].getColor() == '_') {
                            bol = true;
                            posr[i] = r;
                            posc[i] = c;
                            i++;
                        }
                    }
                    if (c < 1 && r < 6) {
                        if (board[r + 1][c - 1].getColor() == 'r' && board[r + 2][c - 2].getColor() == '_') {
                            bol = true;
                            posr[i] = r;
                            posc[i] = c;
                            i++;
                        }
                    }
                }
            }
        }
        return bol;
    }

	public void flMove(int x, int y) {
		Checkers temp = board[x - 1][y - 1];
		board[x - 1][y - 1] = board[x][y];
		board[x][y] = temp;
	}

	public void frMove(int x, int y) {
		Checkers temp = board[x][y];
		board[x][y] = board[x-1][y+1];
		board[x-1][y+1] = temp;
	}

	public void brMove(int x, int y) {
		Checkers temp = board[x][y];
		board[x][y] = board[x+1][y+1];
		board[x+1][y+1] = temp;
	}

	public void blMove(int x, int y) {
		Checkers temp = board[x][y];
		board[x][y] = board[x+1][y-1];
		board[x+1][y-1] = temp;
	}
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

	public boolean jumpValid(int x, int y) {
		boolean bol = false;
		if(whoseTurn == 'r') {
			if(y < 6 && x > 1){
				if(board[x - 1][y + 1].getColor() == 'b' && board[x-2][y+2].getColor() == '_') {
					bol = true ;}
			}
			if(y > 1 && x > 1){
				if (board[x - 1][y - 1].getColor() == 'b' && board[x-2][y-2].getColor() == '_') {
					bol = true;}
			}
		}
		if(whoseTurn == 'b') {
			if( y < 6 && x < 6){
				if(board[x + 1][y + 1].getColor() == 'r' && board[x + 2][y+2].getColor() == '_') {
					bol = true;}
			}
			if ( y < 1 && x < 6){
				if (board[x + 1][y-1].getColor() == 'r' && board[x+2][y-2].getColor() == '_') {
					bol = true;}
			}
		}
		return bol;
	}

	public static void main(String args[]) {
		Board hey = new Board();
		hey.initBoard();
		hey.printBoard();
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