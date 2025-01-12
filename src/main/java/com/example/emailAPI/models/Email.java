package com.example.emailAPI.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.ZonedDateTime;

@Getter @Setter @NoArgsConstructor
public class Email {
    @JsonProperty("id")
    private long id;

    @JsonProperty("remitente")
    private String remitente;

    @JsonProperty("destinatario")
    private String destinatario;

    @JsonProperty("asunto")
    private String asunto;

    @JsonProperty("cuerpo")
    private String cuerpo;

    @JsonProperty("fecha")
    private ZonedDateTime fecha;
}
