package fr.intech.echecs.view;


import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.Cell.EmptyCell;
import fr.intech.echecs.model.Cell.OccupiedCell;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import fr.intech.echecs.model.pieces.*;

public class EchiquierController {
	@FXML
	GridPane echiquier;
	Pieces test = new Knight(0, 0, Team.WHITE);
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    // eee
    private void initialize() {
    	for (int j = 0; j <= 7; j++) {
    		for(int i = 0; i <= 7; i++) {
    			if ( i == 4 && j == 1) {
    				Cell cell = new OccupiedCell(i, j, test);
    				echiquier.add(cell, i, j);
				}
    			else {
    				Cell cell = new EmptyCell(i, j);
    				echiquier.add(cell, i, j);
    			}
    		}
		}
    }
}
