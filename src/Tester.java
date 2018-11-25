import Game.*;
import SearchMethods.*;
public class Tester {

	public static void main(String[] args) throws Exception {

		char[][] InitialState = {
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' '},
								{'A', 'B', 'C', '@'}};
		
		char[][] FinalState = {
								{' ', ' ', ' ', ' '},
								{' ', 'A', ' ', ' '},
								{' ', 'B', ' ', ' '},
								{' ', 'C', ' ', '@'}};

		BlocksWorld b = new BlocksWorld(InitialState, FinalState);
		String solution;

		b.resetBoard();
		
		try {
			// System.out.println("Breadth First");
			// solution = new BreadthSearch().solveBlocksWorld(b);
			// b.printBoard();
			// System.out.println("Solution: \"" + solution + "\"");
		} catch (OutOfMemoryError e) {
			System.out.println(e.toString());
		}

		try {
			// System.out.println("Depth First");
			// solution = new DepthSearch().solveBlocksWorld(b);
			// b.printBoard();
			// System.out.println("Solution: \"" + solution + "\"");
		} catch (OutOfMemoryError e) {
			System.out.println(e.toString());
		}

		// System.out.println("Iterative Deepening Search");
		// solution = new IterativeDeepeningSearch().solveBlocksWorld(b);
		// b.printBoard();
		// System.out.println("Solution: \"" + solution + "\"");

		System.out.println("A* Search");
		solution = new AStarSearch().solveBlocksWorld(b);
		b.printBoard();
		System.out.println("Solution: \"" + solution + "\"");
	}

}
