package dk.brandNew;

import javax.swing.*;

public class MainFrame {

    private JFrame currentFrame;
    private MyClient myClient;

    public MainFrame() {

        //Start server
        myClient = new MyClient();
        myClient.start();

        //Display login screen /get login
        currentFrame = new LoginWindow(this);
    }

    /** Takes the username and tries to login.
     *  if success = change window to chatWindow. */
    public boolean tryLogin(String userName){

        //Try login
        boolean userLogin = true;
        //TODO Should somehow check with server if the userName is valid?

        //If success = change window to ChatWindow
        if(userLogin) {
            //currentFrame.setVisible(false); //TODO should close the FRAME instead!!
            //currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
            ((LoginWindow)currentFrame).closeThisWindow(); //TODO THIS SHOULD BE THE RIGHT ONE
            //currentFrame.dispose();
            //currentFrame.setVisible(false);
            //currentFrame.setSize(800, 800);

            currentFrame = null;
            currentFrame = new ChatWindow(userName, this);
        }

        return userLogin;
    }

    /** Takes a string from the window and forwards it to the MyClient. */
    public void sendMessage(String string){
        myClient.addLineToQueue(string);
    }

    /** Terminates the server and current window. */
    public void terminateAll(){
        if(currentFrame != null)
            currentFrame.dispose();
        myClient.terminateServer();
    }
}