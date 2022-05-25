package fr.intech.echecs;

import com.google.common.eventbus.Subscribe;

import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.pieces.*;
import fr.intech.echecs.model.pieces.Team;
import fr.intech.echecs.model.pieces.Type;
import fr.intech.echecs.view.EchiquierController;
import fr.intech.echecs.view.RootLayoutController;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EventListener {
	private EchiquierController echiquierController;
	private Cell cell;
	
	public EventListener (EchiquierController ec) {
		this.echiquierController = ec;
	}
	
	@Subscribe
	public void moveEvent (MoveEvent event) {
		echiquierController.removePiece(4, 1);
		echiquierController.addObject(new Pawn(4,2, Team.BLACK, Type.PAWN));

	}
	
	@Subscribe
	public void supEvent (SupEvent event) {
		echiquierController.removePiece(0, 0);
	}
	
	@Subscribe
	public void addEvent (AddEvent event) {
		echiquierController.addObject(new Knight(3,4, Team.BLACK, Type.KNIGHT));
	}
	
	@Subscribe
	public void resetEvent (ResetEvent event) {
		
		cell = echiquierController.getCell(0, 0);
		if (cell.getChildren().size() == 1) {
			echiquierController.addObject(new Rook(0,0, Team.BLACK, Type.ROOK));
		}

		cell = echiquierController.getCell(3, 4);
		if (cell.getChildren().size() == 2) {
			echiquierController.removePiece(3, 4);
		}
		
		cell = echiquierController.getCell(4, 2);
		if (cell.getChildren().size() == 2) {
			echiquierController.removePiece(4, 2);
			echiquierController.addObject(new Pawn(4,1, Team.BLACK, Type.PAWN));
		}
			
	}
	
	@Subscribe
	public void clickEvent (ClickEvent event) {
		System.out.println("afficher les deplacements possibles");
	}
	
}
