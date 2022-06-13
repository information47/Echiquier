package fr.intech.echecs.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EndController {
	private EchiquierController echiquier;
	private String gagnant;
	private String endMessage;
	@FXML
	private Label winner;
	
	@FXML
	private void initialize(){

	}
	
	public void setFields(String winner) {
		this.gagnant = winner;
		endMessage = "Les " + gagnant + "s" + " ont gagné !";
		this.winner.setText(endMessage);
	}
	
    public void displayAccueil(ActionEvent event) throws IOException  { // affiche l'accueil
 		
   	 Parent tableViewParent = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
   	 
   	 Scene tableViewScene = new Scene(tableViewParent);
   	 
   	 Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
   	 
   	 window.setResizable(false);
   	 window.setScene(tableViewScene);
   	 window.show();
    }
}
