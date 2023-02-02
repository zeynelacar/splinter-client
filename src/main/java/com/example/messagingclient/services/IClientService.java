package com.example.messagingclient.services;

import com.example.messagingclient.dto.request.TcpClientRequestDTO;
import com.example.messagingclient.dto.response.TcpServerResponseDTO;

import java.io.IOException;

public interface IClientService {

    TcpServerResponseDTO sendTcp(TcpClientRequestDTO req) throws IOException;
}
