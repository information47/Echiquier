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
		
		if (turn == 0) {
			while (CellExist(PossibleDestination ) && stuck == false && nb_case <= 2 ) {
				Cell CorespondantCell = Board.GetCell(PossibleDestination);
				if (CorespondantCell.IsEmpty() != false) {
					if(CorespondantCell.GetPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleDestination,CorespondantCell.GetPiece()));
						stuck = true;
					}
					else if (CorespondantCell.GetPiece().team == this.team) {
						stuck = true;
					}
					
				}
				else {
					FinalListe.add(new NormalMove(board, this, PossibleDestination));
					PossibleDestination[1]++;
					nb_case ++;
				}
				
			}
		}
		else {
			while (CellExist(PossibleDestination ) && stuck == false && nb_case <= 1 ) {
				Cell CorespondantCell = Board.GetCell(PossibleDestination);
				if (CorespondantCell.IsEmpty() != false) {
					if(CorespondantCell.GetPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleDestination,CorespondantCell.GetPiece()));
						stuck = true;
					}
					else if (CorespondantCell.GetPiece().team == this.team) {
						stuck = true;
					}
					
				}
				else {
					FinalListe.add(new NormalMove(board, this, PossibleDestination));
					PossibleDestination[1]++;
					nb_case ++;
				}
				
			}
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
