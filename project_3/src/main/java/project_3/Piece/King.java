package project_3.Piece;

import project_3.Player.Player;

public class King extends Piece  {
	Type type;
	
	public King ( Player owning_player, Type type, String position) {
		super(owning_player, position);
		this.type = Type.King;
		
	}
	
	@Override
	public void Move() {
		System.out.println("se déplace d'une case autour de lui");
	}

}
