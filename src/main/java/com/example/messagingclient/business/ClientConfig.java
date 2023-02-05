package com.example.messagingclient.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientConfig {


    private final Logger logger = LogManager.getLogger();
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public void startConnection(String ip,int port) throws IOException {

        try {
            socket = new Socket(ip, port);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            logger.info("successfully connected");
        }catch(Exception ex){
            logger.error(ex);
        }
    }

    public String sendMessage(String message) throws IOException {
        message = prepareMessage(message);
        Scanner sc = new Scanner(System.in);
        if(socket.isConnected()) {
            writer.write(message);
            writer.flush();
            String response = reader.readLine();
            logger.info(response);
            return response;
        }
        return null;
    }

    public void stopConnection() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }

    private static String prepareMessage(String message){
        StringBuilder sb = new StringBuilder();
        int len = message.length();
        String head = Integer.toHexString(len);
        head = zeroPadLeft(head,6);
        sb.append(head);
        sb.append(message);
        return sb.toString();
    }

    private static String zeroPadLeft(String s, int n) {
        return String.format("%" + n + "s", s).replace(' ', '0');
    }

}
