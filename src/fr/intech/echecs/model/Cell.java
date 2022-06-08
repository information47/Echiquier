package fr.intech.echecs.model;

import fr.intech.echecs.model.pieces.Pieces;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
	private int x;
	private int y;
	private boolean moveDisplayed;
	private Pieces pieceOnCell;
	private GridPane echiquier;
	
	public Cell (int x, int y, Pieces pieceOnCell, GridPane echiquier) {
		this.x = x;
		this.y = y;

		this.pieceOnCell = pieceOnCell;
		
		Rectangle couleur = new Rectangle(0, 0, 74, 74);

		
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
		this.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent t) {
            		displayMove();
            	} 
        });
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
	public void ChangeColor() {
		Rectangle couleur = new Rectangle(0, 0, 74, 74);
		couleur.setFill(Color.GREEN);
	}
	public void displayMove() {
		if (this.getChildren().size() == 2) {
			if(moveDisplayed == true) {
				//ne plus afficher les déplacement de la premiere piece
				//afficher les déplacements de la seconde piece
			} else {
				// afficher les déplacements possibles
				moveDisplayed = true;
			}
		} else if(moveDisplayed == true) {
			// ne plus afficher les déplacements
		}
	}
}

