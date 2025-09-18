package com.ejercicio.orquestador.domain.model;

import lombok.*;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private String id;
    private ClientRef client;
    private String channel; // EMAIL
    private String subject;
    private String body;
    private Map<String, Object> metadata;
}
