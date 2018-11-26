import Game.*;
import SearchMethods.*;

public class Tester {

	public static void main(String[] args) throws Exception {

		//Debug Variables
		boolean doBFS = true;
		boolean doDFS = true;
		boolean doIDS = true;
		boolean doAStar = true;

		char[][] InitialState = {
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{'A', 'B', 'C', '@'}};
		
		char[][] FinalState = {
								{' ', ' ', ' ', ' '},
								{' ', 'A', ' ', ' '},
								{' ', 'B', ' ', ' '},
								{' ', 'C', ' ', ' '}};

		BlocksWorld b = new BlocksWorld(InitialState, FinalState);
		String solution;

		b.resetBoard();
		
		if(doBFS) {
			try {
				System.out.println("Breadth First");
				long currentTime = System.currentTimeMillis();
				solution = new BreadthSearch().solveBlocksWorld(b);
				long finishTime = System.currentTimeMillis();
				b.printBoard();
				System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms");
			} catch (OutOfMemoryError e) {
				System.out.println(e.toString());
			}
		}

		if(doDFS) {
			try {
				System.out.println("Depth First");
				long currentTime = System.currentTimeMillis();
				solution = new DepthSearch().solveBlocksWorld(b);
				long finishTime = System.currentTimeMillis();
				b.printBoard();
				System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms");
			} catch (OutOfMemoryError e) {
				System.out.println(e.toString());
			}
		}

		if(doIDS) {
			System.out.println("Iterative Deepening Search");
			long currentTime = System.currentTimeMillis();
			solution = new IterativeDeepeningSearch().solveBlocksWorld(b);
			long finishTime = System.currentTimeMillis();
			b.printBoard();
			System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms");
		}

		if(doAStar) {
			System.out.println("A* Search");
			long currentTime = System.currentTimeMillis();
			solution = new AStarSearch().solveBlocksWorld(b);
			long finishTime = System.currentTimeMillis();
			b.printBoard();
			System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms");
		}
	}

}
