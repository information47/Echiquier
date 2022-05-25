package fr.intech.echecs.view;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AcceuilController {
    
	
     public void play(ActionEvent event) throws IOException  {
    	 
    	 
    	 Parent tableViewParent = FXMLLoader.load(getClass().getResource("Echiquier.fxml"));
    	 
    	 Scene tableViewScene = new Scene(tableViewParent);
    	 
    	 Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	 
    	 window.setResizable(false);
    	 window.setScene(tableViewScene);
    	 window.show();
     }   
	
   
}
