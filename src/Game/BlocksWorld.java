package Game;
import java.util.List;

public class BlocksWorld {

	private final char AGENT_REPRESENTATION = '@';
	private final char TILE_REPRESENTATION = 'T';
	
	private final int size;
	private Character[][] board;
	private Character[][] solution;
	private int agentX;
	private int agentY;
	
	public BlocksWorld(Character[][] board, Character[][] solution) {
		this.size = board.length;
		this.board = board;
		this.solution = solution;
		for(int y = 0; y < this.size; y++) {
			for(int x = 0; x < this.size; x++) {
				if(this.board[y][x] == AGENT_REPRESENTATION) {
					agentX = x;
					agentY = y;
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
}
