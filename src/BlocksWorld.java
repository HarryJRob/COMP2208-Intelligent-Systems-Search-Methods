import java.util.List;

public class BlocksWorld {

	private final char AGENT_REPRESENTATION = '@';
	private final char TILE_REPRESENTATION = 'T';
	
	private final int size;
	private Character[][] board;
	private int agentX;
	private int agentY;
	
	public BlocksWorld(int size, int agentX, int agentY, List<Integer> tilesX, List<Integer> tilesY) throws Exception {
		//Error Checking
		if (tilesX.size() != tilesY.size() || !(agentY >= 0 && agentY < size && agentX >= 0 && agentX < size)) {
			throw new Exception("Input arguments invalid");
		}
		
		//Create the Board
		this.size = size;
		board = new Character[this.size][this.size];
		for(int curY = 0; curY < this.size; curY++) {
			for(int curX = 0; curX < this.size; curX++) {
				board[curY][curX] = ' ';
			}
		}
		
		//Create the agent
		this.agentX = agentX;
		this.agentY = agentY;
		board[this.agentY][this.agentX] = AGENT_REPRESENTATION;
		
		//Create the tiles
		for(int i = 0; i < tilesX.size(); i++) {
			int curX = tilesX.get(i);
			int curY = tilesY.get(i);
			
			if(!(curX >= 0 && curX < size && curY >= 0 && curY < size) && board[curX][curY] != ' ') {
				throw new Exception("Input tiles contain an error");
			}
			
			board[curY][curX] = TILE_REPRESENTATION;
		}
		System.out.println("Hello, World");
	}
	
	public BlocksWorld(Character[][] board) {
		this.size = board.length;
		this.board = board;
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
	
	public void swapChars(int destX, int destY) {
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
	
}
