package fr.intech.echecs.view;

import com.google.common.eventbus.EventBus;

import fr.intech.echecs.AddEvent;
import fr.intech.echecs.ChessEventBus;
import fr.intech.echecs.MoveEvent;
import fr.intech.echecs.SupEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RootLayoutController {
	
	@FXML
	private Button button;
	private Button button2;
	

	
	@FXML
	public void move() {
		System.out.println("ok");
		ChessEventBus.emitEvent(new MoveEvent());
	}
	
	@FXML
	public void delete() {
		ChessEventBus.emitEvent(new SupEvent());
	}
	
	@FXML
	public void add() {
		ChessEventBus.emitEvent(new AddEvent());
	}
}
