package dk.brandNew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MyClient extends Thread {

    private static final int PORT_NUMBER = 4444;
    private static final String HOST_NAME = "127.0.0.1";

    private PrintWriter out;
    private BufferedReader stdIn;
    private BufferedReader in;

    private ArrayList<String> incommingMsg;
    private ArrayList<String> outgoingMsg;

    public MyClient(){

        try{

            Socket echoSocket = new Socket(HOST_NAME, PORT_NUMBER);
            this.out = new PrintWriter(echoSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            this.stdIn = new BufferedReader(new InputStreamReader(System.in));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + HOST_NAME + HOST_NAME);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + HOST_NAME);
            System.exit(1);
        }

        this.incommingMsg = new ArrayList<>();
        this.outgoingMsg = new ArrayList<>();
    }

    /** Should check arraylist for elements to send, and save reveicved lines to other array*/
    public void tick(){

        while (true){

            //incomming();
            outgoing();

            System.out.println("MyClient: " + Thread.currentThread().getName()); //TODO TMEP

            System.out.println("Tick");

            //TODO Send incomming to window
        }
    }

    /** Takes a line from server and adds it to arraylist. */
    private void incomming(){

        //TODO Should handle more than one line at a time.
        try {
            if(stdIn.readLine() != null) //TODO Might not work BUG BUG BUG
                incommingMsg.add(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** Takes all lines in outgoing arraylist and sends them to server. */
    private void outgoing(){
        for(String string : outgoingMsg)
            out.println(string);
    }
}