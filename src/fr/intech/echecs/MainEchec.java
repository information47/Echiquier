package fr.intech.echecs;

import java.io.IOException;

import fr.intech.echecs.model.pieces.Knight;
import fr.intech.echecs.model.pieces.Team;
import fr.intech.echecs.view.EchiquierController;
import fr.intech.echecs.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainEchec extends Application {
    
	private Stage primaryStage;
    private BorderPane rootLayout;
    private EchiquierController echiquier;
    private RootLayoutController window;
    
	@Override
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("iChess");
        // empeche le redimensionnement de la fenetre
        primaryStage.setResizable(false);
        initRootLayout();
        
        //showEchiquier();
        
        EventListener eventListener = new EventListener(echiquier, window);
        ChessEventBus.registerListener(eventListener);
        
	}
	public void initRootLayout() { //initialise la fenetre principale
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainEchec.class.getResource("view/Acceuil.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            this.window = loader.getController();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
   /* public void showEchiquier() { // montre l'echiquier dans la fenetre principale
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainEchec.class.getResource("view/Echiquier.fxml"));
            AnchorPane echiquier = (AnchorPane) loader.load();
            
            this.echiquier = loader.getController();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(echiquier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
		
	}
}
