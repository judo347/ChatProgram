package dk.mk;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class CustomRoot extends Scene {

    private MyClient myClient;

    public CustomRoot(Parent root, MyClient myClient) {
        super(root);
        this.myClient = myClient;
    }

    public MyClient getMyClient() {
        return myClient;
    }
}
