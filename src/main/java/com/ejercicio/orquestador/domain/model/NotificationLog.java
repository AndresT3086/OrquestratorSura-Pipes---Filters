package com.ejercicio.orquestador.domain.model;

import lombok.*;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationLog {
    private String id;
    private String notificationId;
    private String status; // OK/ERROR
    private String channel;
    private String to;
    private String errorMessage;
    private Instant createdAt;
}
