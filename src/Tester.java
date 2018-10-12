
public class Tester {

	public static void main(String[] args) throws Exception {
		
		Character[][] board = { 
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{'A', 'B', 'C', '@'}};
		
		BlocksWorld b = new BlocksWorld(board);
		b.printBoard();
		
		
	}

}
