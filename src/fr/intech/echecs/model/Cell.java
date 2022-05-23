package fr.intech.echecs.model;

import fr.intech.echecs.model.pieces.Pieces;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
	private int x;
	private int y;
	private Pieces pieceOnCell;
	
	public Cell (int x, int y, Pieces pieceOnCell, GridPane echiquier) {
		this.x = x;
		this.y = y;
		this.pieceOnCell = pieceOnCell;
		
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
	
	public Pieces GetPiece() {
		return this.pieceOnCell;
	}
	
	public Boolean IsEmpty() {
		if ( this.pieceOnCell == null ) {
			return true;			
		} else {
			return false;
		}
	}
	
	public Pieces getPiece() {
		if ( this.IsEmpty() == false ) {
			return this.pieceOnCell;
		} else {
			return null;
		}
	}
}

