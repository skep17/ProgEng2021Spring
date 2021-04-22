// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}


	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {

		int lx = -1; // x coordinate of top-left and bottom-left
		int rx = -1; // x coordinate of top-right and bottom-right
		int ty = -1; // y coordinate of top-left and top-right
		int by = -1; // y coordinate of bottom-left and bottom-right

		//obtaining information about the rectangle
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == ch){
					if(lx == -1) {
						lx = j;
						rx = j;
						ty = i;
						by = i;
					} else {
						if(j<lx) lx = j;
						if(j>rx) rx = j;
						if(i<ty) ty = i;
						if(i>by) by = i;
					}
				}
			}
		}
		if(lx==-1) return 0;
		return calcArea(lx,rx,ty,by); //return area by calling another function that calculates it
	}

	/**
	 * Calculates the area of given rectangle represented by following parameters
	 * @param lx x coordinate of top-left and bottom-left points
	 * @param rx x coordinate of top-right and bottom-right points
	 * @param ty y coordinate of top-left and top-right points
	 * @param by y coordinate of bottom-left and bottom-right points
	 * @return area of given rectangle
	 */
	private int calcArea(int lx, int rx, int ty, int by){
		int width = rx - lx + 1;
		int height = by - ty + 1;
		return width*height;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int result = 0;

		for(int i = 1; i < grid.length - 1; i++){
			char prev = grid[i][0];
			for(int j = 1; j < grid[i].length - 1; j++){
				if(grid[i][j] == prev){
					if(checkForPlus(j,i)) result++;
				}
				prev = grid[i][j];
			}
		}

		return result;
	}

	/**
	 * Checks if there is a plus with given point being it's center
	 * @return true if plus found, else false
	 */
	private boolean checkForPlus(int x, int y){
		int k = 1;
		char ch = grid[y][x];
		while(true){
			int count = 0;

			// checks for same characters clockwise starting from upwards
			if(y - k >= 0 && grid[y-k][x] == ch) count++;
			if(y + k < grid.length && grid[y+k][x] == ch) count++;
			if(x - k >= 0 && grid[y][x-k] == ch) count++;
			if(x + k < grid[y].length && grid[y][x+k] == ch) count++;

			if(count == 0 && k > 1){
				return true;
			} else if(count == 4) {
				k++;
			} else {
				return false;
			}
		}
	}
	
}
