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
				BreadthSearch bfs = new BreadthSearch();

				long currentTime = System.currentTimeMillis();
				solution = bfs.solveBlocksWorld(b);
				long finishTime = System.currentTimeMillis();

				b.printBoard();
				System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Expanded: " + bfs.getNumNodesExpanded());
			} catch (OutOfMemoryError e) {
				System.out.println(e.toString());
			}
		}

		if(doDFS) {
			try {
				System.out.println("Depth First");
				DepthSearch dfs = new DepthSearch();

				long currentTime = System.currentTimeMillis();
				solution = dfs.solveBlocksWorld(b);
				long finishTime = System.currentTimeMillis();

				b.printBoard();
				System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Expanded: " + dfs.getNumNodesExpanded());
			} catch (OutOfMemoryError e) {
				System.out.println(e.toString());
			}
		}

		if(doIDS) {
			System.out.println("Iterative Deepening Search");
			IterativeDeepeningSearch ids = new IterativeDeepeningSearch();

			long currentTime = System.currentTimeMillis();
			solution = ids.solveBlocksWorld(b);
			long finishTime = System.currentTimeMillis();

			b.printBoard();
			System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Expanded: " + ids.getNumNodesExpanded());
		}

		if(doAStar) {
			System.out.println("A* Search");
			AStarSearch ass = new AStarSearch(); 

			long currentTime = System.currentTimeMillis();
			solution = ass.solveBlocksWorld(b);
			long finishTime = System.currentTimeMillis();

			b.printBoard();
			System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Expanded: " + ass.getNumNodesExpanded());
		}
	}

}
