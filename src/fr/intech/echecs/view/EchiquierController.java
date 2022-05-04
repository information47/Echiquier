package fr.intech.echecs.view;


import fr.intech.echecs.model.Cell;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class EchiquierController {
	@FXML
	private GridPane echiquier;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML    
    private void initialize() {
    	for (int i = 0; i <= 7; i++) {
			for (int j = 0; j<= 7; j++) {
				Cell cell = new Cell(i, j, echiquier);
				echiquier.addPiece("cavalier_noir", 0, 0);
				echiquier.add(cell, i, j);
			}
		}
    }
    public Pane getEchiquier() {
    	return echiquier;
    }
    
    public StackPane getCell (int x, int y) {
		StackPane node = (StackPane) echiquier.getChildren().get(x*8+y);
		return node;
    }
    
	public void addPiece (String piece, int x, int y) {
		ImageView img = new ImageView();
		img.setImage(new Image("ressources/"+ piece + ".png"));
		getCell(x, y).getChildren().add(img);
		if ((x <= 7) && (x >= 0) && (y <= 7) && (y >= 0)) {
			
		}
	}
}
