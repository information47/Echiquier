package fr.intech.echecs.model.pieces;

import java.util.List;

import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.view.EchiquierController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Pieces extends ImageView {
	
	protected int x;
	protected int y;
	protected Type type;
	protected Team team;
	protected ImageView image;
	
	public Pieces (int x, int y, Team team, Type type) {
		this.x = x;
		this.y = y;
		this.team = team;
		this.type =  type;
		this.setImage(new Image("ressources/"+this.type+ this.team +".png"));
		
	}
	public abstract void SetMoved(boolean moved) ;
	
	public abstract List<Move> legal_move (EchiquierController board);
	
	public Team GetTeam() {
		return this.team;
		
	};
	
	public int GetterX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x ;
	}
	public void setY(int y) {
		this.y = y ;
	}
	
	
	
	public int GetterY() {
		return this.y;
	}
	
	public Type getType() {
		return this.type;
	}
	
	
	public boolean CellExist(int[] Coordinate) {
		for (int i : Coordinate) {
			if (i < 0 || i > 7) {
				return false;
			}
		}
		return true;
	};

}
