package fr.intech.echecs.view;


import fr.intech.echecs.model.Cell;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class EchiquierController {
	@FXML
	GridPane echiquier;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    // eee
    private void initialize() {
    	for (int i = 0; i <= 7; i++) {
			for (int j = 0; j<= 7; j++) {
				Cell cell = new Cell(i, j);
				echiquier.add(cell, i, j);
			}
		}
    }
}
