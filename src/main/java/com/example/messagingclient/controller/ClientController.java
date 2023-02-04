package com.example.messagingclient.controller;

import com.example.messagingclient.dto.request.TcpClientRequestDTO;
import com.example.messagingclient.dto.response.TcpServerResponseDTO;
import com.example.messagingclient.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tcpClient")
public class ClientController {

    private final IClientService clientService;


    @PostMapping(value ="/send")
    public ResponseEntity<?> send(@RequestBody TcpClientRequestDTO request) throws IOException {
        ResponseEntity<?> response = null;
        TcpServerResponseDTO serverResponse = clientService.sendTcp(request);
        response = new ResponseEntity<>(serverResponse,HttpStatus.OK);
        return response;
    }


}
