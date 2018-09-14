package dk.mk;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChatSceneController implements Initializable {

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

    //TODO Make this class reference work
    private MyClient myClient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert buttonSend != null : "fx:id=\"buttonSend\" was not injected: check your FXML file 'ChatScene.fxml'.";
        assert messageField != null : "fx:id=\"messageField\" was not injected: check your FXML file 'ChatScene.fxml'.";
        assert receivedField != null : "fx:id=\"receivedField\" was not injected: check your FXML file 'ChatScene.fxml'.";
    }

    /** This method is called when the button is pressed.
     *  The text in textField is then deleted and passed on to MyClient. */
    public void sendMessage(ActionEvent event){
        String msg = messageField.getText();
        messageField.clear();

        //TODO Pass this to the SERVER
    }
}
