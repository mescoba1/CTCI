package Graphs;

public class BiggestPlus {
	boolean[][] grid;
	enum Direction {UP, DOWN, LEFT, RIGHT};
	public static void main(String[] args) {
		BiggestPlus bp = new BiggestPlus();
		long start = System.nanoTime();
		//bp.printBoard();
		int len = bp.findPlus();
		long end = System.nanoTime();
		System.out.println("Biggest Plus with a size of " + len);
		System.out.println("Took " + (end-start)/Math.pow(10,9));
		
	}
	public BiggestPlus(){
		grid = new boolean[8][8];
		initGrid();
		System.out.println("Initialized");
	}
	public void printBoard(){
		for(boolean[] row : grid){
			for(boolean cell : row){
				if(cell){
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
	public int findPlus(){
		int biggest = 0;
		for(int r = 1; r < grid.length-1; r++){
			for(int c = 1; c < grid[r].length-1; c++){
				if(grid[r][c]){
					if(grid[r+1][c] && grid[r-1][c]
							&& grid[r][c-1] && grid[r][c+1]){
						//Perform DFS
						int[] dir = new int[4];
						dir[0] = DFS(r, c, Direction.UP);
						dir[1] = DFS(r, c, Direction.DOWN);
						dir[2] = DFS(r, c, Direction.LEFT);
						dir[3] = DFS(r, c, Direction.RIGHT);
						int bottleNeck = dir[0];
						for(int d : dir){
							if(d < bottleNeck){
								bottleNeck = d;
							}
						}
						if(bottleNeck > biggest){
							biggest = bottleNeck;
						}
					}
				}
			}
			
		}
		return biggest;
	}
	public int DFS(int r, int c, Direction d){
		int count = 0, row = r, col = c;
		while(grid[row][col]){
			switch(d){
			case UP:
				row--;
				if(row < 0) return count;
				break;
			case DOWN:
				row++;
				if(row >= grid.length) return count;
				break;
			case LEFT:
				col--;
				if(col < 0) return count;
				break;
			case RIGHT:
				col++;
				if(col >= grid[0].length) return count;
				break;
			}
			count++;
		}
		return count;
	}
	public void initGrid(){
		int[][] board = {
				{0,0,0,1,0,0,0,0},
				{0,1,0,1,0,0,1,0},
				{0,0,0,1,0,0,0,0},
				{1,1,1,1,1,1,1,0},
				{0,0,0,1,0,0,1,0},
				{0,1,0,1,0,1,1,1},
				{0,0,0,1,0,0,1,0},
				{0,0,0,0,1,0,0,0}
				};
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				grid[r][c] = (board[r][c] == 1);
			}
		}
	}

}
