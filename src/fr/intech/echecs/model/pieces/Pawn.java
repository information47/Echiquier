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
	
	private int turn;
	private static int[][] possibleMove_1_xy = {{1,2},{0,1},{0,2},{-1,2}};
	private static int[][] possibleMove_2_xy = {{1,2},{0,1},{-1,2}};
	private static int[][] possibleMove_1_xy_B = {{1,-2},{0,-1},{0,-2},{-1,-2}};
	private static int[][] possibleMove_2_xy_B = {{1,-2},{0,-1},{-1,-2}};
	
	public Pawn(int x, int y, Team team, Type type) {
		super(x, y, team, type);

		this.turn = 0;
		
		
		
	}

	@Override
	public List<Move> legal_move(EchiquierController board) {
		List<Move> FinalListe = new ArrayList<Move>();
		if(this.team == team.BLACK) {
			if(turn == 0) {
				for (int[] i : possibleMove_1_xy) {
					int[] PossibleDestination = {i[0]+this.x, i[1]+this.y};
					if (CellExist(PossibleDestination)) {
						Cell CorrespondingCell = board.getCell(PossibleDestination[0], PossibleDestination[1]);
						if (CorrespondingCell.IsEmpty() && i[0] == 0) {
							FinalListe.add(new NormalMove(board, this, PossibleDestination));
							
						}
						if (!CorrespondingCell.IsEmpty() && i[0] != 0) {
							FinalListe.add(new AttackMove(board, this, PossibleDestination,CorrespondingCell.GetPiece()));
						}
					}
				}
			}
			else {
				for (int[] i : possibleMove_2_xy) {
					int[] PossibleDestination = {i[0]+this.x, i[1]+this.y};
					if (CellExist(PossibleDestination)) {
						Cell CorrespondingCell = board.getCell(PossibleDestination[0], PossibleDestination[1]);
						if (CorrespondingCell.IsEmpty() && i[0] == 0) {
							FinalListe.add(new NormalMove(board, this, PossibleDestination));
							
						}
						if (!CorrespondingCell.IsEmpty() && i[0] != 0) {
							FinalListe.add(new AttackMove(board, this, PossibleDestination,CorrespondingCell.GetPiece()));
						}
					}
				}
				
			}
			return FinalListe;
		}else {
			if(turn == 0) {
				for (int[] i : possibleMove_1_xy_B) {
					int[] PossibleDestination = {i[0]+this.x, i[1]+this.y};
					if (CellExist(PossibleDestination)) {
						Cell CorrespondingCell = board.getCell(PossibleDestination[0], PossibleDestination[1]);
						if (CorrespondingCell.IsEmpty() && i[0] == 0) {
							FinalListe.add(new NormalMove(board, this, PossibleDestination));
							
						}
						if (!CorrespondingCell.IsEmpty() && i[0] != 0) {
							FinalListe.add(new AttackMove(board, this, PossibleDestination,CorrespondingCell.GetPiece()));
						}
					}
				}
			}
			else {
				for (int[] i : possibleMove_2_xy_B) {
					int[] PossibleDestination = {i[0]+this.x, i[1]+this.y};
					if (CellExist(PossibleDestination)) {
						Cell CorrespondingCell = board.getCell(PossibleDestination[0], PossibleDestination[1]);
						if (CorrespondingCell.IsEmpty() && i[0] == 0) {
							FinalListe.add(new NormalMove(board, this, PossibleDestination));
							
						}
						if (!CorrespondingCell.IsEmpty() && i[0] != 0) {
							FinalListe.add(new AttackMove(board, this, PossibleDestination,CorrespondingCell.GetPiece()));
						}
					}
				}
				
			}
			return FinalListe;
		}
	}
	
	public int GetTurn() {
		return turn;
	}
	
	public void SetTurn(int n) {
		this.turn = this.turn + n;
	}

}
