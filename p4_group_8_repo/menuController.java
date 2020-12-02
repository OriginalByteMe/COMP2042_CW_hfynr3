package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class menuController {
    private Button nextSceneButton;

    public void playGameButton(ActionEvent event) throws IOException {
        Parent gameView = FXMLLoader.load(getClass().getResource("game.fxml"));
        Scene gameScene = new Scene(gameView);

        // Getting Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(gameScene);
        window.show();
    }
}
