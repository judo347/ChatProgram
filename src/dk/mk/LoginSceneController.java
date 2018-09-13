package dk.mk;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginSceneController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField textFieldUsername;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'LoginScene.fxml'.";
        assert textFieldUsername != null : "fx:id=\"textFieldUsername\" was not injected: check your FXML file 'LoginScene.fxml'.";
    }
}
