package dk.brandNew;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame{

    private JButton butLogin;
    private JTextField textFieldLogin;

    public LoginWindow() {
        JFrame frame = new JFrame("ChatProgram");
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
        butLogin.addActionListener(e -> chanceToChatWindow());

        textFieldLogin = new JTextField("Username");

        //Add the components
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.X_AXIS));
        masterPanel.add(textFieldLogin);
        masterPanel.add(butLogin);

        container.add(masterPanel);
    }

    private void chanceToChatWindow(){

    }
}
