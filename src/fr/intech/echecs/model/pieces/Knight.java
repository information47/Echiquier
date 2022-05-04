package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.*;

import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;

public class Knight extends Pieces {
	
	private Type type;
	private static int[][] possible_move_xy = {{-1, 2}, {1,2}, {2,-1}, {2,1},{-2,1}, {-2,-1}, {-1,-2}, {1,-2}};
	

	public Knight(int x, int y, Team team) {
		super(x, y, team);
		this.type = Type.KNIGHT;
				
	}
	
	public Type GetType() {
		return this.type;
	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalList = new ArrayList<Move>();
		for (int[] coordinate : possible_move_xy) {
			
			int new_x;
			int new_y;
			List<Move> LegalMove = new ArrayList<Move>();
			
			new_x = coordinate[0] + this.x;
			new_y = coordinate[1] + this.y;
			
			int[] possible_destination = {new_x, new_y};
			
			if ( CellExist(possible_destination)) {
				
				Cell corresponding_cell = Board.GetCell(possible_destination);
				
				if(!corresponding_cell.IsEmpty()) {
					LegalMove.add(new Move());
				}
				else {
					Pieces PieceOnCell = corresponding_cell.GetPiece();
					Team PieceTeam = PieceOnCell.GetTeam();
					
					if (this.team != PieceTeam) {
						LegalMove.add(new Move());
					}
					
				}
				
				
			}
			
			FinalList = LegalMove;
		}
		
		
			
		return FinalList;
	}

	

	

}
