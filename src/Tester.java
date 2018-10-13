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
								{' ', ' ', ' ', ' '},
								{' ', ' ', 'A', ' '},
								{' ', ' ', 'B', 'C'}};

		BlocksWorld b = new BlocksWorld(InitialState, FinalState);

		System.out.println("Breadth First");
		b.resetBoard();

		String s = new BreadthSearch().SolveBlocksWorld(b);

		System.out.println(s);
	}

}
