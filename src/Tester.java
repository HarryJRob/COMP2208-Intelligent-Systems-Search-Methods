import Game.*;
public class Tester {

	public static void main(String[] args) throws Exception {
		
		Character[][] InitialState = { 
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{'A', 'B', 'C', '@'}};
		
		Character[][] FinalState = {
								{' ', ' ', ' ', ' '},
								{' ', 'A', ' ', ' '},
								{' ', 'B', ' ', ' '},
								{' ', 'C', ' ', ' '}};

		BlocksWorld b = new BlocksWorld(InitialState, FinalState);

		b.printBoard();
		b.moveUp();
		b.moveLeft();
		b.moveLeft();
		b.moveLeft();
		b.moveDown();	
		b.moveRight();
		b.moveRight();	
		b.moveUp();
		b.moveLeft();
		b.moveLeft();	
		b.moveDown();
		b.moveRight();
		b.moveRight();
		b.moveUp();
		b.moveUp();
		b.moveLeft();
		b.moveDown();
		b.moveLeft();
		b.moveUp();
		b.moveUp();
		b.moveRight();
		b.moveRight();
		b.moveDown();
		b.moveDown();
		b.moveDown();
		b.moveLeft();
		b.moveLeft();
		b.moveUp();
		b.printBoard();	

		System.out.println(b.isComplete());
		
		
	}

}
