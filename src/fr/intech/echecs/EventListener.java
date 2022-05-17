package fr.intech.echecs;

import com.google.common.eventbus.Subscribe;

import fr.intech.echecs.view.EchiquierController;
import fr.intech.echecs.view.RootLayoutController;

public class EventListener {
	private EchiquierController echiquierController;
	private RootLayoutController rootLayoutController;
	
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
}
