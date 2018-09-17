package dk.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
 *  https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
 *  https://tools.ietf.org/html/rfc862 - EchoProtocol*/

public class Server {

    private static final int PORT_NUMBER = 4444;

    public static void main(String[] args) {

        try (
                ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("The server is now running!");
            System.out.println("Port: " + PORT_NUMBER + " Hostname: ");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                //System.out.println("SERVER WAS TRIGGERED!"); //TODO TEMP
                System.out.println(inputLine); //TODO TEMP
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + PORT_NUMBER + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
