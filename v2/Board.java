import java.util.ArrayList;
public class Board {
    private char whoseTurn;
    private final static int SIZE = 8;
    private Checkers[][] board;
    private int rLeft = 12;
    private int bLeft = 12;
    private ArrayList<Integer> posr = new ArrayList<Integer>(12);
    private ArrayList<Integer> posc = new ArrayList<Integer>(12);
    private ArrayList<String> posd = new ArrayList<String>(12);



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

    public String getposc(){
        String retStr = "[ ";
        for (int c: posc){
            retStr += c + " , ";
        }
        retStr += " ]";
        return retStr;
    }

    public String getposd(){
        
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

    public boolean flValid(int r, int c){
	boolean bol = true;
	if ( r == 0 || c == 0) {
	    bol = false;
	} else if(board[r-1][c-1].getColor() != '_') {
	    bol =  false;
	} else if (board[r][c] instanceof BChecker){
	    bol = false;
        }
	return bol;
    }

    public boolean frValid(int r, int c) {
	boolean bol = true;
	if ( r == 0 || c == 7) {
	    bol = false;
	} else if(board[r-1][c+1].getColor() != '_') {
	    bol =  false;
	} else if (board[r][c] instanceof BChecker){
	    bol = false;
        }
	return bol;
    }

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

    public void flMove(int x, int y) {
	Checkers temp;
	if (x - 1 == 0 && board[x][y].getColor() == 'r'){
	    temp = new RKing();
	} else{
	    temp = board[x][y];
	}
	board[x][y] = board[x-1][y-1];
	board[x-1][y-1] = temp; 
    }
        

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

    public boolean bljumpValid(int x, int y){
        boolean bol = false;
        char c = board[x][y].getColor();
        if (board[x][y] instanceof RChecker) {
            return false;
        }
        if(board[x + 1][y - 1].getColor() != '_' && board[x + 1][y - 1].getColor() != c && board[x+2][y+2].getColor() == '_'){
            bol = true;
        }
        return bol;
    }

    public void makeKing(int x, int y){

    }

    public boolean forcedCapture(){
        boolean boo = false;
        for(int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (!(board[r][c] instanceof BChecker) && board[r][c].getColor() != '_') {
                    if (c < 2 && r > 1) {
                        if (frjumpValid(r, c)) {
                            posr.add(r);
                            posc.add(c);
                            posd.add("fr");
                            boo = true;
                        }
                    }
                    if (c > 5 && r > 1) {
                        if (fljumpValid(r, c)) {
                            posr.add(r);
                            posc.add(c);
                            posd.add("fl");
                            boo = true;
                        }
                    }
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
                            posr.add(r);
                            posc.add(c);
                            posd.add("br");
                            boo = true;
                        }
                    }
                    if (c > 5 && r < 6) {
                        if (bljumpValid(r, c)) {
                            posr.add(r);
                            posc.add(c);
                            posd.add("br");
                            boo = true;
                        }
                    }
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
                            posd.add("br");
                            boo = true;
                        }
                    }
                }
            }
        }
	    return boo;
    }



    public void flJump(int x, int y){
            Checkers space = new Checkers();
            Checkers temp;
            if (x - 2 == 0 && board[x][y].getColor() == 'r') {
                temp = new RKing();
            } else {
                temp = board[x][y];
            }
            board[x][y] = board[x - 2][y - 2];
            board[x - 1][y - 1] = space;
            board[x - 2][y - 2] = temp; 
        }



    public void frJump(int x, int y){
	    Checkers space = new Checkers();
	    Checkers temp;
	    if( x - 2 == 0 && board[x][y].getColor() == 'r'){
	         temp = new RKing();
	    }else {
	        temp = board[x][y];
        }
        board[x][y] = board[x-2][y+2];
        board[x-1][y+1] = space;
        board[x-2][y+2] = temp;
    }

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
}

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

    public static void main(String args[]) {
        Board hey = new Board();
        hey.initBoard();
        hey.printBoard();
        // Testing Jumping Methods
        hey.frMove(5,1);
        System.out.println(hey.forcedCapture());
        hey.blMove(2,4);
        System.out.println(hey.forcedCapture());
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
