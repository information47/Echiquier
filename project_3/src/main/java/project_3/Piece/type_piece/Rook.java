package main.java.project_3.Piece.type_piece;

import javafx.scene.shape.ArcType;
import main.java.project_3.Piece.Piece;
import main.java.project_3.Player.Player;
import main.java.project_3.Piece.type;

public class Rook extends Piece {
	protected ArcType type;

	public Rook(Player Owning_player, String position ) {
		super(Owning_player, position);
		this.type = ArcType.CHORD;
	}
	
	public void Move() {
		System.out.println("à compléter");
	}

}
