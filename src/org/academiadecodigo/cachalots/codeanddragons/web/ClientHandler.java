package org.academiadecodigo.cachalots.codeanddragons.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientHandler implements Runnable {

    private Socket serverSocket;
    private final Socket clientSocket;
    private DataOutputStream out;
    private BufferedReader in;
    private String message = "";
    private Server server;
    public String name = "";
    public boolean actions;

    public ClientHandler(Socket clientSocket, Server server, String name) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //server.broadcast(">>> " + name + " Has Logged inside the matrix!\n");

            while (clientSocket.isBound()) {
                actions = false;
                // read line from socket input reader
                message = in.readLine();
                // if received /quit close break out of the reading loop

                // show the received line to the console
                //printMessage();


                if (quit()) {
                    return;
                }

            }

        } catch (IOException ex) {
            System.out.println("Receiving error: " + ex.getMessage());
        } }

    void receiveMessage(String message) throws IOException {
        out.writeBytes(message);
        out.flush();
    }


    public boolean quit() throws IOException {
        if (message.contains("/quit")) {
            System.out.println("Closing client connection");
            server.deleteName(name);
            clientSocket.close();
            return true;
        }
        return false;
    }


    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                System.out.println("Closing server socket");
                serverSocket.close();
            }

        } catch (IOException ex) {

            System.out.println("Error closing connection: " + ex.getMessage());

        }

    }

    public String getName() {
        return name;
    }

}
