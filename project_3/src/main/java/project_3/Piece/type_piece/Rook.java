package project_3.Piece.type_piece;

import project_3.Piece.Piece;
import project_3.Player.Player;
import project_3.Piece.type;

public class Rook extends Piece {
	protected type type;

	public Rook(Player Owning_player, String position ) {
		super(Owning_player, position);
		this.type = type.Rook;
	}
	
	@Override
	public void Move() {
		System.out.println("à compléter");
	}

}
