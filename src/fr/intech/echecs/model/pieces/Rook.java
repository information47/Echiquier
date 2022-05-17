package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;

public class Rook extends Pieces {
	
	private Type type;
	public Rook(int x, int y, Team team) {
		super(x, y, team);
		this.type = Type.ROOK;

	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalListe = new ArrayList<Move>();
		int possibleX = this.x;
		int possibleY = this.y;
		int[] PossibleDestination = {possibleX, possibleY};
		Boolean stuck = false;
		
		//droite
		while (CellExist(PossibleDestination ) && stuck == false ) {     // Tant que la case existe
			Cell CorespondantCell = Board.GetCell(PossibleDestination);
			if (CorespondantCell.IsEmpty() != false) {   				// la case est vide ?
				if(CorespondantCell.GetPiece().team != this.team) {
					FinalListe.add(new AttackMove(board, this, PossibleDestination,CorespondantCell.GetPiece())); 
					stuck = true;             // Team adverse on ajoute une attque
				}
				else if (CorespondantCell.GetPiece().team == this.team) {
					stuck = true;			// même team on est bloqué
				}
				
			}
			else {
				FinalListe.add(new NormalMove(board, this, PossibleDestination));
				PossibleDestination[1]++;       // On ajoute la case au moove possible et on passe à la case suivante
			}
			
		}
		// bas
		while (CellExist(PossibleDestination ) && stuck == false ) {
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
				PossibleDestination[1]--;
			}
			
		}
		//gauche
		while (CellExist(PossibleDestination ) && stuck == false ) {
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
				PossibleDestination[0]--;
			}
			
		}
		//haut
		while (CellExist(PossibleDestination ) && stuck == false ) {
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
			}
			
		}	
		return FinalListe;
	}

}
