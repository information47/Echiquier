package fr.intech.echecs.view;

import java.io.IOException;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import fr.intech.echecs.MainEchec;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TimeController {
	
	 

	    @FXML
	    private TextField player1;

	    @FXML
	    private TextField player2;

	   /* @FXML
	    private TextField hours;

	    @FXML
	    private TextField minutes;

  */


	    @FXML
	    private Button cancelButton;

	  
	    @FXML
		private void initialize() {
		 	
			//players names can be numbers, letters,_, or -.
			Pattern playersPattern = Pattern.compile("^[A-Za-z0-9_-]{0,11}$");
			
			TextFormatter player1Formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
				return playersPattern.matcher(change.getControlNewText()).matches() ? change : null;
			});
			TextFormatter player2Formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
				return playersPattern.matcher(change.getControlNewText()).matches() ? change : null;
			});
		
			player1.setTextFormatter(player1Formatter);
			player2.setTextFormatter(player2Formatter);   
		}

	    
	    
	 /*      
	   
	    public int getHours() {
			return Integer.parseInt(hours.getText());
		}
		
		public int getMinutes() {
			return Integer.parseInt(minutes.getText());
		}  
	    
	    
	    */
	    
	    
	    @FXML
	    void playgame(ActionEvent event) throws IOException {
	    	 FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(MainEchec.class.getResource("view/Echiquier.fxml"));
		    	Parent root = (Parent) loader.load();
		     EchiquierController controller = loader.getController();
		    controller.Myfunction(player1.getText(), player2.getText());
		    	
	         Scene tableViewScene = new Scene(root);

	         Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());

	         //window.setResizable(false);
	         window.setScene(tableViewScene);
	         window.setMaximized(true);
	         window.getIcons().add(new Image("./ressources/logo_iChess.png"));
		   		window.setTitle("iChess");
	         window.show();
	    
	      /*  FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainEchec.class.getResource("view/Echiquier.fxml"));
	    	Parent root = (Parent) loader.load();
	    	 EchiquierController controller = loader.getController();
	    	controller.Myfunction(player1.getText(), player2.getText(), hours.getText(), minutes.getText());
	    	
	    	Scene scene  = new Scene(root);
	    	Stage stage = new Stage();
	    	stage.setScene(scene);
	    	stage.show();
	    	*/
	    
	    	 
	    }
	 /*   @FXML
	    private void handleEditPerson() {
	      Player selectedPerson = personTable.getSelectionModel().getSelectedItem();
	        if (selectedPerson != null) {
	            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
	            if (okClicked) {
	                showPersonDetails(selectedPerson);
	            }

	        } else {
	            // Nothing selected.
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(MainEchec.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Person Selected");
	            alert.setContentText("Please select a person in the table.");

	            alert.showAndWait();
	        }
	    }
	*/
	

	  public void playtime(ActionEvent event) throws IOException { // ok timer.

	         Parent tableViewParent = FXMLLoader.load(getClass().getResource("time.fxml"));

	         Scene tableViewScene = new Scene(tableViewParent);

	         Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());

	         window.setResizable(false);
	         window.setScene(tableViewScene);
	         window.show();

	     }
	
	
	  
	  
}
