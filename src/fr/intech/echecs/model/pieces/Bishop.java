package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;

public class Bishop extends Pieces {
	
	private Type type;

	public Bishop(int x, int y, Team team) {
		super(x, y, team);
		this.type = Type.BISHOP;
	}
	
	public Type GetType () {
		return this.type;
		
	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalListe = new ArrayList<Move>();
		int possibleX = this.x;
		int possibleY = this.y;
		int[] PossibleDestination = {possibleX, possibleY};
		
		while (CellExist(PossibleDestination)) {
			Cell CorespondantCell = Board.getCell(PossibleDestination);
			if (CorespondantCell.isEmpty() != false) {
				//  if()
			}
			
		}
			
		
		return null;
	}

}
