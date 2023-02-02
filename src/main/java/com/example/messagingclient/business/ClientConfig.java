package com.example.messagingclient.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConfig {


    private final Logger logger = LogManager.getLogger();
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private String status = "open";

    public void startConnection(String ip,int port) throws IOException {

        try {
            socket = new Socket(ip, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            logger.info("successfully connected");
        }catch(Exception ex){
            logger.error(ex);
        }
    }

    public String sendMessage(String message) throws IOException {
        writer.println(message);
        String response = reader.readLine();
        logger.info(response);
        return response;
    }

    public void stopConnection() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }


}
