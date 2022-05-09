package fr.intech.echecs.model;

import fr.intech.echecs.model.pieces.Pieces;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cell extends StackPane {
	private int x;
	private int y;
	private Pieces PieceOnCell;
	
	public Cell (int x, int y, Pieces PieceOnCell) {
		this.x = x;
		this.y = y;
		this.PieceOnCell = PieceOnCell;
	}
	
	public boolean IsEmpty() {
		return (PieceOnCell == )
	}
}


