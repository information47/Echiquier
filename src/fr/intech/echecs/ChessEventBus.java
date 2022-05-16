package fr.intech.echecs;

import com.google.common.eventbus.EventBus;

public class ChessEventBus {
	private static EventBus eventBus = new EventBus();
	
	public static void registerListener(EventListener listener) {
		eventBus.register(listener);
	}
	
	public static void emitEvent(GenericEvent e) {
		eventBus.post(e);
	}
}
