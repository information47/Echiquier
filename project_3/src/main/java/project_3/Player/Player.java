package project_3.Player;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Timer;

public class Player {
	protected Team team;
	protected ArrayList<String> Mouvement_List;
	protected int player_id;
	protected int Time;

	public Player(Team team, ArrayList<String> Mouvement_List, int player_id, int Time) {
		this.team = team;
		this.Mouvement_List = Mouvement_List;
		this.player_id = player_id;
		this.Time = Time;
	}
	
	public void Chrono() {
		System.out.println("initialiser le chrono");
	}
	
	public void won_pieces() {
		System.out.println("affiche la liste des pièces gagnées");
	}

}
