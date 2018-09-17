package dk.brandNew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class LoginWindow extends JFrame{

    private JButton butLogin;
    private JTextField textFieldLogin;

    private MainFrame mainFrame;

    public LoginWindow(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        JFrame frame = new JFrame("Chat Program");
        frame.setResizable(false);

        addContentToPane(frame.getContentPane());

        frame.pack();
        frame.setSize(200, 100);
        frame.setVisible(true);

    }

    /** Adds content to the window. Takes the frame as input. */
    private void addContentToPane(Container container){

        //Button
        butLogin = new JButton("Login");
        butLogin.addActionListener(e -> tryLogin());

        textFieldLogin = new JTextField("Username");

        //Add the components
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.X_AXIS));
        masterPanel.add(textFieldLogin);
        masterPanel.add(butLogin);

        container.add(masterPanel);
    }

    private void tryLogin(){

        String userName = textFieldLogin.getText();
        textFieldLogin.setText("");

        mainFrame.tryLogin(userName);
    }

    public void closeThisWindow(){

        // this will make sure WindowListener.windowClosing() et al. will be called.
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

        // this will hide and dispose the frame, so that the application quits by
        // itself if there is nothing else around.
        setVisible(false);
        dispose();
        // if you have other similar frames around, you should dispose them, too.

        // finally, call this to really exit.
        // i/o libraries such as WiiRemoteJ need this.
        // also, this is what swing does for JFrame.EXIT_ON_CLOSE
        //System.exit(0);


    }
}
