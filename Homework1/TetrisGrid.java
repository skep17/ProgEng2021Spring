//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for(int y = grid[0].length - 1; y >= 0; y--){
			int count = 0;
			for(int x = 0; x < grid.length; x++){
				if(grid[x][y]) count++;
			}
			if(count == grid.length) shifting(y);
		}
	}

	/**
	 * Shifts everything down with one row
	 * @param k y coordinate of the row that should be eliminated
	 */
	private void shifting(int k){
		for(int y = k; y < grid[0].length - 1; y++){
			for(int x = 0; x < grid.length; x++){
				grid[x][y] = grid[x][y+1];
			}
		}
		int top = grid[0].length - 1;
		for(int x = 0; x < grid.length; x++){
			grid[x][top] = false;
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
