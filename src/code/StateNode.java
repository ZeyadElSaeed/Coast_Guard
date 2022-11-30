package code;


public class StateNode {
	Cell[][] grid;
	Agent agent;
	StateNode parent;
	String operator;
	int depth;
	int path_cost;

	public StateNode(Cell[][] grid,Agent agent, StateNode parent, String operator, int depth, int path_cost) {
		this.grid = grid;
		this.agent = agent;
		this.parent = parent;
		this.operator = operator;
		this.depth = depth;
		this.path_cost = path_cost;
	}

	public boolean isGoal() {
    	// case 1 
    	
    	
    	return endGame();
    }

	public boolean endGame() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] instanceof Ship) {
					Ship ship = (Ship) grid[i][j];
					if (!ship.isWreck() || ship.hasBlackBox()) {
						return false;
					}
				}
			}
		}
		return agent.getPassengersOnBoard()==0;
	}
	public StateNode clone() {
		//does this deep copy the grid or not?
		Cell [][] newGrid = new Cell [this.grid.length][this.grid[0].length];
		for (int i = 0; i < newGrid.length; i++) {
			for (int j = 0; j < newGrid[i].length; j++) {
				newGrid[i][j] = grid[i][j].clone();
			}
		}
		return new StateNode(
				newGrid,
				this.agent,
				this.parent,
				this.operator,
				this.depth,
				this.path_cost);
	}
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public  void visualizeGrid() {
		int col_index=0;
		String pad_space = "  ";
		System.out.print(" -1 |");
		for(int row_index=0;row_index<grid[0].length;row_index++){
			
			if(row_index>9) {
				pad_space =" ";
			}
			System.out.print("  "+row_index + pad_space+ "|");
		}
        System.out.println();
        pad_space = "  ";
		for(int i=0;i<grid.length;i++){
			if(col_index>9) {
				pad_space =" ";
			}
			System.out.print(" "+ col_index++ + pad_space+ "| ");
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
	}
	
	public String toString() {
		visualizeGrid();
		return operator +" "+ depth + " " + path_cost + " " + agent.getI() + " " + agent.getJ();
	}
	
}
