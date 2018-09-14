package dk.mk;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginSceneController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField textFieldUsername;

    //TODO Make this class reference work
    private MyClient myClient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'LoginScene.fxml'.";
        assert textFieldUsername != null : "fx:id=\"textFieldUsername\" was not injected: check your FXML file 'LoginScene.fxml'.";
    }

    public void login(){

        String userName = textFieldUsername.getText();
        textFieldUsername.clear();

        //TODO Send username to server?

        CustomScene scene = (CustomScene) buttonLogin.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        CustomScene scene2 = null;
        try {
            scene2 = new CustomScene(FXMLLoader.load(getClass().getClassLoader().getResource("dk/mk/ChatScene.fxml")), scene.getMyClient());
        } catch (IOException e) {
            e.printStackTrace();
            //TODO Handle
        }

        stage.setScene(scene2);
        scene.getMyClient().tick();
    }
}
