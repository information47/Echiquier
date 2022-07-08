package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import fr.intech.echecs.view.EchiquierController;

public class King extends Pieces {



	private List<Move> attackMove = new ArrayList<Move>();

	public King(int x, int y, Team team, Type type) {
		super(x, y, team, type);

	}
	@Override
	public void setAttackMove(Move move) {
		this.attackMove.add(move);
	}
	@Override
	public void clearAttackMove() {
		this.attackMove.clear();
	}
	@Override
	public void getAttackMove() {
		System.out.println(this.attackMove);
	}

	@Override
	public List<Move> legal_move(EchiquierController board) {
		List<Move> FinalList = new ArrayList<Move>();  // la liste de tout les mouvements possible
		int Xpossible;
		int Ypossible;
		// diagonal haut
		Xpossible = this.x-1;
		Ypossible = this.y-1;
		// vérifie que la case existe
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		// haut
		Xpossible = this.x;
		Ypossible = this.y-1;
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		
		// diagonal haut droit
		Xpossible = this.x+1;
		Ypossible = this.y-1;
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		// droit
		Xpossible = this.x+1;
		Ypossible = this.y;
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		
		// diagonal bas droit
		Xpossible = this.x+1;
		Ypossible = this.y+1;
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		
		// diagonal bas
		Xpossible = this.x;
		Ypossible = this.y+1;
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		
		// diagonal bas gauche
		Xpossible = this.x-1;
		Ypossible = this.y+1;
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		
		// diagonal gauche
		Xpossible = this.x-1;
		Ypossible = this.y;
		if (board.getCell(Xpossible, Ypossible) != null) {
			int[] possibleDestination = {Xpossible, Ypossible};
			Cell possibleCell = board.getCell(Xpossible, Ypossible);
			// vérifie qu'elle est vide
			if (possibleCell.getPiece() != null) {
				// vérifie si elle a la même équipe
				if (possibleCell.getPiece().team != this.team) {
					FinalList.add(new AttackMove(board, this, possibleDestination, possibleCell.getPiece()));
				}
			}
			else {
				FinalList.add(new NormalMove(board, this, possibleDestination));
			}
		}
		
		return FinalList; // on retourne la liste de tout les mouvements possible
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
