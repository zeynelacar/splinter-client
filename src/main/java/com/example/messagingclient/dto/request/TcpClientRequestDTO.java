package com.example.messagingclient.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TcpClientRequestDTO {

    @NotBlank
    private String ip;

    @NotBlank
    private int port;

    @NotNull
    private String message;

}
