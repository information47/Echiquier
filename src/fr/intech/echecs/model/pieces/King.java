package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.AttackMove;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import fr.intech.echecs.view.EchiquierController;

public class King extends Pieces {
	
	private static int[][] possible_move_xy = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; 

	public King(int x, int y, Team team, Type type) {
		super(x, y, team, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Move> legal_move(EchiquierController board) {
		List<Move> FinalList = new ArrayList<Move>();  // la liste de tout les mouvements possible
		for (int[] coordinate : possible_move_xy) {
			
			int new_x;
			int new_y;
			List<Move> LegalMove = new ArrayList<Move>();
			
			new_x = coordinate[0] + this.x;  
			new_y = coordinate[1] + this.y;
			
			int[] possible_destination = {new_x, new_y}; // on identifie les coordonnées atteignablent
			
			if ( CellExist(possible_destination)) {       // est ce que la case existe
				
				Cell corresponding_cell = board.getCell(possible_destination[0], possible_destination[1]);
				
				if(corresponding_cell.IsEmpty()) { // est ce qu'elle est vide si ou on l'ajoute au mouvements possibles
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
