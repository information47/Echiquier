package project_3.Piece.type_piece;

import project_3.Piece.Piece;
import project_3.Player.Player;
import project_3.Piece.type;

public class King extends Piece {
	protected type type;

	public King(Player Owning_player, String position ) {
		super(Owning_player, position);
		this.type = type.King;
	}
	
	@Override
	public void Move() {
		System.out.println("à compléter");
	}

}
