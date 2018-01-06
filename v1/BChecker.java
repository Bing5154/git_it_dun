public class BChecker extends Checkers{
    public BChecker() {
	color = 'b'
    }

    //show the checkerpiece on printboard
     public String toString() {
	return "b";
    }


    public boolean frValid(int xpos, int ypos) {
	xpos -= 1;
	ypos -= 1;
	if(Board.getColor(xpos,ypos) == '_') {
	    return true;
	}
        return false;
    }

    public void frMove(int xpos,int ypos) {
	Board.setColor(xpos, ypos, '_');
	Board.setColor(xpos + 1, ypos + 1, 'b');
    }

    public boolean flValid(int xpos, int ypos) {
	ypos -= 1;
	xpos += 1;
	if(Board.getColor(xpos,ypos) == '_') {
	    return true;
	}
	return false;
    }

    public void flMove(int xpos,int ypos) {
	Board.setColor(xpos - 1, ypos + 1, 'b');
	Board.setColor(xpos, ypos, '_');   
    }

    public boolean forcedCapture(int xpos, int ypos) {
	if((Board.getColor(xpos + 1,ypos + 1) == 'r' &&
	    Board.getColor(xpos + 2, ypos + 2) == '_' )||
	   (Board.getColor(xpos - 2, xpos + 2) == '_' &&
	    Board.getColor(xpos - 1, ypos + 1) == 'r')) {
	    return true;
	}
	return false;
    }

    public void multJump() {
	while (forcedCapture(int xpos,int ypos)) {
	    if(Board.getColor(xpos + 1,ypos + 1) == 'r' &&
	       Board.getColor(xpos + 2, ypos + 2) == '_') {

		Board.setColor(xpos + 2, ypos + 2, 'b');
		Board.setColor(xpos, ypos, '_');
		Board.setColor(xpos + 1, ypos + 1, '_');
		Board.setrLeft();
	    }
	    else if(Board.getColor(xpos - 2, xpos + 2) == '_' &&
		    Board.getColor(xpos - 1, ypos + 1) == 'r') {
		Board.setColor(xpos - 2, ypos + 2, 'b');
		Board.setColor(xpos, ypos , '_');
		Board.setColor(xpos + 1, ypos + 1, '_');
		Board.setrLeft();
	    }		
	}
    }
			 

}

