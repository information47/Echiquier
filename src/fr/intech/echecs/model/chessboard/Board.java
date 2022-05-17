package fr.intech.echecs.model.chessboard;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.pieces.Pieces;

public class Board {
	private Cell[][] grid;
	
	
	public Board () {
		grid = new Cell[8][8];
	}
	
	public Cell getCell(int x, int y) {
		return grid[x][y];
	}
	
	public void addPiece (int x, int y, Pieces piece) {
		
		// this.grid[x][y] = ;
	}
}