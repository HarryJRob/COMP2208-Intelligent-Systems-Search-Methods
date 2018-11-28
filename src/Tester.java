import Game.*;
import SearchMethods.*;

public class Tester {

	public static void main(String[] args) throws Exception {

		//Debug Variables
		boolean doBFS = true;
		boolean doDFS = true;
		boolean doIDS = true;
		boolean doAStar = true;

		int problemNum = 1;

		char[][] initialState = null;
		char[][] finalState = null;

		if(problemNum == 1) {
			initialState = new char[][] {
				{' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' '},
				{'A', 'B', 'C', '@'}};

			finalState = new char[][] {
				{' ', ' ', ' ', ' '},
				{' ', 'A', ' ', ' '},
				{' ', 'B', ' ', ' '},
				{' ', 'C', ' ', ' '}};
		}
		else if(problemNum == 2) {
			initialState = new char[][] {
				{'A', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', '@'}};

			finalState = new char[][] {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', 'A'}};
		}
		else if(problemNum == 3) {
			initialState = new char[][] {
				{'A', ' ', ' '},
				{' ', '@', ' '},
				{' ', ' ', 'B'}};

			finalState = new char[][] {
				{'B', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', 'A'}};
		}
		else if(problemNum == 4) {
			initialState = new char[][] {
				{'A', ' '},
				{' ', '@'}};

			finalState = new char[][] {
				{' ', ' '},
				{' ', 'A'}};
		}
		else if(problemNum == 5) {
			initialState = new char[][] {
				{'A', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', '@'}};

			finalState = new char[][] {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', 'A'}};
		}
		else if(problemNum == 6) {
			initialState = new char[][] {
				{'A', ' ', ' ', ' '},
				{' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' '},
				{' ', ' ', ' ', '@'}};

			finalState = new char[][] {
				{' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' '},
				{' ', ' ', ' ', 'A'}};
		}
		else if(problemNum == 7) {
			initialState = new char[][] {
				{'A', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', '@'}};

			finalState = new char[][] {
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', 'A'}};
		} else {
			throw new Error("Invalid Problem Selected");
		}

		BlocksWorld b = new BlocksWorld(initialState, finalState);
		String solution;

		b.resetBoard();
		
		if(doBFS) {
			try {
				System.out.println("Breadth First Output");
				BreadthSearch bfs = new BreadthSearch();

				long currentTime = System.currentTimeMillis();
				solution = bfs.solveBlocksWorld(b);
				long finishTime = System.currentTimeMillis();

				b.printBoard();
				System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Examined: " + bfs.getNumNodesTested() +",\nMax Number of Nodes Stored: " + bfs.getMaxNumNodesStored());
			} catch (OutOfMemoryError e) {
				System.out.println(e.toString());
			}
		}

		if(doDFS) {
			try {
				System.out.println("Depth First Output");
				DepthSearch dfs = new DepthSearch();

				long currentTime = System.currentTimeMillis();
				solution = dfs.solveBlocksWorld(b);
				long finishTime = System.currentTimeMillis();

				b.printBoard();
				System.out.println("Solution Length: " + solution.length() + " characters, \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Examined: " + dfs.getNumNodesTested() +",\nMax Number of Nodes Stored: " + dfs.getMaxNumNodesStored());
			} catch (OutOfMemoryError e) {
				System.out.println(e.toString());
			}
		}

		if(doIDS) {
			System.out.println("Iterative Deepening Search Output");
			IterativeDeepeningSearch ids = new IterativeDeepeningSearch();

			long currentTime = System.currentTimeMillis();
			solution = ids.solveBlocksWorld(b);
			long finishTime = System.currentTimeMillis();

			b.printBoard();
			System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Examined: " + ids.getNumNodesTested()  +",\nMax Number of Nodes Stored: " + ids.getMaxNumNodesStored());
		}

		if(doAStar) {
			System.out.println("A* Search Output");
			AStarSearch ass = new AStarSearch(); 

			long currentTime = System.currentTimeMillis();
			solution = ass.solveBlocksWorld(b);
			long finishTime = System.currentTimeMillis();

			b.printBoard();
			System.out.println("Solution: \"" + solution + "\", \nTime Taken: " + (finishTime - currentTime) + " ms,\nNodes Examined: " + ass.getNumNodesTested()  +",\nMax Number of Nodes Stored: " + ass.getMaxNumNodesStored());
		}
	}

}
