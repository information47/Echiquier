package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;

public class Pawn extends Pieces {
	
	private Type type;
	
	public Pawn(int x, int y, Team team) {
		super(x, y, team);
		this.type = Type.PAWN;
	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalListe = new ArrayList<Move>();
		int possibleX = this.x;
		int possibleY = this.y;
		int[] PossibleDestination = {possibleX, possibleY};
		Boolean stuck = false;
		
		
		return null;
	}

}
