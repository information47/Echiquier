package fr.intech.echecs.model;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.pieces.Pieces;
import fr.intech.echecs.model.pieces.Team;
import fr.intech.echecs.model.pieces.Type;
import fr.intech.echecs.view.EchiquierController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
	private int x;
	private int y;
	private static boolean moveDisplayed;
	private Pieces pieceOnCell;
	private EchiquierController echiquier;
	private int[] selectedby;
	private Boolean Attacked;
	
	public Cell (int x, int y, Pieces pieceOnCell, EchiquierController echiquier, int[] selectedby) {
		this.x = x;
		this.y = y;
		this.echiquier = echiquier;
		this.selectedby = selectedby;
		this.Attacked = false;
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
		}  else {
			 if (y%2 == 1) {
				couleur.setFill(Color.BROWN);
				this.getChildren().add(couleur);
			}
			else {
				couleur.setFill(Color.BEIGE);
				this.getChildren().add(couleur);
			}
		}
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
	
	public void setSelected(int[] selected) {
		this.selectedby = selected;
	}
	
	public void setAttacked(boolean attacked) {
		this.Attacked = attacked;
	}
	

	public boolean displayMove() {
		//if(this.getPiece().GetTeam() == Team.BLACK && echiquier.getTours()%2 == 1) {
			//return false;
		//}
		int[] selectTab = {this.x, this.y};
		if (this.getChildren().size() == 2) {
			if(moveDisplayed == true) {
				// affiche les mouvements de la deuxieme piece
				if (this.Attacked == true) {
					Cell newCell = this.echiquier.getCell(selectTab[0], selectTab[1]);
					Cell originalCell = this.echiquier.getCell(this.selectedby[0], this.selectedby[1]); // erreur a cette ligne lors de deplacement avec la dame noir
					Pieces originalPiece = originalCell.getPiece();
					this.echiquier.AttackMove(originalPiece, originalCell, newCell);
					this.Attacked = false;
					this.selectedby = null;
					echiquier.incrementTours();
				}
				
				//ne plus afficher les déplacement de la premiere piece
				this.echiquier.displayBack(this.echiquier.GetGrid());
				moveDisplayed = false;
			} else {
				// afficher les déplacements possibles
				if (this.getPiece().getType() == Type.KING) {
					
				}
				else {
					if (this.getPiece().legal_move(echiquier).size() == 0 && this.getPiece() != null) {
						this.echiquier.displayOrange(this.x, this.y);
					}
					else {
						for (Move move : this.getPiece().legal_move(echiquier)) {
							int [] coordonnee = move.getDestinationCoordonate();
							int[] select = {this.x, this.y};
							this.echiquier.displayGreen(coordonnee[0], coordonnee[1], select, move);
						}
					}
				}
				moveDisplayed = true;
			}
		} else if(moveDisplayed == true) {
			// déplace la pièce lorsque l'on clique sur les cases vertes
			Cell newCell = this.echiquier.getCell(selectTab[0], selectTab[1]);
			Cell originalCell = this.echiquier.getCell(this.selectedby[0], this.selectedby[1]);
			Pieces originalPiece = originalCell.getPiece();
			if(newCell.getChildren().size()<2) {
				this.echiquier.NormalMove(originalPiece, originalCell, newCell);
			} else {
				this.echiquier.AttackMove(originalPiece, originalCell, newCell);
			}
			// efface les déplacements possibles
			this.echiquier.displayBack(this.echiquier.GetGrid());
			this.selectedby= null;

			
			// passe au tour suivant
			echiquier.incrementTours();
			
		}
		return true;
	}
}

