package fr.intech.echecs.model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
	private int x;
	private int y;
	
	public Cell (int x, int y) {
		this.x = x;
		this.y = y;
		Rectangle couleur = new Rectangle(0, 0, 63, 63);
		
		if (x%2 == 1) {
			if (y%2 == 0) {
				couleur.setFill(Color.BROWN);
				this.getChildren().add(couleur);				
			} else {
				couleur.setFill(Color.BEIGE);
				this.getChildren().add(couleur);
			}
		} else {
			if (y%2 == 1) {
				couleur.setFill(Color.BROWN);
				this.getChildren().add(couleur);
			} else {
				couleur.setFill(Color.BEIGE);
				this.getChildren().add(couleur);
			}
		}
	}
}
