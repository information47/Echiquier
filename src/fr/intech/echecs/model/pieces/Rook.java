package fr.intech.echecs.model.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;



public class Rook  extends Pieces{

	  private Type type;
	

	public Rook(int x, int y, Team team) {
		super(x, y, team);
		this.type = Type.ROOK;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Move> legal_move(Board board) {
		List<Move> FinalList = new ArrayList<Move>();  // la liste de tout les mouvements possible

		int possibleX = this.x;
		int possibleY = this.y;
		int[] PossibleDestination = {possibleX, possibleY};
  
			 while(CellExist(PossibleDestination))
			 {
				 
			 }

 
		
	

		
		return null;
		}
	
 

}
