package project_3.Piece;

import project_3.Player.Player;

public abstract class Piece {
	
	protected Player Owning_player;
	protected String Position;
	
	public Piece( Player owning_player, String position) {
		this.Owning_player = owning_player;
		this.Position = position;
	}
	
	
	public void Move() {
		System.out.println("abstract method need to be overlap");
	}
	
	public void is_eliminated() {
		// trouver un moyen d'éliminer la pièce	
	}
	
	public String get_position() {
		return this.Position;
	}
	
	public void set_position(String pos) {
		this.Position = pos;
	}

}
