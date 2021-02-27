package org.academiadecodigo.cachalots.codeanddragons.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static ServerSocket serverSocket;
    public Socket clientSocket;
    private DataOutputStream out;
    private BufferedReader in;
    private final int port;
    private LinkedList<ClientHandler> clientList;

    //MY IP  192.168.1.109

    public String[] name = { };

    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws IOException {

        Server chatServer = new Server(9000);
        chatServer.dispatch(serverSocket);
    }

    public void dispatch(ServerSocket serverSocket) throws IOException {

        System.out.println("Server is listening...on port " + port + "\n");
        System.out.println("---------------------------------------\n" +
                           "---------------------------------------\n" +
                           "---------------------------------------\n" +
                           "---------------------------------------\n" +
                           "---------------------------------------\n" +
                           "---------------------------------------\n" +
                           "---------------------------------------\n");

        serverSocket = new ServerSocket(9000);
        clientList = new LinkedList<>();
        ExecutorService fixedPool = Executors.newFixedThreadPool(7);
        Socket clientSocket;
        int i = 0;

        while (true) {

            clientSocket = serverSocket.accept();

            ClientHandler client = new ClientHandler(clientSocket,this,name[i]);
            clientList.add(client);
            fixedPool.submit(client);
            System.out.println(">>> " + name[i] + " Has Logged inside the matrix");
            i++;

        }
    }

    public void deleteName(String name) {
        clientList.remove(name);
    }
}

