package com.ejercicio.orquestador.infrastructure.persistence.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("templates")
public class TemplateEntity {
    @Id private String id;
    private String code;
    private String subject;
    private String body;
    private boolean active;
}

