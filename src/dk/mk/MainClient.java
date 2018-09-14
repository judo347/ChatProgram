package dk.mk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * https://stackoverflow.com/questions/34863425/javafx-scene-builder-how-switch-scene
 */

public class MainClient extends Application {

    private MyClient myClient;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        myClient = new MyClient();

        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("dk/mk/LoginScene.fxml"));

            primaryStage.setTitle("ChatProgram");
            primaryStage.setScene(new CustomScene(root, myClient));
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
