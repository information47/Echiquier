package fr.intech.echecs.view;

import fr.intech.echecs.AddEvent;
import fr.intech.echecs.ChessEventBus;
import fr.intech.echecs.MoveEvent;
import fr.intech.echecs.ResetEvent;
import fr.intech.echecs.SupEvent;
import javafx.fxml.FXML;

public class RootLayoutController {
	

	
	@FXML
	public void move() {
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
	
	@FXML
	public void reset() {
		ChessEventBus.emitEvent(new ResetEvent());
	}
}
