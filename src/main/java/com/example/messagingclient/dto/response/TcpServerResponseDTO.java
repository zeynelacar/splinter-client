package com.example.messagingclient.dto.response;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class TcpServerResponseDTO {

    @NotNull
    private String serverStatus;

    @NotNull
    private String serverMessage;
}
