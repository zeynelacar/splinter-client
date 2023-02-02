package com.example.messagingclient.services.implementations;

import com.example.messagingclient.business.ClientConfig;
import com.example.messagingclient.dto.request.TcpClientRequestDTO;
import com.example.messagingclient.dto.response.TcpServerResponseDTO;
import com.example.messagingclient.services.IClientService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClientService implements IClientService {

     public TcpServerResponseDTO sendTcp(TcpClientRequestDTO req) throws IOException {
         ClientConfig client = new ClientConfig();
         TcpServerResponseDTO resp = new TcpServerResponseDTO();
         client.startConnection(req.getIp(), req.getPort());
         String message = "Having problems connecting to server";
         String status = "Down";
         try {
             message = client.sendMessage(req.getMessage());
             resp.setServerMessage(message);
             if ("We got your close signal... closing server".equals(message)) {
                 status = "Closing";
             } else {
                 status = "Up";
             }
             resp.setServerStatus(status);
             return resp;
         }catch(Exception ex) {
             resp.setServerStatus(status);
             resp.setServerMessage(message);
             return resp;
         }
     }

}
