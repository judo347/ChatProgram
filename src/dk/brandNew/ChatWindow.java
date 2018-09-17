package dk.brandNew;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame{

    private TextField textFieldUserIn;
    private TextArea textArea;
    private JButton buttonSend;

    private String userName;
    private MainFrame mainFrame;

    public ChatWindow(String userName, MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        this.userName = userName;

        this.setName("Chat Program");
        this.setResizable(false);

        //Add content
        addContentToPane(this.getContentPane());

        this.pack();
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void addContentToPane(Container container){

        textArea = new TextArea();
        textArea.setEditable(false);
        textFieldUserIn = new TextField("Message to send.");
        buttonSend = new JButton("SEND");
        buttonSend.addActionListener(e -> sendMessage());

        //
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new BoxLayout(buttomPanel, BoxLayout.X_AXIS));
        buttomPanel.add(textFieldUserIn);
        buttomPanel.add(buttonSend);

        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.add(textArea);
        masterPanel.add(buttomPanel);

        container.add(masterPanel);
    }

    /** Takes the text from the input and forwards it to the server. */
    private void sendMessage(){

        String msg = textFieldUserIn.getText();
        textFieldUserIn.setText("");

        if(!msg.equals("")){ mainFrame.sendMessage(msg); }
    }
}
