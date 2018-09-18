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

    private boolean isAlive;

    public MyClient(){

        this.isAlive = true;

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

        while (isAlive){

            //incomming2(); //TODO Contains bug!
            outgoing();

            System.out.println("Tick"); //TODO TMEP

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

    private void incomming2(){

        try {
            if(in.readLine() != null) //TODO Might not work BUG BUG BUG
                incommingMsg.add(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO TEMP
        if(incommingMsg.size() > 0)
            System.out.println("We got maiL!");

    }

    /** Takes all lines in outgoing arraylist and sends them to server. */
    private void outgoing(){
        while(outgoingMsg.size() > 0){
            out.println(outgoingMsg.get(0));
            outgoingMsg.remove(0);
        }
    }

    /** Takes a line from the program and adds it to the queue. */
    public void addLineToQueue(String string){
        this.outgoingMsg.add(string);
    }

    @Override
    public void run() {
        System.out.println("New Thread started!");
        this.tick();
    }

    public void terminateServer(){
        this.isAlive = false;
    }
}