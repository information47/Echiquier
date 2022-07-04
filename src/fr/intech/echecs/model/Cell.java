package fr.intech.echecs.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;

import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
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
				this.echiquier.echecBool(this.echiquier.allMove());
				if (this.pieceOnCell.getType() != Type.KING) {
					// si la piece ne peut pas se déplacer
					if (this.getPiece().legal_move(echiquier).size() == 0 && this.getPiece() != null) {
						this.echiquier.displayOrange(this.x, this.y);
					}
					// si le roi est en echec
					if (this.echiquier.echecBool(this.echiquier.allMove()) == true) {
						List<Move> legalMove = this.echiquier.LegalEchecMove(this.echiquier.echecMoove(this.echiquier.allMove()).getPiece(), this.getPiece());
						for (Move move : legalMove) {
							int [] coordonnee = move.getDestinationCoordonate();
							int[] select = {this.x, this.y};
							this.echiquier.displayGreen(coordonnee[0], coordonnee[1], select, move);
						}
					}
					else {
						for (Move move : this.getPiece().legal_move(echiquier)) {
							int [] coordonnee = move.getDestinationCoordonate();
							int[] select = {this.x, this.y};
							this.echiquier.displayGreen(coordonnee[0], coordonnee[1], select, move);
						}
					}
				}
				else {
					if (this.getPiece().legal_move(echiquier).size() == 0 && this.getPiece() != null) {
						this.echiquier.displayOrange(this.x, this.y);
					}
					else {
						List<Move> allMove = this.echiquier.allMove();
						List<Move> allAttackMove = new ArrayList<Move>();
						for (Move move : allMove) {
							if (move.getPiece().GetTeam() != this.pieceOnCell.GetTeam()) {
								allAttackMove.add(move);
							}
						}
						// affiche les déplacements du roi 
						int compteur = 0;
						for (Move move : this.pieceOnCell.legal_move(echiquier)) {
							int index ;
							int xlegal = move.getDestinationCoordonate()[0];
							int ylegal = move.getDestinationCoordonate()[1];
							index = 0;
							int size = allAttackMove.size()-1;
							while (index < size && xlegal != allAttackMove.get(index).getDestinationCoordonate()[0] 
									|| ylegal != allAttackMove.get(index).getDestinationCoordonate()[1]
									) {
								if (index == size) {
									break;
								}
								else {
									index ++;
								}
								
							}
							if (index == allAttackMove.size()-1) {
								int [] coordonnee = move.getDestinationCoordonate();
								int[] select = {this.x, this.y};
								if (this.echiquier.echecMoove(allMove) != null) {
									if (this.echiquier.echecMoove(allMove).getPiece().getType() == Type.ROOK || this.echiquier.echecMoove(allMove).getPiece().getType() == Type.QUEEN || this.echiquier.echecMoove(allMove).getPiece().getType() == Type.BISHOP) {
										if (coordonnee[0] != this.echiquier.echecMoove(allMove).getPiece().GetterX() && this.echiquier.echecMoove(allMove).getPiece().GetterY() != coordonnee[1]) {
											this.echiquier.displayGreen(coordonnee[0], coordonnee[1], select, move);
										}
									}
								}
								else {
									this.echiquier.displayGreen(coordonnee[0], coordonnee[1], select, move);
								}
								compteur ++;
							}
						}
						if (compteur == 0) {
							this.echiquier.displayOrange(this.x, this.y);
							if (this.echiquier.echecBool(this.echiquier.allMove()) == true && this.echiquier.echecMoove(allMove) == null) {
								System.out.println("echec et mat");
							}
						}
						// rock 
						
						
						if (pieceOnCell.GetTeam() == Team.WHITE ) {
							if (this.echiquier.getCell(0, 7).getPiece().getType() == Type.ROOK && this.echiquier.getCell(1, 7).getPiece() == null && this.echiquier.getCell(2, 7).getPiece() == null ) {
								int[] coord = {1,7};
								int[] select = {this.x, this.y};
								Move Rock = new NormalMove(echiquier, pieceOnCell, coord );
								this.echiquier.displayGreen(coord[0], coord[1], select, Rock);
								
								}
							if (this.echiquier.getCell(7, 7).getPiece().getType() == Type.ROOK && this.echiquier.getCell(6, 7).getPiece() == null && this.echiquier.getCell(5, 7).getPiece() == null && this.echiquier.getCell(4, 7).getPiece() == null ) {
								int[] coord = {6,7};
								int[] select = {this.x, this.y};
								Move Rock = new NormalMove(echiquier, pieceOnCell, coord );
								this.echiquier.displayGreen(coord[0], coord[1], select, Rock);
							}
						}
						else {
							
							if (this.echiquier.getCell(0, 0).getPiece().getType() == Type.ROOK && this.echiquier.getCell(1, 0).getPiece() == null && this.echiquier.getCell(2, 0).getPiece() == null ) {
								int[] coord = {1,0};
								int[] select = {this.x, this.y};
								Move Rock = new NormalMove(echiquier, pieceOnCell, coord );
								this.echiquier.displayGreen(coord[0], coord[1], select, Rock);
								
								}
							if (this.echiquier.getCell(7, 0).getPiece().getType() == Type.ROOK && this.echiquier.getCell(6, 0).getPiece() == null && this.echiquier.getCell(5, 0).getPiece() == null && this.echiquier.getCell(4, 0).getPiece() == null) {
								int[] coord = {6,0};
								int[] select = {this.x, this.y};
								Move Rock = new NormalMove(echiquier, pieceOnCell, coord );
								this.echiquier.displayGreen(coord[0], coord[1], select, Rock);
							}
							
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
			if (originalPiece.getType() == Type.KING && originalPiece.GetTeam() == Team.WHITE && newCell.GetX() == 1 || newCell.GetX() == 6 && newCell.GetY() == 7 ) {
				this.echiquier.SetRookW();
				
			}
			else if (originalPiece.getType() == Type.KING && originalPiece.GetTeam() == Team.BLACK && newCell.GetX() == 1 || newCell.GetX() == 6 && newCell.GetY() == 0) {
				this.echiquier.SetRookB();
			}
			// rock blanc
			if (this.echiquier.getRookW() == 1 && newCell.GetX() < 2 && originalPiece.getType() == Type.KING && originalPiece.GetTeam() == Team.WHITE) {
				Cell RockCell = this.echiquier.getCell(2, 7);
				this.echiquier.NormalMove(originalPiece, originalCell, RockCell);
				Cell RockRook = this.echiquier.getCell(2, 7);
				this.echiquier.NormalMove(this.echiquier.getCell(0, 7).getPiece(), this.echiquier.getCell(0, 7), RockRook);
			}

			if (this.echiquier.getRookW() == 1 && newCell.GetX() > 2 && originalPiece.getType() == Type.KING && originalPiece.GetTeam() == Team.WHITE) {
				Cell RockCell = this.echiquier.getCell(6, 7);
				this.echiquier.NormalMove(originalPiece, originalCell, RockCell);
				Cell RockRook = this.echiquier.getCell(5, 7);
				this.echiquier.NormalMove(this.echiquier.getCell(7, 7).getPiece(), this.echiquier.getCell(7, 7), RockRook);

			}
			//rock noir
			
			if (this.echiquier.getRookB() == 1 && newCell.GetX() < 2 && originalPiece.getType() == Type.KING && originalPiece.GetTeam() == Team.BLACK ) {
				Cell RockCell = this.echiquier.getCell(1, 0);
				this.echiquier.NormalMove(originalPiece, originalCell, RockCell);
				Cell RockRook = this.echiquier.getCell(2, 0);
				this.echiquier.NormalMove(this.echiquier.getCell(0, 0).getPiece(), this.echiquier.getCell(0, 0), RockRook);
			}

			if (this.echiquier.getRookB() == 1 && newCell.GetX() > 2 && originalPiece.getType() == Type.KING && originalPiece.GetTeam() == Team.BLACK) {
				Cell RockCell = this.echiquier.getCell(6, 0);
				this.echiquier.NormalMove(originalPiece, originalCell, RockCell);
				Cell RockRook = this.echiquier.getCell(5, 0);
				this.echiquier.NormalMove(this.echiquier.getCell(7, 0).getPiece(), this.echiquier.getCell(7, 0), RockRook);
			}
			
			// mouvement normaux 
			else if(newCell.getChildren().size()<2) {
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

