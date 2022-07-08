package fr.intech.echecs.view;



import static javafx.animation.Animation.Status.RUNNING;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import fr.intech.echecs.MainEchec;
import fr.intech.echecs.model.Cell;
import fr.intech.echecs.model.Timer;
import fr.intech.echecs.model.Timer1;
import fr.intech.echecs.model.chessboard.Move;
import fr.intech.echecs.model.chessboard.Move.NormalMove;
import fr.intech.echecs.model.pieces.Bishop;
import fr.intech.echecs.model.pieces.King;
import fr.intech.echecs.model.pieces.Knight;
import fr.intech.echecs.model.pieces.Pawn;
import fr.intech.echecs.model.pieces.Pieces;
import fr.intech.echecs.model.pieces.Queen;
import fr.intech.echecs.model.pieces.Rook;
import fr.intech.echecs.model.pieces.Team;
import fr.intech.echecs.model.pieces.Type;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class EchiquierController {
	 
	
	
	private String gagnant = "gagnant";
	@FXML
	private GridPane echiquier;
	private Cell[][] grid;
	@FXML
	private Button button1;
	private int tours;

	private int a;
	@FXML
	private GridPane gridPriseHaut;
	@FXML
	private GridPane gridPriseBas;

	@FXML
    private Label setplayer1;

    @FXML
    private Label setplayer2;

	private int rookW;
	private int rookB;


    @FXML
    private Label sethours;

    @FXML
    private Label setminutes;
    @FXML
    private Label sethours1;

    @FXML
    private Label setminutes1;
    @FXML
    private Label setsecond;

    @FXML
    private Label setsecond1;
    
    
    Timer time = new Timer("2:30:10");
    Timer1 time1 = new Timer1("2:30:10");
    @FXML
    private Text timer;
    @FXML
    private Text timer1;
   

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                        
                        time.oneSecondPassed();
                        timer.setText(time.getCurrentTime());
            }));

    
    Timeline timeline1 = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                        
                        time1.oneSecondPassed();
                        timer1.setText(time1.getCurrentTime());
            }));
    
    
    
    
	@FXML
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */ 
	private void initialize() {
		rookW = 0;
		rookB = 0;
		tours = 1;
		grid = new Cell[8][8];
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j<= 7; j++) {


				Cell cell = new Cell(i, j, null, this, null);


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
		
		 timer.setText(time.getCurrentTime());

	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.pause();
	        
	        timer1.setText(time.getCurrentTime());

	        timeline1.setCycleCount(Timeline.INDEFINITE);
	        timeline1.play();
	        a = 1 ;
	    	
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
	
	public int getTours(){
		return tours;
	}
	
	public void incrementTours(){
		
		tours++;
	}
	
	public int getRookW() {
		return this.rookW;
	}
	public void SetRookW() {
		this.rookW++;
	}
	
	public int getRookB() {
		return this.rookB;
	}
	
	public void SetRookB() {
		this.rookB++;
	}
    

	public void addObject (Pieces pieces) {
		Cell c = getCell(pieces.GetterX(), pieces.GetterY());
		if(c != null && c.getChildren().size() < 2) {
			c.getChildren().add(pieces);// ajoute l'image de la piece en premier plan sur la cellule 
			c.SetpieceOnCell(pieces); // ajoute une pièce sur la cell
		} else {
			c.getChildren().remove(1);
			c.getChildren().add(pieces);
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

	@FXML
	public void afficherEnde() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("end.fxml"));
		
			BorderPane tableViewParent = loader.load();
			
			EndController end = loader.getController();
			end.setFields("blanc"); // donne le nom du gagnant a endController
			
			Scene scene = new Scene(tableViewParent);

			Stage primaryStage = MainEchec.getPrimaryStage();
			primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	public void afficherEnd(ActionEvent event) throws IOException {
 Parent tableViewParent = FXMLLoader.load(getClass().getResource("end.fxml"));
    	 
    	 Scene tableViewScene = new Scene(tableViewParent);
    	 
    	 Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	 
    	 //window.setResizable(false);
    	 window.setScene(tableViewScene);
    	 window.show();
	}
	
	public void displayGreen(int x, int y, int[] selectedby, Move move) {
		Rectangle couleur = new Rectangle(0, 0, 74, 74);
		Cell cell = grid[x][y];
		Rectangle couleur2 = new Rectangle(0, 0, 74, 74);
		Cell originalCell = grid[selectedby[0]][selectedby[1]];
		
		if(grid[selectedby[0]][selectedby[1]].getPiece().GetTeam() == Team.BLACK && tours%2 == 1) {
		
			
			Rectangle couleurbloque = new Rectangle(0, 0, 74, 74);
			couleurbloque.setFill(Color.RED);
			originalCell.getChildren().remove(0);
			originalCell.getChildren().add(0, couleurbloque);
			
		} else if(grid[selectedby[0]][selectedby[1]].getPiece().GetTeam() == Team.WHITE && tours%2 == 0) {
			
			
			Rectangle couleurbloque = new Rectangle(0, 0, 74, 74);
			couleurbloque.setFill(Color.RED);
			originalCell.getChildren().remove(0);
			originalCell.getChildren().add(0, couleurbloque);
		} else {
		if (move instanceof NormalMove) {
			couleur.setFill(Color.LIMEGREEN);
			cell.setAttacked(false);
		}
		else {
			couleur.setFill(Color.RED);
			cell.setAttacked(true);
		}
			couleur.setOpacity(0.5);
			cell.getChildren().remove(0);
			cell.getChildren().add(0, couleur);
			cell.setSelected(selectedby);
		// color la case sous la pièce d'origine
		couleur2.setFill(Color.LIGHTSEAGREEN);
		originalCell.getChildren().remove(0);
		originalCell.getChildren().add(0, couleur2);
		}
	}
	
	
	
	
	
	
	
	public void displayOrange(int x, int y) {
		Cell originalCell = grid[x][y];
		
		if(grid[x][y].getPiece().GetTeam() == Team.BLACK && tours%2 == 1) {
			Rectangle couleurbloque = new Rectangle(0, 0, 74, 74);
			couleurbloque.setFill(Color.RED);
			originalCell.getChildren().remove(0);
			originalCell.getChildren().add(0, couleurbloque);
		
			
			
		} else if(grid[x][y].getPiece().GetTeam() == Team.WHITE && tours%2 == 0) {
			Rectangle couleurbloque = new Rectangle(0, 0, 74, 74);
			couleurbloque.setFill(Color.RED);
			originalCell.getChildren().remove(0);
			originalCell.getChildren().add(0, couleurbloque);
			
		}else {
			Rectangle couleur = new Rectangle(0, 0, 74, 74);
			Cell cell = grid[x][y];
			couleur.setFill(Color.ORANGE);
			cell.getChildren().remove(0);
			cell.getChildren().add(0, couleur);
		}
		
		
	}
	
	
	public void displayBack(Cell[][] grid) {
		for (Cell[] cellTab : grid) {
			for (Cell cell : cellTab) {
				Rectangle couleur = new Rectangle(0, 0, 74, 74);
				if (cell.GetX()%2 == 1) {
					 if (cell.GetY() %2 == 0) {
						couleur.setFill(Color.BROWN);		
					} else {
						couleur.setFill(Color.BEIGE);
					}
				}  else {
					 if (cell.GetY() %2 == 1) {
						couleur.setFill(Color.BROWN);
						
					}
					else {
						couleur.setFill(Color.BEIGE);
					}
				}
				cell.setSelected(null);
				cell.getChildren().remove(0);
				cell.getChildren().add(0, couleur);
			}
		}
	}
	
	public void NormalMove(Pieces piece, Cell originalCell, Cell newCell) {
		
		
     if(a%2==0)
     {
    	 timeline.pause();
			timeline1.play();
    	 
     }else {
    	   timeline.play();
			timeline1.pause();
    	 
     }
		  
		
	  
		piece.setX(newCell.GetX());
		piece.setY(newCell.GetY());
		
		    
		 
		addObject(piece);
		originalCell.SetpieceOnCell(null);
		
		if (piece.getType() == Type.PAWN ) {
			piece.SetMoved(true);
		
		}
		
		
		a++ ;
	
	}
	
	public void AttackMove(Pieces piece, Cell originalCell, Cell newCell) {
		
		  if(a%2==0)
		     {
		    	 timeline.pause();
					timeline1.play();
		    	 
		     }else {
		    	   timeline.play();
					timeline1.pause();
		    	 
		     }
		  
		piece.setX(newCell.GetX());
		piece.setY(newCell.GetY());
		eaten(newCell.getPiece());
		newCell.SetpieceOnCell(piece);
		addObject(piece);
		originalCell.SetpieceOnCell(null);
		
		a++ ;
	}
	
	// ---------------------- detection echec -----------------------//
	
	// trouve les roi
	public ArrayList<int[]> FindTheKings() {
		ArrayList<int[]> FinalCoord = new ArrayList<int[]>();
		for (Cell[] cellTab : this.grid) {
			for (Cell cell : cellTab) {
				if (cell.getPiece() != null) {
					if (cell.getPiece().getType() == Type.KING && cell.getPiece().GetTeam() == Team.WHITE) {
						Pieces possiblePiece = cell.getPiece();
						int[] WhiteCoord = {possiblePiece.GetterX(), possiblePiece.GetterY()};
						FinalCoord.add(WhiteCoord);
					}
					if (cell.getPiece().getType() == Type.KING && cell.getPiece().GetTeam() == Team.BLACK) {
						Pieces possiblePiece = cell.getPiece();
						int[] BlackCoord = {possiblePiece.GetterX(), possiblePiece.GetterY()};
						FinalCoord.add(BlackCoord);
					}
				}
			}
		}
		// retourne coordonnée des rois
		// roi blanc index 1
		// roi noir index 0
		return FinalCoord; 
	}
	
	
	// verifie tout les mouvements de chaque piece sur le plateau
	public List<Move> allMove() {
		List<Move> MoveList = new ArrayList<Move>();
		for (Cell[] cellTab : this.grid) {
			for (Cell cell : cellTab) {
				if(cell.getPiece() != null) {
					Pieces piece = cell.getPiece();
					for (Move move : piece.legal_move(this)) {
						MoveList.add(move);
					}
				}
			}
		}
		return MoveList;
	}
	
	// recolte tout les attacks Moves sur le plateau
	public List<Move> allAttackMove(List<Move> allMove) {
		List<Move> MoveList = new ArrayList<Move>();
		for (Move move : allMove) {
			if (move instanceof Move.AttackMove) {
				MoveList.add(move);
			}
		}
		return MoveList;
	}
	
	// verifie si il y a echec
	public Boolean echecBool(List<Move> allMove) {
		int[] BlackKingCoord = {this.FindTheKings().get(0)[0], this.FindTheKings().get(0)[1]};
		int[] WhiteKingCoord = {this.FindTheKings().get(1)[0], this.FindTheKings().get(1)[1]};
		for (Move move : allMove) {
			Team MoveTeam = move.getTeam();
			if (MoveTeam == Team.BLACK) {
				if (move instanceof Move.AttackMove && move.getDestinationCoordonate()[0] == WhiteKingCoord[0] && move.getDestinationCoordonate()[1] == WhiteKingCoord[1]) {
					this.DisplayRed(move);
					Boolean result = true;
					return result;
				}
			}
			if (MoveTeam == Team.WHITE) {
				if (move instanceof Move.AttackMove && move.getDestinationCoordonate()[0] == BlackKingCoord[0] && move.getDestinationCoordonate()[1] == BlackKingCoord[1]) {
					this.DisplayRed(move);
					Boolean result = true;
					return result;
				}
			}
		}
		Boolean result = false;
		return result;
	}
	
	public Move echecMoove(List<Move> allMove) {

		int[] BlackKingCoord = {this.FindTheKings().get(0)[0], this.FindTheKings().get(0)[1]};
		int[] WhiteKingCoord = {this.FindTheKings().get(1)[0], this.FindTheKings().get(1)[1]};
		for (Move move : allMove) {
			Team MoveTeam = move.getTeam();
			if (MoveTeam == Team.BLACK) {
				if (move instanceof Move.AttackMove && move.getDestinationCoordonate()[0] == WhiteKingCoord[0] && move.getDestinationCoordonate()[1] == WhiteKingCoord[1]) {
					this.DisplayRed(move);

					Move result = move;
					return result;
				}
			}
			if (MoveTeam == Team.WHITE) {
				if (move instanceof Move.AttackMove && move.getDestinationCoordonate()[0] == BlackKingCoord[0] && move.getDestinationCoordonate()[1] == BlackKingCoord[1]) {
					this.DisplayRed(move);

					Move result = move;
					return result;
				}
			}
		}
		Move result = null;
		return result;
	}
	
	// met la case du roi et la piece qui le met en echecs en rouge
	public void DisplayRed(Move move) {
		int[] coordKing = move.getDestinationCoordonate();
		int[] coordPiece = {move.getPiece().GetterX(), move.getPiece().GetterY()};
		Rectangle couleurKing = new Rectangle(0, 0, 74, 74);
		Cell cellKing = grid[coordKing[0]][coordKing[1]];
		couleurKing.setFill(Color.RED);
		cellKing.getChildren().remove(0);
		cellKing.getChildren().add(0, couleurKing);
		Rectangle couleurPiece = new Rectangle(0, 0, 74, 74);
		Cell cellPiece = grid[coordPiece[0]][coordPiece[1]];
		couleurPiece.setFill(Color.RED);
		cellPiece.getChildren().remove(0);
		cellPiece.getChildren().add(0, couleurPiece);
		
	}
	

	// en cas d'echecs trouve les moves legal
	public List<Move> EchecMove(List<Move> ListMove, Move move){
		List<Move> LegalMove = new ArrayList<Move>();
		Type AttackingPiece = move.getType();
		int[] CoordAttackingPiece = {move.getPiece().GetterX(),move.getPiece().GetterY()};
		int[] CoordKing = move.getDestinationCoordonate();
		// ajoute tout les moves qui élimine l'attaquant
		for (Move testedMove : ListMove) {
			if (testedMove instanceof Move.AttackMove && testedMove.getDestinationCoordonate()[0] == CoordAttackingPiece[0] 
					&& testedMove.getDestinationCoordonate()[1] == CoordAttackingPiece[1]) {
				LegalMove.add(testedMove);
			}
			
		}
		
		
		return LegalMove;
		
	}
	public void eaten(Pieces piece) {
		if (piece.GetTeam() == Team.BLACK) {
			List<Node> childrensBlack = gridPriseBas.getChildren();
			int length = childrensBlack.size();
			if (length < 8) {
				gridPriseBas.add(piece, length, 0);
			} else {
				gridPriseBas.add(piece, length-8, 1);
			}
		} else {
			List<Node> childrensWhite = gridPriseHaut.getChildren();
			int length = childrensWhite.size();
			if (length < 8) {
				gridPriseHaut.add(piece, length, 0);
			} else {
				gridPriseHaut.add(piece, length-8, 1);
			}
		}
	}
	
	
   public void Myfunction (String player1 ,String player2 )
	{
		
		  setplayer1.setText(player1);
		  setplayer2.setText(player2);
		  
		  
	}   


	// -----------------trouve les mouvements possible en cas d'echec ----------------
	
	
	
	
	// trouve les mooves possibles
	public List<Move> LegalEchecMove (Pieces piece, Pieces DefPiece){
		List<Move> LegalMove = new ArrayList<Move>();
		Type type = piece.getType();
		List<Move> allMove = this.allMove();
		List<Move> PieceMove = DefPiece.legal_move(this);
		int[] KingCoord = this.echecMoove(allMove).getDestinationCoordonate();
		if (type == type.KNIGHT || type == type.PAWN ) {
			for (Move move : PieceMove) {
				Team AttackTeam = move.getTeam();
				if (AttackTeam != piece.GetTeam() && move.getDestinationCoordonate()[0] == piece.GetterX()
						&& move.getDestinationCoordonate()[1] == piece.GetterY() || move.getType() == type.KING ) {
					LegalMove.add(move);
				}
			}
		}
		if (type == type.ROOK) {
			
			for (Move move : PieceMove) {
				if (piece.GetterY() < KingCoord[1] && move.getDestinationCoordonate()[0] == KingCoord[0]) {
					int index = piece.GetterY();
					while (index < KingCoord[1] && index != move.getDestinationCoordonate()[1]) {
						index++;
						
					}
					if (index == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				if (piece.GetterY() > KingCoord[1] && move.getDestinationCoordonate()[0] == KingCoord[0]) {
					int index = piece.GetterY();
					while (index < KingCoord[1] && index != move.getDestinationCoordonate()[1]) {
						index--;
						
					}
					if (index == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				if (piece.GetterX() > KingCoord[0] && move.getDestinationCoordonate()[1] == KingCoord[1]) {
					int index = piece.GetterX();
					while (index < KingCoord[0] && index != move.getDestinationCoordonate()[0]) {
						index--;
						
					}
					if (index == move.getDestinationCoordonate()[0]) {
						LegalMove.add(move);
					}
				}
				if (piece.GetterX() < KingCoord[0] && move.getDestinationCoordonate()[1] == KingCoord[1]) {
					int index = piece.GetterX();
					while (index < KingCoord[0] && index != move.getDestinationCoordonate()[0]) {
						index++;
						
					}
					if (index == move.getDestinationCoordonate()[0]) {
						LegalMove.add(move);
					}
				}
				
			}
		}
		if (type == type.BISHOP) {
			for (Move move : PieceMove) {
				int moveX = move.getDestinationCoordonate()[0];
				int moveY = move.getDestinationCoordonate()[1];
				// haut gauche
				if (piece.GetterX() < KingCoord[0] && piece.GetterY() < KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while (indexX < KingCoord[0] && indexY < KingCoord[1] && indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX++;
							indexY++;
						}
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				// haut droit
				if (piece.GetterX() > KingCoord[0] && piece.GetterY() < KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while ( indexX < KingCoord[0] && indexY < KingCoord[1] && indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX--;
							indexY++;
						}
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				// bas gauche
				if (piece.GetterX() < KingCoord[0] && piece.GetterY() > KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while ( indexX < KingCoord[0] && indexY < KingCoord[1] && indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX++;
							indexY--;
						}
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				// bas droit
				if (piece.GetterX() > KingCoord[0] && piece.GetterY() > KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while ( indexX < KingCoord[0] && indexY < KingCoord[1] && indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX--;
							indexY--;
						}
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
			}
		}
		if (type == type.QUEEN) {
			
			for (Move move : PieceMove) {
				int moveX = move.getDestinationCoordonate()[0];
				int moveY = move.getDestinationCoordonate()[1];
				if (piece.GetterY() < KingCoord[1] && move.getDestinationCoordonate()[0] == KingCoord[0]) {
					int index = piece.GetterY();
					while (index < KingCoord[1] && index != move.getDestinationCoordonate()[1]) {
						index++;
						
					}
					if (index == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				if (piece.GetterY() > KingCoord[1] && move.getDestinationCoordonate()[0] == KingCoord[0]) {
					int index = piece.GetterY();
					while (index < KingCoord[1] && index != move.getDestinationCoordonate()[1]) {
						index--;
						
					}
					if (index == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				if (piece.GetterX() > KingCoord[0] && move.getDestinationCoordonate()[1] == KingCoord[1]) {
					int index = piece.GetterX();
					while (index < KingCoord[0] && index != move.getDestinationCoordonate()[0]) {
						index--;
						
					}
					if (index == move.getDestinationCoordonate()[0]) {
						LegalMove.add(move);
					}
				}
				if (piece.GetterX() < KingCoord[0] && move.getDestinationCoordonate()[1] == KingCoord[1]) {
					int index = piece.GetterX();
					while (index < KingCoord[0] && index != move.getDestinationCoordonate()[0]) {
						index++;
						
					}
					if (index == move.getDestinationCoordonate()[0]) {
						LegalMove.add(move);
					}
				}
				
				// haut gauche
				if (piece.GetterX() < KingCoord[0] && piece.GetterY() < KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while (indexX < KingCoord[0] && indexY < KingCoord[1] && indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX++;
							indexY++;
						}
						
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				// haut droit
				if (piece.GetterX() > KingCoord[0] && piece.GetterY() < KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while ( indexX < KingCoord[0] && indexY < KingCoord[1] && indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX--;
							indexY++;
						}
						
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				// bas gauche
				if (piece.GetterX() < KingCoord[0] && piece.GetterY() > KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while (indexX < KingCoord[0] && indexY < KingCoord[1] && indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX++;
							indexY--;
						}
						
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				// bas droit
				if (piece.GetterX() > KingCoord[0] && piece.GetterY() > KingCoord[1]) {
					int indexX = piece.GetterX();
					int indexY = piece.GetterY();
					while (indexX != move.getDestinationCoordonate()[0] || indexY != move.getDestinationCoordonate()[1]) {
						if (indexX < 0 || indexX > 7 || indexY < 0 || indexY > 7) {
							break;
						}
						else {
							indexX--;
							indexY--;
						}
						
					}
					if (indexX == move.getDestinationCoordonate()[0] && indexY == move.getDestinationCoordonate()[1]) {
						LegalMove.add(move);
					}
				}
				
			}
		}

		
		return LegalMove;
	}
	

}
