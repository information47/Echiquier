package fr.intech.echecs.view;



import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.pieces.Bishop;
import fr.intech.echecs.model.pieces.King;
import fr.intech.echecs.model.pieces.Knight;
import fr.intech.echecs.model.pieces.Pawn;
import fr.intech.echecs.model.pieces.Pieces;
import fr.intech.echecs.model.pieces.Queen;
import fr.intech.echecs.model.pieces.Rook;
import fr.intech.echecs.model.pieces.Team;
import fr.intech.echecs.model.pieces.Type;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class EchiquierController {
	@FXML
	private GridPane echiquier;
	private Cell[][] grid;
	@FXML
	private Button button1;
	
	
	@FXML
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */ 
    private void initialize() {
    	grid = new Cell[8][8];
    	for (int i = 0; i <= 7; i++) {
			for (int j = 0; j<= 7; j++) {


				Cell cell = new Cell(i, j, null, this, false);

				
				echiquier.add(cell, i, j);
				grid[i][j] = cell;
			}

		}
    	addObject(new Rook(0, 0, Team.BLACK, Type.ROOK));
    	addObject(new Rook(7,0, Team.BLACK, Type.ROOK));
    	addObject(new Knight(1,0, Team.BLACK, Type.KNIGHT));
    	addObject(new Knight(6,0, Team.BLACK, Type.KNIGHT));
    	addObject(new Bishop(5,0, Team.BLACK, Type.BISHOP));
    	addObject(new Bishop(2,0, Team.BLACK, Type.BISHOP));
    	addObject(new King(3,0, Team.BLACK, Type.KING));
    	addObject(new Queen(4, 0, Team.BLACK, Type.QUEEN));
    	addObject(new Pawn(0,1, Team.BLACK, Type.PAWN));
    	addObject(new Pawn(1,1, Team.BLACK, Type.PAWN));
    	addObject(new Pawn(2,1, Team.BLACK, Type.PAWN));
    	addObject(new Pawn(3,1, Team.BLACK, Type.PAWN));
    	addObject(new Pawn(4,1, Team.BLACK, Type.PAWN));
    	addObject(new Pawn(5,1, Team.BLACK, Type.PAWN));
    	addObject(new Pawn(6,1, Team.BLACK, Type.PAWN));
    	addObject(new Pawn(7,1, Team.BLACK, Type.PAWN));
    	
    	addObject(new Rook(0, 7, Team.WHITE, Type.ROOK));
    	addObject(new Rook(7,7, Team.WHITE, Type.ROOK));
    	addObject(new Knight(1,7, Team.WHITE, Type.KNIGHT));
    	addObject(new Knight(6,7, Team.WHITE, Type.KNIGHT));
    	addObject(new Bishop(5,7, Team.WHITE, Type.BISHOP));
    	addObject(new Bishop(2,7,Team.WHITE, Type.BISHOP));
    	addObject(new King(3,7, Team.WHITE, Type.KING));
    	addObject(new Queen(4, 7,Team.WHITE, Type.QUEEN));
    	addObject(new Pawn(0,6, Team.WHITE, Type.PAWN));
    	addObject(new Pawn(1,6, Team.WHITE, Type.PAWN));
    	addObject(new Pawn(2,6,Team.WHITE, Type.PAWN));
    	addObject(new Pawn(3,6, Team.WHITE, Type.PAWN));
    	addObject(new Pawn(4,6, Team.WHITE, Type.PAWN));
    	addObject(new Pawn(5,6,Team.WHITE, Type.PAWN));
    	addObject(new Pawn(6,6,Team.WHITE, Type.PAWN));
    	addObject(new Pawn(7,6,Team.WHITE, Type.PAWN));
    }
    
    public GridPane getEchiquier() {
    	return echiquier;
    }
    
    public Cell getCell(int x, int y) {
    	if ((x <= 7) && (x >= 0) && (y <= 7) && (y >= 0)) {
			return grid[x][y];
		}
    	return null;
    }
    
    public void addCell(int x, int y, boolean selected, Pieces piece) {
    	Cell cell = new Cell(x, y, piece, this, selected);
		echiquier.add(cell, x, y);
		grid[x][y] = cell;
		addObject(piece);
    }
	public void erase() {
		for (Cell[] Tablecell : grid) {
			for (Cell cell : Tablecell) {
				addCell(cell.GetX(), cell.GetY(), false, cell.GetPiece());
				System.out.println("test");
			}
		}
	}
	
	public void addObject (Pieces pieces) {
		Cell c = getCell(pieces.GetterX(), pieces.GetterY());
		if(c != null && c.getChildren().size() < 2) {
			c.getChildren().add(pieces);// ajoute l'image de la piece en premier plan sur la cellule 
			c.SetpieceOnCell(pieces); // ajoute une pi�ce sur la cell
		} else {
			System.out.println("impossible d'ajouter une piece sur cette case");
		}
	}
	
	public void removePiece (int x, int y) {
		Cell cell = getCell(x, y);
		if (cell.getChildren().size() == 2) {
			int lastElem = cell.getChildren().size()-1;
			cell.getChildren().remove(lastElem);
			cell.setOnMouseClicked(null);
		}
	}
	
	public Cell[][] GetGrid() {
		return this.grid;
	}
	
	
	@FXML
	public void delete() {
		removePiece(0, 0);
	}
	
}
