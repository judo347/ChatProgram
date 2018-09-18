package dk.brandNew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class LoginWindow extends JFrame{

    private JButton butLogin;
    private JTextField textFieldLogin;

    private MainFrame mainFrame;

    private final int windowWidth = 200;
    private final int windowHeight = 100;

    public LoginWindow(MainFrame mainFrame) {
        super("Chat Program");
        this.mainFrame = mainFrame;

        setResizable(false);

        addContentToPane(this.getContentPane());
        pack();

        //TODO close server if window is closed by X

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - windowWidth/2, dim.height/2 - windowHeight/2);
        setSize(windowWidth, windowHeight);
        setVisible(true);

    }

    /** Adds content to the window. Takes the frame as input. */
    private void addContentToPane(Container container){

        //Button
        butLogin = new JButton("Login");
        butLogin.addActionListener(e -> tryLogin());

        textFieldLogin = new JTextField("Username");
        //Triggers when field is marked and enter is pressed
        textFieldLogin.addActionListener(e -> tryLogin());

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
