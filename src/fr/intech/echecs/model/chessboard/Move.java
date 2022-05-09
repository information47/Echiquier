package fr.intech.echecs.model.chessboard;

import fr.intech.echecs.model.pieces.Pieces;
import javafx.scene.layout.Border;

public abstract class Move {
	
	private Board board;
	private Pieces MovedPiece;
	private int[] destinationCoordonate;
	
	public Move (Board board, Pieces MovedPiece, int[] destinationCoordonate) {
		
		this.board = board;
		this.MovedPiece = MovedPiece;
		this.destinationCoordonate = destinationCoordonate;
	}

	public static class NormalMove extends Move{

		public NormalMove(Board board, Pieces MovedPiece, int[] destinationCoordonate) {
			super(board, MovedPiece, destinationCoordonate);
		}
		
	}
	
	public static class AttackMove extends Move{
		
		private Pieces AttackedPiece;

		public AttackMove(Board board, Pieces MovedPiece, int[] destinationCoordonate, Pieces AttackedPieces) {
			super(board, MovedPiece, destinationCoordonate);
			this.AttackedPiece = AttackedPieces;
		}
		
	}
}

