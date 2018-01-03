import java.lang.*;

public class RChecker extends Checker {

   
    public boolean moveValid(int xFrom, int yFrom, int xTo, int yTo) {
	//check if move is within grid
	if(xFrom > 7|| xTo > 7 || yTo > 7 || yFrom > 7
	   || xFrom < 0 || xTo < 0 || yFrom < 0 || yTo < 0) {
	    return false;
	}

	//Check to see if coordinate of moveTo is a blank square
	else if(board[xFrom][yFrom].equals(whoseMove) && board[xTo][yTo].equals("_")) {
	    //check case of a simple move
	    if(Math.abs(xFrom - xTo) == 1) {
		if((whoseMove.equals("R")) && (yTo - yFrom == 1)) {
		    return true;
		}
	    }

	    //checks for jump
	    else if (Math.abs(xFrom-xTo)==2) {
		if (whoseMove == 'R' && (yTo - yFrom == 2) && 
		    board[(xFrom+xTo)/2][(yFrom+yTo)/2] == "B") {
		    return true;
		}
	    }
	}		  
	return false;
    }

    public void executeMove(int xFrom, int yFrom, int xTo, int yTo) {
	
	// Change appropriate board elements and decrement redcheckers or
	// blackcheckers if necessary.
	board[xfrom][yfrom] = "_";
	board[xto][yto] = whoseMove;
	if (Math.abs(xTo - xFrom) == 2) {
	    board[(xFrom+xTo)/2][(yFrom+yTo)/2] = "_";
	    if (whoseMove == 'R')
		RLeft--;
	}
    }

}
