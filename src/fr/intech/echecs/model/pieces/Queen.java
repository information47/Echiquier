package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import fr.intech.echecs.view.EchiquierController;

public class Queen extends Pieces {
	
	public Queen(int x, int y, Team team, Type type) {
		super(x, y, team, type);
		
	}

	@Override
	public List<Move> legal_move(EchiquierController board) {
		List<Move> FinalListe = new ArrayList<Move>();
		// tour
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
		// fou 
		int Xpossible;
		int Ypossible;
		// diagonal haut gauche
		stuck = false;
		Xpossible = this.x -1;
		Ypossible = this.y -1;
		// verifier que la case existe
		while (Xpossible >= 0 && Ypossible >= 0 && stuck == false) {
			if (board.getCell(Xpossible, Ypossible) != null) {
				int [] possibleDestination = {Xpossible,Ypossible};
				Cell possibleCell = board.getCell(Xpossible, Ypossible);
				// verifier que la case est vide
				if (possibleCell.getPiece() != null) {
					// verifie si la piece est alliée ou ennemie
					if (this.team != possibleCell.getPiece().team) {
						FinalListe.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
						stuck = true;
						
					}
					else {
						stuck = true;
					}
				}
				else {
					FinalListe.add(new NormalMove(board, this, possibleDestination));
					Xpossible --;
					Ypossible --;
					
				}
			}
			
		}
		
		// diagonal haut droit
		stuck = false;
		Xpossible = this.x +1;
		Ypossible = this.y -1;
		// verifier que la case existe
		while (Xpossible <= 7 && Ypossible >= 0 && stuck == false) {
			if (board.getCell(Xpossible, Ypossible) != null) {
				int [] possibleDestination = {Xpossible,Ypossible};
				Cell possibleCell = board.getCell(Xpossible, Ypossible);
				// verifier que la case est vide
				if (possibleCell.getPiece() != null) {
					// verifie si la piece est alliée ou ennemie
					if (this.team != possibleCell.getPiece().team) {
						FinalListe.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
						stuck = true;
						
					}
					else {
						stuck = true;
					}
				}
				else {
					FinalListe.add(new NormalMove(board, this, possibleDestination));
					Xpossible ++;
					Ypossible --;
					
				}
			}
			
		}
		
		// diagonal bas gauche
		stuck = false;
		Xpossible = this.x -1;
		Ypossible = this.y +1;
		// verifier que la case existe
		while (Xpossible >= 0 && Ypossible <= 7 && stuck == false) {
			if (board.getCell(Xpossible, Ypossible) != null) {
				int [] possibleDestination = {Xpossible,Ypossible};
				Cell possibleCell = board.getCell(Xpossible, Ypossible);
				// verifier que la case est vide
				if (possibleCell.getPiece() != null) {
					// verifie si la piece est alliée ou ennemie
					if (this.team != possibleCell.getPiece().team) {
						FinalListe.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
						stuck = true;
						
					}
					else {
						stuck = true;
					}
				}
				else {
					FinalListe.add(new NormalMove(board, this, possibleDestination));
					Xpossible --;
					Ypossible ++;
					
				}
			}
			
		}
		// diagonal bas droit
		stuck = false;
		Xpossible = this.x +1;
		Ypossible = this.y +1;
		// verifier que la case existe
		while (Xpossible <= 7 && Ypossible <= 7 && stuck == false) {
			if (board.getCell(Xpossible, Ypossible) != null) {
				int [] possibleDestination = {Xpossible,Ypossible};
				Cell possibleCell = board.getCell(Xpossible, Ypossible);
				// verifier que la case est vide
				if (possibleCell.getPiece() != null) {
					// verifie si la piece est alliée ou ennemie
					if (this.team != possibleCell.getPiece().team) {
						FinalListe.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
						stuck = true;
						
					}
					else {
						stuck = true;
					}
				}
				else {
					FinalListe.add(new NormalMove(board, this, possibleDestination));
					Xpossible ++;
					Ypossible ++;
					
				}
			}
			
		}
		
		return FinalListe;
	}

	@Override
	public void SetMoved(boolean moved) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Move> KingLegal_Move(EchiquierController board, List<Move> allMove) {
		// TODO Auto-generated method stub
		return null;
	}

}
