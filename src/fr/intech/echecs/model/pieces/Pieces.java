package fr.intech.echecs.model.pieces;

import java.util.List;

import fr.intech.echecs.model.chessboard.Board;
import fr.intech.echecs.model.chessboard.Move;
import javafx.scene.image.ImageView;

public abstract class Pieces {
	
	protected int x;
	protected int y;
	protected Team team;
	protected ImageView image;
	
	public Pieces (int x, int y, Team team) {
		this.x = x;
		this.y = y;
		this.team = team;
		
	}
	
	public abstract List<Move> legal_move (Board board);
	
	public Team GetTeam() {
		return this.team;
		
	};
	
	public boolean CellExist(int[] Coordinate) {
		for (int i : Coordinate) {
			if (i < 0 || i > 7) {
				return false;
			}
		}
		return true;
	};

}
