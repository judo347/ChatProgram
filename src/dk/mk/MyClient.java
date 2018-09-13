package dk.mk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

    private static final int PORT_NUMBER = 4444;
    private static final String HOST_NAME = "127.0.0.1";

    private PrintWriter out;
    private BufferedReader stdIn;
    private BufferedReader in;

    public void MyClient(){

        try{

            Socket echoSocket = new Socket(HOST_NAME, PORT_NUMBER);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + HOST_NAME + HOST_NAME);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + HOST_NAME);
            System.exit(1);
        }
    }

    public void sendMessage(String msg){

        try{
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (IOException e){
            System.out.println("Failure in: MyClient -> sendMessage.");
            System.exit(1);
        }
    }
}