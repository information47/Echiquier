package fr.intech.echecs.view;

import com.google.common.eventbus.EventBus;

import fr.intech.echecs.ChessEventBus;
import fr.intech.echecs.MoveEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RootLayoutController {
	
	@FXML
	private Button button;
	

	
	@FXML
	public void move() {
		System.out.println("ok");
		ChessEventBus.emitEvent(new MoveEvent());
	}
}
