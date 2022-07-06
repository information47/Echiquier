package fr.intech.echecs;

import java.io.IOException;

import fr.intech.echecs.view.EchiquierController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainEchec extends Application {
    
	private static Stage primaryStage;
    private BorderPane rootLayout;
    private EchiquierController echiquier;
    
	@Override
	public void start(Stage primaryStage) {
		MainEchec.primaryStage = primaryStage;
		MainEchec.primaryStage.setTitle("iChess");
        // empeche le redimensionnement de la fenetre
        primaryStage.setResizable(false);
        initRootLayout();
        
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainEchec.class.getResource("view/Echiquier.fxml"));
		echiquier = loader.getController();
        
        
        EventListener eventListener = new EventListener(echiquier);
        ChessEventBus.registerListener(eventListener);

	}
	public void initRootLayout() { //initialise la fenetre principale
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainEchec.class.getResource("view/Acceuil.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            //this.window = loader.getController();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("./ressources/logo_iChess.png"));
           primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
   /* public void showEchiquier() { // montre l'echiquier dans la fenetre principale
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainEchec.class.getResource("view/Echiquier.fxml"));
            AnchorPane echiquier = (AnchorPane) loader.load();
            
            EchiquierController ec = loader.getController();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(echiquier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */

	public static Stage getPrimaryStage() {
		return MainEchec.primaryStage;
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
