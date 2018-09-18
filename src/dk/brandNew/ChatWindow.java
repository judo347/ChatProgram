package dk.brandNew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow extends JFrame{

    private TextField textFieldUserIn;
    private TextArea textAreaLog;
    private JButton buttonSend;

    private String userName;
    private MainFrame mainFrame;

    private final int windowWidth = 400;
    private final int windowHeight = 600;

    public ChatWindow(String userName, MainFrame mainFrame) {
        super();

        this.mainFrame = mainFrame;
        this.userName = userName;

        setName("Chat Program");
        setResizable(false);
        addWindowListener(new WindowAdapter() { //Close server + window on EXIT window
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                mainFrame.terminateAll();
            }
        });

        //Add content
        addContentToPane(this.getContentPane());
        pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - windowWidth/2, dim.height/2 - windowHeight/2);
        setSize(windowWidth, windowHeight);
        setVisible(true);
    }

    private void addContentToPane(Container container){

        textAreaLog = new TextArea();
        textAreaLog.setEditable(false);
        textFieldUserIn = new TextField("Message to send.");
        //Triggers when field is marked and enter is pressed
        textFieldUserIn.addActionListener(e -> sendMessage());
        buttonSend = new JButton("SEND");
        buttonSend.addActionListener(e -> sendMessage());

        //
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new BoxLayout(buttomPanel, BoxLayout.X_AXIS));
        buttomPanel.add(textFieldUserIn);
        buttomPanel.add(buttonSend);

        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.add(textAreaLog);
        masterPanel.add(buttomPanel);

        container.add(masterPanel);
    }

    /** Takes the text from the input and forwards it to the server. */
    private void sendMessage(){

        String msg = textFieldUserIn.getText();
        textFieldUserIn.setText("");

        //If field contains a msg
        if(!msg.equals("")){
            mainFrame.sendMessage(msg); //Send msg to server
            textAreaLog.append(userName + ": " + msg + "\n"); //Print my msg in area
        }
    }

    /** takes a msg and a sender and prints it to the log area. */
    public void receiveMessage(String sender, String msg){

        textAreaLog.append(sender + ": " + msg + "\n");
    }
}
