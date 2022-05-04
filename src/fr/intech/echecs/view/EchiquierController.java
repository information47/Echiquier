package fr.intech.echecs.view;


import fr.intech.echecs.model.Cell;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EchiquierController {
	@FXML
	private GridPane echiquier;
	private Cell[][] grid;
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML    
    private void initialize() {
    	grid = new Cell[8][8];
    	for (int i = 0; i <= 7; i++) {
			for (int j = 0; j<= 7; j++) {
				Cell cell = new Cell(i, j, echiquier);
				//echiquier.addPiece("cavalier_noir", 0, 0);
				echiquier.add(cell, i, j);
				grid[i][j] = cell;
			}
		}
    	addPiece("tour_noir", 0, 0);
    	addPiece("tour_noir", 7, 0);
    	addPiece("tour_blanc", 0, 7);
    	addPiece("tour_blanc", 7, 7);
    	
    }
    public Pane getEchiquier() {
    	return echiquier;
    }
    
    public Cell getCell(int x, int y) {
    	if ((x <= 7) && (x >= 0) && (y <= 7) && (y >= 0)) {
			return grid[x][y];
		}
    	return null;
    }
    
	public void addPiece (String piece, int x, int y) {
		ImageView img = new ImageView();
		img.setImage(new Image("ressources/"+ piece + ".png"));
		Cell c = getCell(x, y);
		if(c != null) {
			c.getChildren().add(img);
		} else {
			System.out.println("la case n'existe pas.");
		}
		
	}
}
