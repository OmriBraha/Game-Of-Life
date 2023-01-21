/*
 * John Conway's Game of Life
 * 
 * There are 3 possible outcomes:
 * 		Birth - A dead cell with exactly 3 alive neighbors will cause a birth in next generation. Else, the cell remains dead
 * 		Death - A live cell with 0 or 1 alive neighbors will die in next generation due to loneliness. A live cell with 4 or more alive neighbors will die in next generation due to population explosion
 * 		Existence - A live cell with 2 or 3 alive neighbors will keep existing in next generation
 * 
 * Birth, Death and Existence are taking place at the same time in all cells and creates a new life status called "Next Generation"
 */


public class matrixOfLife {
	/* Logics of the game class which includes:
	 * Boolean Matrix constructor
	 * gameOflifeRules -> method of implementing the rules above, thus updating the next generation
	 * getter for for the boolean Matrix
	 * 2D array print method -> Helper for debugging before and with GUI 
	 */
	
	
	// matrix & matrix sizes
	private final int M = 10;
	private final int N = 10;
	public int[][] board;

	// constructor of a boolean Matrix
	public matrixOfLife() {
		this.board = new int[M][N];
		
		// going thru every cell
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				// initialize every cell with 1 or 0
				this.board[i][j] = (int) (2 * (Math.random()));
			}
		}
	}

	// getter
	public int[][] getMatrix() {
		return this.board;
	}

	// updating next generation Method
	public void gameOfLifeRules() {
		
		// apply changes on this declared matrix
		int[][] future = new int[M][N]; 
		
		// going thru each cell
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				
				// initialize number of neighbors
				int aliveNeighbors = 0;
				for (int yOffset = -1; yOffset <= 1; yOffset++) {
					for (int xOffset = -1; xOffset <= 1; xOffset++) {
						// going thru all of the neighbors of each cell ( from x: -1, y: -1 to x:1, y:1 )
						if ((y + yOffset >= 0 && y + yOffset < M) && (x + xOffset >= 0 && x + xOffset < N)) {
							// add neighbor
							aliveNeighbors += board[y + yOffset][x + xOffset];
						}
					}
				}
				// remove the cell from the counted neighbors ( it was counted in previous step )
				aliveNeighbors -= board[y][x];
				
				// checking each cell with his neighbors by the rules above
				
				// DEATH by loneliness
				if ((board[y][x] == 1) && (aliveNeighbors < 2)) {
					future[y][x] = 0;
				
				// DEATH by population explosion
				} else if ((board[y][x] == 1) && (aliveNeighbors > 3)) {
					future[y][x] = 0;
				
				// BIRTH - new cell is born
				} else if ((board[y][x] == 0) && (aliveNeighbors == 3)) {
					future[y][x] = 1;
					
				// cell remains the same
				} else {
					future[y][x] = board[y][x];
				}
			}
		}
		board = future;
	}

	// standard print the matrix method for debugging
	public void printMatrix() {
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				System.out.printf(" " + this.board[y][x]);
			}
			System.out.println();
		}
	}

}
