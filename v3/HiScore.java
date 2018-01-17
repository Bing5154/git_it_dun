import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class HiScore{
    
    //ArrayList<String[]> score = new ArrayList<String[]>();

    public HiScore() throws IOException{
	/*Lots of learning here

	//Scanner file = new Scanner(new File("score.txt"));

	String[] first;// = file.nextLine().split(" ");
	String winner1;// = first[0];
	String loser1;// = first[1];
	int moves1;// = Integer.parseInt(first[2]);
	//System.out.println(winner1 + " " + loser1 + " " + moves1);

	String[] second;// = file.nextLine().split(" ");
	String winner2;// = second[0];
	String loser2;// = second[1];
	int moves2;// = Integer.parseInt(second[2]);
	//System.out.println(winner2 + " " + loser2 + " " + moves2);

	String[] third;// = file.nextLine().split(" ");
	String winner3;// = third[0];
	String loser3;// = third[1];
	int moves3;// = Integer.parseInt(third[2]);
	//System.out.println(winner3 + " " + loser3 + " " + moves3);

	//score.add(first);
	//score.add(second);
	//score.add(third);
	*/
    }

    public HiScore(String play1, String play2, int num) throws IOException{
	this();
	//instantiating scanner
	Scanner file = new Scanner(new File("score.txt"));

	String[] first = file.nextLine().split(" ");
	String winner1 = first[0];
	String loser1 = first[1];
	int moves1 = Integer.parseInt(first[2]);
	//System.out.println(winner1 + " " + loser1 + " " + moves1);

	String[] second = file.nextLine().split(" ");
	String winner2 = second[0];
	String loser2 = second[1];
	int moves2 = Integer.parseInt(second[2]);
	//System.out.println(winner2 + " " + loser2 + " " + moves2);

	String[] third = file.nextLine().split(" ");
	String winner3 = third[0];
	String loser3 = third[1];
	int moves3 = Integer.parseInt(third[2]);
	
	file.close();//kindly closes file for another user

	String out1 = winner1 + " " + loser1 + " " + moves1;
	String out2 = winner2 + " " + loser2 + " " + moves2;
	String out3 = winner3 + " " + loser3 + " " + moves3;
	String neat1 = winner1 + " beat " + loser1 + " in " + moves1 + " moves!";
	String neat2 = winner2 + " beat " + loser2 + " in " + moves2 + " moves!";
	String neat3 = winner3 + " beat " + loser3 + " in " + moves3 + " moves!";

	if (num >= moves3){
	    System.out.println("Sorry, you did not make it to the scoreboard. Try again and maybe one day you will!");
	}else if (num >= moves2){
	    System.out.println("Congrats, you made third place on the scoreboard. You can do better!");
	    out3 = play1 + " " + play2 + " " + num;
	    neat3 = play1 + " beat " + play2 + " in " + num  + " moves!";
	}else if (num >= moves1){
	    System.out.println("Congrats, you made second place on the scoreboard. Now go for first!");
	    out3 = out2;
	    neat3 = neat2;
	    out2 = play1 + " " + play2 + " " + num;
	    neat2 = play1 + " beat " + play2 + " in " + num + " moves!";
	}else {
	    System.out.println("Congratulations, YOU ARE FIRST!!! Challenge you friends to beat your score.");
	    out3 = out2;
	    out2 = out1;
	    neat3 = neat2;
	    neat2 = neat1;
	    out1 = play1 + " " + play2 + " " + num;
	    neat1 = play1 + " beat " + play2 + " in " + num + " moves!";
	}
	try{
	    PrintWriter outputStream = new PrintWriter("score.txt");
	    outputStream.println(out1);//stores in RAM
	    outputStream.println(out2);//stores in RAM
	    outputStream.println(out3);//stores in RAM
	    outputStream.close();//flushes data into file
	}catch (FileNotFoundException e){
	    e.printStackTrace();
	}
	
	//so people can see current score to beat!
	System.out.println("Current Scoreboard");
	System.out.println("1) " + neat1);
	System.out.println("2) " + neat2);
	System.out.println("3) " + neat3);
	
    }

    public static void main(String args[]) throws IOException{
	//HiScore yes = new HiScore("Brandon", "Bing", 30);
	//System.out.println(yes.score);
	//System.out.println(out);

    }
}
