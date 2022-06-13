package fr.intech.echecs.model.chessboard;

import fr.intech.echecs.model.pieces.Pieces;
import fr.intech.echecs.view.EchiquierController;
import javafx.scene.layout.Border;

public abstract class Move {
	
	private EchiquierController board;
	private Pieces MovedPiece;
	private int[] destinationCoordonate;
	
	public Move (EchiquierController board2, Pieces MovedPiece, int[] destinationCoordonate) {
		
		this.board = board2;
		this.MovedPiece = MovedPiece;
		this.destinationCoordonate = destinationCoordonate;
	}
	
	public int[] getDestinationCoordonate() {
		return this.destinationCoordonate;
	}

	public static class NormalMove extends Move{

		public NormalMove(EchiquierController board, Pieces MovedPiece, int[] destinationCoordonate) {
			super(board, MovedPiece, destinationCoordonate);
		}
		
	}
	
	public static class AttackMove extends Move{
		
		private Pieces AttackedPiece;

		public AttackMove(EchiquierController board, Pieces MovedPiece, int[] destinationCoordonate, Pieces AttackedPieces) {
			super(board, MovedPiece, destinationCoordonate);
			this.AttackedPiece = AttackedPieces;
		}
		
	}
}

