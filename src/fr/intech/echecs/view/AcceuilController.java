package fr.intech.echecs.view;



import java.io.IOException;

import fr.intech.echecs.MainEchec;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AcceuilController {
    
	
     public void play(ActionEvent event) throws IOException  { // affiche l'echiquier.
 		
    /*	 Parent tableViewParent = FXMLLoader.load(getClass().getResource("echiquier.fxml"));
    	 
    	 Scene tableViewScene = new Scene(tableViewParent);
    	 
    	 Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	 
    	 window.setResizable(true);
    	 window.setScene(tableViewScene);
    	 window.show();
    	 window.setMaximized(true);  */

	        FXMLLoader loader = new FXMLLoader();
       loader.setLocation(MainEchec.class.getResource("view/time.fxml"));
	    	Parent root = (Parent) loader.load();
	  
	    	
	    	Scene scene  = new Scene(root);
	    	Stage stage = new Stage();
	    	stage.getIcons().add(new Image("./ressources/logo_iChess.png"));
		   	stage.setTitle("iChess");
	    	stage.setScene(scene);
	    	stage.show();

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


