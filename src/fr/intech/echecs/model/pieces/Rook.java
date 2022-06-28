package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import fr.intech.echecs.view.EchiquierController;

public class Rook extends Pieces {
	
	public Rook(int x, int y, Team team ,Type type) {
		super(x, y, team, type);


	}

	@Override
	public List<Move> legal_move(EchiquierController board) {
		List<Move> FinalListe = new ArrayList<Move>();
		int originialX = this.x;
		int originalY = this.y;
		boolean stuck = false;
		// gauche
		int Xgauche = originialX -1;
		while (stuck == false && Xgauche >= 0) {
			int[] PossibleDestination = {Xgauche, originalY};
			Cell PossibleCell = board.getCell(Xgauche, originalY);
			if(PossibleCell.getPiece() != null) {  // si il y a une pièce sur le trajet
				if (PossibleCell.getPiece().team != this.team) {
					FinalListe.add(new AttackMove(board, this, PossibleDestination, PossibleCell.getPiece()));
					stuck = true;
				}
				else {
					stuck = true;
				}
			}
			else {
				FinalListe.add(new NormalMove(board, this, PossibleDestination));
				Xgauche --;
			}
			
		}
		// droite
		stuck = false;
		
		int Xdroite;
		if (originialX < 7) {
			Xdroite = originialX +1;
		}
		else {
			Xdroite = originialX ;
		}
		while (stuck == false && Xdroite < 8) {
			int[] PossibleDestination = {Xdroite, originalY};
			Cell PossibleCell = board.getCell(Xdroite, originalY);
			if(PossibleCell.getPiece() != null) {  // si il y a une pièce sur le trajet
				if (PossibleCell.getPiece().team != this.team) {
					FinalListe.add(new AttackMove(board, this, PossibleDestination, PossibleCell.getPiece()));
					stuck = true;
				}
				else {
					stuck = true;
				}
			}
			else {
				FinalListe.add(new NormalMove(board, this, PossibleDestination));
				Xdroite ++;
			}
			
		}
		
		// haut
		stuck = false;
		int Yhaut = originalY -1;
		while (stuck == false && Yhaut >= 0) {
			int[] PossibleDestination = {originialX, Yhaut};
			Cell PossibleCell = board.getCell(originialX, Yhaut);
			if(PossibleCell.getPiece() != null) {  // si il y a une pièce sur le trajet
				if (PossibleCell.getPiece().team != this.team) {
					FinalListe.add(new AttackMove(board, this, PossibleDestination, PossibleCell.getPiece()));
					stuck = true;
				}
				else {
					stuck = true;
				}
			}
			else {
				FinalListe.add(new NormalMove(board, this, PossibleDestination));
				Yhaut --;
			}
			
		}
		// bas
		stuck = false;
		int Ybas;
		if (originalY < 7) {
			Ybas = originalY +1;
		}
		else {
			Ybas = originalY ;
		}
		while (stuck == false && Ybas <8 ) {
			int[] PossibleDestination = {originialX, Ybas};
			Cell PossibleCell = board.getCell(originialX, Ybas);
			if(PossibleCell.getPiece() != null) {  // si il y a une pièce sur le trajet
				if (PossibleCell.getPiece().team != this.team) {
					FinalListe.add(new AttackMove(board, this, PossibleDestination, PossibleCell.getPiece()));
					stuck = true;
				}
				else {
					stuck = true;
				}
			}
			else {
				FinalListe.add(new NormalMove(board, this, PossibleDestination));
				Ybas ++;
			}
			
		}
		return FinalListe;
	}

	@Override
	public void SetMoved(boolean moved) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttackMove(Move move) {
		// TODO Auto-generated method stub
		
	}

}
