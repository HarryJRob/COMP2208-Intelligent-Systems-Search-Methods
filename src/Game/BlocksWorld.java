package Game;
import java.util.Arrays;

public class BlocksWorld {

	private final char AGENT_REPRESENTATION = '@';
	
	private final int size;
	private final char[][] initialBoard;
	private final char[][] solution;
	private char[][] board;

	private int initialAgentX;
	private int initialAgentY;
	private int agentX;
	private int agentY;
	
	public BlocksWorld(char[][] initialBoard, char[][] solution) {
		this.size = initialBoard.length;
		this.initialBoard = initialBoard;
		this.solution = solution;
		this.board = copyBoard(initialBoard);

		for(int y = 0; y < this.size; y++) {
			for(int x = 0; x < this.size; x++) {
				if(this.board[y][x] == AGENT_REPRESENTATION) {
					agentX = x;
					agentY = y;
					initialAgentX = agentX;
					initialAgentY = agentY;
					return;
				}
			}
		}
	}
	
	private void swapChars(int destX, int destY) {
		board[agentY][agentX] = board[destY][destX];
		agentX = destX;
		agentY = destY;
		board[destY][destX] = AGENT_REPRESENTATION;
	}
	
	public boolean moveUp() {
		if(agentY != 0) {
			swapChars(agentX, agentY-1);
			return true;
		}
		return false;
	}
	
	public boolean moveRight() {
		if(agentX != size-1) {
			swapChars(agentX+1, agentY);
			return true;
		}
		return false;
	}
	
	public boolean moveDown() {
		if(agentY != size-1) {
			swapChars(agentX, agentY+1);
			return true;
		}
		return false;
	}
	
	public boolean moveLeft() {
		if(agentX != 0) {
			swapChars(agentX-1, agentY);
			return true;
		}
		return false;
	}
	
	public void printBoard() {
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				System.out.print("|" + board[y][x]);
			}
			System.out.println('|');
		}
	}

	public boolean isComplete() {
		board[agentY][agentX] = ' ';
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				if(board[y][x] != solution[y][x]) {
					board[agentY][agentX] = '@';
					return false;
				}
			}
		}
		board[agentX][agentY] = '@';
		return true;
	}

	public void resetBoard() {
		agentX = initialAgentX;
		agentY = initialAgentY;
		this.board = copyBoard(initialBoard);
	}

	private char[][] copyBoard(char[][] original) {
		final char[][] result = new char[original.length][];
		for(int i = 0; i < original.length; i++) {
			result[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return result;
	}
}
