package fr.intech.echecs.model;

import java.util.List;

import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.pieces.Pieces;
import fr.intech.echecs.view.EchiquierController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
	private int x;
	private int y;
	private static boolean moveDisplayed;
	private Pieces pieceOnCell;
	private EchiquierController echiquier;
	private boolean selected;
	
	public Cell (int x, int y, Pieces pieceOnCell, EchiquierController echiquier, Boolean selected) {
		this.x = x;
		this.y = y;
		this.echiquier = echiquier;
		this.selected = selected;

		this.pieceOnCell = pieceOnCell;
		
		Rectangle couleur = new Rectangle(0, 0, 74, 74);

		
		if (x%2 == 1) {
			if(this.selected == true) {
				couleur.setFill(Color.GREEN);
				this.getChildren().add(couleur);
			}
			else if (y%2 == 0) {
				couleur.setFill(Color.BROWN);
				this.getChildren().add(couleur);				
			} else {
				couleur.setFill(Color.BEIGE);
				this.getChildren().add(couleur);
			}
		}  else {
			if(this.selected == true) {
				couleur.setFill(Color.GREEN);
				this.getChildren().add(couleur);
			}
			else if (y%2 == 1) {
				couleur.setFill(Color.BROWN);
				this.getChildren().add(couleur);
			}
			else {
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
	
	public void SetpieceOnCell(Pieces piece) {
		this.pieceOnCell = piece;
	}
	
	public Pieces GetPiece() {
		return this.pieceOnCell;
	}
	
	public int GetX() {
		return this.x;
	}
	
	public int GetY() {
		return this.y;
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
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	

	public void displayMove() {
		Pieces piece = this.getPiece();

		if (this.getChildren().size() == 2) {
			if(moveDisplayed == true) {
				//ne plus afficher les déplacement de la premiere piece
				System.out.println("test1");
				this.echiquier.erase();
				moveDisplayed = false;
				
				//afficher les déplacements de la seconde piece
			} else {
				System.out.println(this.x + " "+ this.y);
				System.out.println("--------");
				System.out.println(this.getPiece());
				System.out.println(this.getPiece().legal_move(echiquier));
				for (Move Move : this.getPiece().legal_move(echiquier)) {
					int [] coordonnee = Move.getDestinationCoordonate();
					this.echiquier.addCell(coordonnee[0], coordonnee[1], true, this.pieceOnCell);
				}
	
				// afficher les déplacements possibles
				moveDisplayed = true;
			}
		} else if(moveDisplayed == true) {
			// ne plus afficher les déplacements
			System.out.println("test2");
			this.echiquier.erase();
			
		}
	}
}

