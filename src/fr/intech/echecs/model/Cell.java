package fr.intech.echecs.model;

import java.net.URL;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
	private int x;
	private int y;
	private GridPane echiquier;
	
	public Cell (int x, int y, GridPane echiquier) {
		this.x = x;
		this.y = y;
		this.echiquier = echiquier;
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

	
	public Node getCell (int x, int y) {
		Node node = this.echiquier.getChildren().get(x*8+y);
		return node;
	}
}
