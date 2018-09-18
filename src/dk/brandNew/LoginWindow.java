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

        addContentToPane(this.getContentPane());
        pack();

        //TODO close server if window is closed by X

        //Set window properties
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - windowWidth/2, dim.height/2 - windowHeight/2);
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setVisible(true);
    }

    /** Adds content to the window. Takes the frame's container as input. */
    private void addContentToPane(Container container){

        //Button
        butLogin = new JButton("Login");
        butLogin.addActionListener(e -> tryLogin());

        textFieldLogin = new JTextField("Username");
        textFieldLogin.addActionListener(e -> tryLogin()); //Triggers when field is marked and enter is pressed

        //Add the components to panel
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.X_AXIS));
        masterPanel.add(textFieldLogin);
        masterPanel.add(butLogin);

        container.add(masterPanel);
    }

    /** Tries to login with whatever is in the textField (if !empty).
     *  Done by sending the string to the mainFrame. */
    private void tryLogin(){

        String userName = textFieldLogin.getText();
        textFieldLogin.setText("");

        mainFrame.tryLogin(userName);
    }
}
