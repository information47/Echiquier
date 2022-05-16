package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.*;

import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import javafx.scene.image.Image;

public class Knight extends Pieces {
	
	private Type type;
	private static int[][] possible_move_xy = {{-1, 2}, {1,2}, {2,-1}, {2,1},{-2,1}, {-2,-1}, {-1,-2}, {1,-2}}; // liste des opérations à faire sur les coordonnée du 
	//chevalier pour connaitre les cases atteignables
	

	public Knight(int x, int y, Team team) {
		super(x, y, team);
		this.type = Type.KNIGHT;
		this.team = team;
		if (team == Team.BLACK) {
			image.setImage(new Image("ressource/cavalier_noir.png"));	
		}
				
	}
	
	public Type GetType() {
		return this.type;
	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalList = new ArrayList<Move>();  // la liste de tout les mouvements possible
		for (int[] coordinate : possible_move_xy) {
			
			int new_x;
			int new_y;
			List<Move> LegalMove = new ArrayList<Move>();
			
			new_x = coordinate[0] + this.x;  
			new_y = coordinate[1] + this.y;
			
			int[] possible_destination = {new_x, new_y}; // on identifie les coordonnées atteignablent
			
			if ( CellExist(possible_destination)) {       // est ce que la case existe
				
				Cell corresponding_cell = Board.GetCell(possible_destination);
				
				if(!corresponding_cell.isEmpty()) { // est ce qu'elle est vide si ou on l'ajoute au mouvements possibles
					LegalMove.add(new NormalMove(board, this, possible_destination));
				}
				else {
					Pieces PieceOnCell = corresponding_cell.getPiece();  //quel pièce est dessus
					Team PieceTeam = PieceOnCell.GetTeam();     // est elle amie ou ennemie
					
					if (this.team != PieceTeam) {   //  si ennemie on l'ajoute au mouvements possibles
						LegalMove.add(new AttackMove(board, this, possible_destination, PieceOnCell));
					}	
				}		
			}
			
			FinalList = LegalMove; // finalList prend la valeur de tout les mouvements possibles
		}	
		return FinalList; // on retourne la liste de tout les mouvements possible
	}

	

	

}
