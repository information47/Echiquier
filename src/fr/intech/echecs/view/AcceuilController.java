package fr.intech.echecs.view;



import java.io.IOException;

import fr.intech.echecs.MainEchec;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AcceuilController {
    
	
     public void play(ActionEvent event) throws IOException  { // affiche l'echiquier.
 		
    	 Parent tableViewParent = FXMLLoader.load(getClass().getResource("echiquier.fxml"));
    	 
    	 Scene tableViewScene = new Scene(tableViewParent);
    	 
    	 Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	 
    	 window.setResizable(false);
    	 window.setScene(tableViewScene);
    	 window.show();
     } 
     
     public void regles(ActionEvent event) throws IOException { //affiche les régles.

         Parent tableViewParent = FXMLLoader.load(getClass().getResource("Regles.fxml"));

         Scene tableViewScene = new Scene(tableViewParent);

         Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());

         window.setResizable(false);
         window.setScene(tableViewScene);
         window.show();

     }
     
     public void quitter(ActionEvent event) throws IOException {
         System.exit(0); 
      }  
}


