package fr.intech.echecs.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class vueController implements Initializable {

	
	
	
	@FXML
    private Label setplayer1;

    @FXML
    private Label setplayer2;

    @FXML
    private Label sethours;

    @FXML
    private Label setminutes;
    @FXML
    private Label sethours1;

    @FXML
    private Label setminutes1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
	public void Myfunction (String player1 ,String player2 ,String hours ,String minutes)
	{
		
		  setplayer1.setText(player1);
		  setplayer2.setText(player2);
		  sethours.setText(hours);
		  setminutes.setText(minutes);
		  sethours1.setText(hours);
		  setminutes1.setText(minutes);

		  
	}
}
