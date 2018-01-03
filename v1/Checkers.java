public abstract class Checkers{
    private int checkerX;
    private int checkerY;

    public int getCheckerX(){
	return checkerX();
    }

    public boolean forceCapture(checkerX, checkerY){
	
    }

    public abstract boolean moveValid();

    public abstract void move();

    
}
