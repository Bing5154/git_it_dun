public class Checkers {
    // Instance vars
    private int rLeft; // Check for how many red checkers are left
    private int bLeft; // Check for how many black checkers are left
    private boolean redTurn; // true = red turn and false = black turn
    protected char color; // r is for red and b is for black

    public Checkers {
	rLeft = 12;
	bLeft = 12;
	redTurn = true;
    }

    public abstract boolean frValid(int xpos, int ypos);
    public abstract void frMove(int xpos, int ypos);
    public abstract boolean flValid(int xpos, int ypos);
    public abstract void flMOve(int xpos, int ypos);

    public boolean inBoard(int xpos, int ypos){
	if (xpos <= 7 && xpos >= 0 && ypos <= 7 && ypos >= 0){
	    return true;
	}
	return false;
    }

    public abstract boolean forcedCapture(int xpos, int ypos);
    public int getrLeft(){
	return rLeft;
    }
    public int getbLeft(){
	return bLeft;
    }
    public boolean getTurn(){
	return redTurn;
    }
    public abstract char getColor;
    public abstract char setColor;
}
