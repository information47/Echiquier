package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import fr.intech.echecs.view.EchiquierController;
import javafx.scene.layout.GridPane;

public class Bishop extends Pieces {

	public Bishop(int x, int y, Team team, Type type) {
		super(x, y, team, type);
	}
	
	public Type GetType () {
		return this.type;
		
	}

	@Override
	public List<Move> legal_move(EchiquierController board) {
		List<Move> FinalListe = new ArrayList<Move>();
		
		int Xpossible;
		int Ypossible;
		boolean stuck; 
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
