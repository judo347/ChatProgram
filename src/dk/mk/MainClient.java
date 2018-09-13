package dk.mk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClient extends Application {

    private MyClient client;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("dk/mk/ChatScene.fxml"));

            primaryStage.setTitle("ChatProgram");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e){
            e.printStackTrace();
        }

        client = new MyClient();
    }


}
