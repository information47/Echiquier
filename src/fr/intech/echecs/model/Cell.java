package fr.intech.echecs.model;

import fr.intech.echecs.model.pieces.Pieces;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cell extends StackPane {
	private int x;
	private int y;
	
	public Cell (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract Boolean IsEmpty();
	public abstract Pieces GetPiece();
	
	public static class EmptyCell extends Cell{

		public EmptyCell(int x, int y) {
			super(x, y);
			Rectangle couleur = new Rectangle(0, 0, 63, 63);
			
			if (x%2 == 1) {
				if (y%2 == 0) {
					couleur.setFill(Color.BROWN);
					this.getChildren().add(couleur);				
				} else {
					couleur.setFill(Color.BEIGE);
					this.getChildren().add(couleur);
				}
			} else {
				if (y%2 == 1) {
					couleur.setFill(Color.BROWN);
					this.getChildren().add(couleur);
				} else {
					couleur.setFill(Color.BEIGE);
					this.getChildren().add(couleur);
				}
			}
		}

		@Override
		public Boolean IsEmpty() {
			return true;
		}

		@Override
		public Pieces GetPiece() {
			return null;
		}
		
	}
	
	public static class OccupiedCell extends Cell{
		
		Pieces PieceOnCell;

		public OccupiedCell(int x, int y, Pieces PieceOnCell) {
			super(x, y);
			this.PieceOnCell = PieceOnCell;
			Rectangle couleur = new Rectangle(0, 0, 63, 63);
			
			if (x%2 == 1) {
				if (y%2 == 0) {
					couleur.setFill(Color.RED);
					this.getChildren().add(couleur);				
				} else {
					couleur.setFill(Color.CRIMSON);
					this.getChildren().add(couleur);
				}
			} else {
				if (y%2 == 1) {
					couleur.setFill(Color.RED);
					this.getChildren().add(couleur);
				} else {
					couleur.setFill(Color.CRIMSON);
					this.getChildren().add(couleur);
				}
			}
		}

		@Override
		public Boolean IsEmpty() {
			return false;
		}

		@Override
		public Pieces GetPiece() {
			return this.PieceOnCell;
		}
		
	}
	
	
}


