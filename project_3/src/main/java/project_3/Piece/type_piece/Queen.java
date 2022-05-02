package project_3.Piece.type_piece;

import project_3.Piece.Piece;
import project_3.Player.Player;
import project_3.Piece.type;

public class Queen extends Piece {
	protected type type;

	public Queen(Player Owning_player, String position ) {
		super(Owning_player, position);
		this.type = type.Queen;
	}
	
	@Override
	public void Move() {
		System.out.println("à compléter");
	}

}