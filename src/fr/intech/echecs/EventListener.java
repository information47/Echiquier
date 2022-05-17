package fr.intech.echecs;

import com.google.common.eventbus.Subscribe;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.view.EchiquierController;
import fr.intech.echecs.view.RootLayoutController;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EventListener {
	private EchiquierController echiquierController;
	private RootLayoutController rootLayoutController;
	private Cell cell;
	
	public EventListener (EchiquierController ec, RootLayoutController rc) {
		this.echiquierController = ec;
		this.rootLayoutController = rc;
	}
	
	@Subscribe
	public void moveEvent (MoveEvent event) {
		echiquierController.removePiece(4, 1);
		echiquierController.addPiece("pion_noir", 4, 2);

	}
	
	@Subscribe
	public void supEvent (SupEvent event) {
		echiquierController.removePiece(0, 0);
	}
	
	@Subscribe
	public void addEvent (AddEvent event) {
		echiquierController.addPiece("cavalier_noir", 3, 4);
	}
	
	@Subscribe
	public void resetEvent (ResetEvent event) {
		
		cell = echiquierController.getCell(0, 0);
		if (cell.getChildren().size() == 1) {
			echiquierController.addPiece("tour_noir", 0, 0);
		}

		cell = echiquierController.getCell(3, 4);
		if (cell.getChildren().size() == 2) {
			echiquierController.removePiece(3, 4);
		}
		
		cell = echiquierController.getCell(4, 2);
		if (cell.getChildren().size() == 2) {
			echiquierController.removePiece(4, 2);
			echiquierController.addPiece("pion_noir", 4, 1);
		}
			
	}
}
