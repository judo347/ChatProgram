package dk.mk;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChatSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSend;

    @FXML
    private TextField messageField;

    @FXML
    private TextField receivedField;


    @FXML
    void initialize() {
        assert buttonSend != null : "fx:id=\"buttonSend\" was not injected: check your FXML file 'ChatScene.fxml'.";
        assert messageField != null : "fx:id=\"messageField\" was not injected: check your FXML file 'ChatScene.fxml'.";
        assert receivedField != null : "fx:id=\"receivedField\" was not injected: check your FXML file 'ChatScene.fxml'.";
    }

}
