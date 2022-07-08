package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import fr.intech.echecs.view.EchiquierController;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;


public class Pawn extends Pieces {
	
	private  boolean moved ;
	
	public Pawn(int x, int y, Team team, Type type) {
		super(x, y, team, type);

		this.moved = false;
		
		
		
	}
	@Override
	public void SetMoved(boolean moved) {
		this.moved = moved;
	}

	@Override
	public List<Move> legal_move(EchiquierController board) {
		int[] originalCoord = {this.x, this.y};
		List<Move> FinalListe = new ArrayList<Move>();
		if (this.moved == false) { // premier mouvement du pion
			if (this.team == Team.BLACK) {
				// Normal move
					// vérifie que la case juste devant le pion existe
				if (board.getCell(originalCoord[0], originalCoord[1]+1) != null) {
					// on vérifie que la case juste devant le pion est libre
					int[] PossibleDestination = {originalCoord[0], originalCoord[1]+1};
					Cell PossibleCell = board.getCell(originalCoord[0], originalCoord[1]+1);
					if (PossibleCell.getPiece() == null) {
						FinalListe.add(new NormalMove(board, this, PossibleDestination));
						// vérifie si la case d'après existe
						int[] PossibleDestionation2 = {PossibleDestination[0], PossibleDestination[1]+1};
						if (board.getCell(PossibleDestionation2[0], PossibleDestionation2[1]) != null) {
							Cell PossibleCell2 = board.getCell(PossibleDestination[0], PossibleDestination[1]+1);
							//vérifie si la case est vide
							if (PossibleCell2.getPiece() == null) {
								FinalListe.add(new NormalMove(board, this, PossibleDestionation2));
							}
						}
						
					}
				}
				// Attack Move
				int [] PossibleAttack = {this.x-1, this.y+1};
				// vérifie que la cases existent
				if (board.getCell(PossibleAttack[0], PossibleAttack[1]) != null) {
					Cell AttackCell = board.getCell(PossibleAttack[0], PossibleAttack[1]);
					if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleAttack, AttackCell.getPiece()));
					}
				}
				int [] PossibleAttack2 = {this.x+1, this.y+1};
				if (board.getCell(PossibleAttack2[0], PossibleAttack2[1]) != null) {
					Cell AttackCell = board.getCell(PossibleAttack2[0], PossibleAttack2[1]);
					if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleAttack2, AttackCell.getPiece()));
					}
				}		
			}else {
				// Normal move
				// vérifie que la case juste devant le pion existe
			if (board.getCell(originalCoord[0], originalCoord[1]-1) != null) {
				// on vérifie que la case juste devant le pion est libre
				int[] PossibleDestination = {originalCoord[0], originalCoord[1]-1};
				Cell PossibleCell = board.getCell(originalCoord[0], originalCoord[1]-1);
				if (PossibleCell.getPiece() == null) {
					FinalListe.add(new NormalMove(board, this, PossibleDestination));
					// vérifie si la case d'après existe
					int[] PossibleDestionation2 = {PossibleDestination[0], PossibleDestination[1]-1};
					if (board.getCell(PossibleDestionation2[0], PossibleDestionation2[1]) != null) {
						Cell PossibleCell2 = board.getCell(PossibleDestination[0], PossibleDestination[1]-1);
						//vérifie si la case est vide
						if (PossibleCell2.getPiece() == null) {
							FinalListe.add(new NormalMove(board, this, PossibleDestionation2));
							}
						}
					}
				}
			// Attack Move
			int [] PossibleAttack = {this.x-1, this.y-1};
			// vérifie que la cases existent
			if (board.getCell(PossibleAttack[0], PossibleAttack[1]) != null) {
				Cell AttackCell = board.getCell(PossibleAttack[0], PossibleAttack[1]);
				if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
					FinalListe.add(new AttackMove(board, this, PossibleAttack, AttackCell.getPiece()));
				}
			}
			int [] PossibleAttack2 = {this.x+1, this.y-1};
			if (board.getCell(PossibleAttack2[0], PossibleAttack2[1]) != null) {
				Cell AttackCell = board.getCell(PossibleAttack2[0], PossibleAttack2[1]);
				if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
					FinalListe.add(new AttackMove(board, this, PossibleAttack2, AttackCell.getPiece()));
				}
			}
			}
		}else {
			if (this.team == Team.BLACK) {
				// Normal move
					// vérifie que la case juste devant le pion existe
				if (board.getCell(originalCoord[0], originalCoord[1]+1) != null) {
					// on vérifie que la case juste devant le pion est libre
					int[] PossibleDestination = {originalCoord[0], originalCoord[1]+1};
					Cell PossibleCell = board.getCell(originalCoord[0], originalCoord[1]+1);
					if (PossibleCell.getPiece() == null) {
						FinalListe.add(new NormalMove(board, this, PossibleDestination));
					}
				}
				
				// Attack Move
				int [] PossibleAttack = {this.x-1, this.y+1};
				// vérifie que la cases existent
				if (board.getCell(PossibleAttack[0], PossibleAttack[1]) != null) {
					Cell AttackCell = board.getCell(PossibleAttack[0], PossibleAttack[1]);
					if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleAttack, AttackCell.getPiece()));
					}
				}
				int [] PossibleAttack2 = {this.x+1, this.y+1};
				if (board.getCell(PossibleAttack2[0], PossibleAttack2[1]) != null) {
					Cell AttackCell = board.getCell(PossibleAttack2[0], PossibleAttack2[1]);
					if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleAttack2, AttackCell.getPiece()));
					}
				}
				
			}else {
				// Normal move
				// vérifie que la case juste devant le pion existe
				if (board.getCell(originalCoord[0], originalCoord[1]-1) != null) {
					// on vérifie que la case juste devant le pion est libre
					int[] PossibleDestination = {originalCoord[0], originalCoord[1]-1};
					Cell PossibleCell = board.getCell(originalCoord[0], originalCoord[1]-1);
					if (PossibleCell.getPiece() == null) {
						FinalListe.add(new NormalMove(board, this, PossibleDestination));
						}
					}
				
				// Attack Move
				int [] PossibleAttack = {this.x-1, this.y-1};
				// vérifie que la cases existent
				if (board.getCell(PossibleAttack[0], PossibleAttack[1]) != null) {
					Cell AttackCell = board.getCell(PossibleAttack[0], PossibleAttack[1]);
					if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleAttack, AttackCell.getPiece()));
					}
				}
				int [] PossibleAttack2 = {this.x+1, this.y-1};
				if (board.getCell(PossibleAttack2[0], PossibleAttack2[1]) != null) {
					Cell AttackCell = board.getCell(PossibleAttack2[0], PossibleAttack2[1]);
					if (AttackCell.getPiece() != null && AttackCell.getPiece().team != this.team) {
						FinalListe.add(new AttackMove(board, this, PossibleAttack2, AttackCell.getPiece()));
					}
				}
				}
			}
		return FinalListe;
	}
	@Override


	public List<Move> KingLegal_Move(EchiquierController board, List<Move> allMove) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAttackMove(Move move) {
		

	}
	

}
