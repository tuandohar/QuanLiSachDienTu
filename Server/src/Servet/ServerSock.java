package Servet;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Chay.Chay;

public class ServerSock {

    private static final int PORT = 9999;
    private static final int THREAD_POOL_SIZE = 10;
    private ExecutorService executor;
    private Chay chayInstance; // Reference to Chay instance

    public ServerSock(Chay chayInstance) {
        this.chayInstance = chayInstance;
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Starting Server...");
            executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                executor.submit(new handle(clientSocket, chayInstance));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (executor != null) {
                executor.shutdown();
            }
        }
    }
}
