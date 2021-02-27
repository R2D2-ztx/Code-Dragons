package org.academiadecodigo.cachalots.codeanddragons.gamelogic;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.cachalots.codeanddragons.gamelogic.GameLogic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket serverSocket;
    private Socket clientSocket;
    private String message = "";
    private ServerSocket server;
    public String name = "";


    public ClientHandler(ServerSocket server, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(clientSocket.getOutputStream());
            Prompt prompt = new Prompt(clientSocket.getInputStream(), out);

            //----------------------------------------
            GameLogic game = new GameLogic(out, prompt);
            game.start();
            game.reStart();
            //----------------------------------------


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}