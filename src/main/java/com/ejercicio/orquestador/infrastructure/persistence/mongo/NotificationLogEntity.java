package com.ejercicio.orquestador.infrastructure.persistence.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document("notification_logs")
public class NotificationLogEntity {
    @Id private String id;
    private String notificationId;
    private String status;
    private String channel;
    private String to;
    private Instant createdAt;
}

