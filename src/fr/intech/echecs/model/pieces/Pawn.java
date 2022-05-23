package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;

public class Pawn extends Pieces {
	
	private int turn;
	private Type type;
	private static int[][] possibleMove_1_xy = {{1,2},{0,1},{0,2},{-1,2}};
	private static int[][] possibleMove_2_xy = {{1,2},{0,1},{-1,2}};
	
	public Pawn(int x, int y, Team team) {
		super(x, y, team);
		this.type = Type.PAWN;
		this.turn = 0;
	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalListe = new ArrayList<Move>();
		int possibleX = this.x;
		int possibleY = this.y;
		int[] PossibleDestination = {possibleX, possibleY};
		Boolean stuck = false;
		int nb_case = 0;
		if(turn == 0) {
			
		}
		return FinalListe;
	}
	
	public int GetTurn() {
		return turn;
	}
	
	public void SetTurn(int n) {
		this.turn = this.turn + n;
	}

}
