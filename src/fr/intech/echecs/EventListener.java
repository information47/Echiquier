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
		// echiquierController.addPiece("cavalier_noir", 3, 4);
		System.out.println("la fonction moveEvent fut lancée.");
	}
}
