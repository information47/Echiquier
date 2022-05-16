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
    private void initialize() {
    	grid = new Cell[8][8];
    	for (int i = 0; i <= 7; i++) {
			for (int j = 0; j<= 7; j++) {


				Cell cell = new Cell(i, j, null, echiquier);
				echiquier.add(cell, i, j);
				grid[i][j] = cell;
			}

		}
    	addPiece("tour_noir", 0, 0);
    	addPiece("tour_noir", 7, 0);
    	addPiece("cavalier_noir", 1, 0);
    	addPiece("cavalier_noir", 6, 0);
    	addPiece("fou_noir", 5, 0);
    	addPiece("fou_noir", 2, 0);
    	addPiece("roi_noir", 3, 0);
    	addPiece("reine_noir", 4, 0);
    	addPiece("pion_noir", 0, 1);
    	addPiece("pion_noir", 1, 1);
    	addPiece("pion_noir", 2, 1);
    	addPiece("pion_noir", 3, 1);
    	addPiece("pion_noir", 4, 1);
    	addPiece("pion_noir", 5, 1);
    	addPiece("pion_noir", 6, 1);
    	addPiece("pion_noir", 7, 1);
    	
    	addPiece("tour_blanc", 0, 7);
    	addPiece("tour_blanc", 7, 7);
    	addPiece("cavalier_blanc", 1, 7);
    	addPiece("cavalier_blanc", 6, 7);
    	addPiece("fou_blanc", 5, 7);
    	addPiece("fou_blanc", 2, 7);
    	addPiece("roi_blanc", 3, 7);
    	addPiece("reine_blanc", 4, 7);
    	addPiece("pion_blanc", 0, 6);
    	addPiece("pion_blanc", 1, 6);
    	addPiece("pion_blanc", 2, 6);
    	addPiece("pion_blanc", 3, 6);
    	addPiece("pion_blanc", 4, 6);
    	addPiece("pion_blanc", 5, 6);
    	addPiece("pion_blanc", 6, 6);
    	addPiece("pion_blanc", 7, 6);
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
