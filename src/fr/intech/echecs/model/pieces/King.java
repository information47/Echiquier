package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;

public class King extends Pieces {

	public King(int x, int y, Team team) {
		super(x, y, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalListe = new ArrayList<Move>();
		int possibleX = this.x;
		int possibleY = this.y;
		int[] PossibleDestination = {possibleX, possibleY};
		Boolean stuck = false;
		//droite
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
				//diagonal haut droit
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
						PossibleDestination[0]++;
						PossibleDestination[1]++;
					}
					
				}
				//diagonal bas droite
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
						PossibleDestination[0]++;
						PossibleDestination[1]--;
					}
					
				}
				//diagonal haut gauche
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
						PossibleDestination[1]++;
					}
					
				}
				//diagonal bas gauche
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
						PossibleDestination[1]--;
					}
					
				}	
		
		return FinalListe;
	}

}
