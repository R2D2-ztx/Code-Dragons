package org.academiadecodigo.cachalots.codeanddragons.gamelogic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {

    public static void main(String[] args) {
        serverStart();
    }

    public static void serverStart() {
        int players = 0;
        final int port = 9000;
        System.out.println("Waiting for players...");
        try {
            ServerSocket server = new ServerSocket(port);
            ExecutorService fixedPool = Executors.newFixedThreadPool(21);

            while (true) {
                Socket clientSocket = server.accept();
                fixedPool.submit(new ClientHandler(server,clientSocket));
                players++;
                System.out.println("A new player has come, we have now " + players );
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
