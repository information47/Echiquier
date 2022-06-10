package fr.intech.echecs.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class endController {
	private EchiquierController echiquier;
	private String gagnant;
	@FXML
	private Label winner;
	
	@FXML
	private void initialize(){

	}
	
	public void setFields(String winner) {
		this.gagnant = winner;
		this.winner.setText(this.gagnant);
	}
}
