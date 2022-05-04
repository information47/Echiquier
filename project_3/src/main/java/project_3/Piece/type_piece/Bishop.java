package main.java.project_3.Piece.type_piece;

import main.java.project_3.Piece.type_piece;
import project_3.Player.Player;
import project_3.Piece.type;

public class Bishop extends Piece {
	protected type type;

	public Bishop(Player Owning_player, String position ) {
		super(Owning_player, position);
		this.type = type.Bishop;
	}
	
	@Override
	public void Move() {
		System.out.println("à compléter");
	}

}
