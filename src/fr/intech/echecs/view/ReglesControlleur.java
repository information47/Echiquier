package fr.intech.echecs.view;

import java.io.IOException;

import fr.intech.echecs.MainEchec;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReglesControlleur {

    public void Retour(ActionEvent event) throws IOException  { // affiche l'Acceuil.

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());

        window.setResizable(false);
        window.setScene(tableViewScene);
        window.show();
    }

}
