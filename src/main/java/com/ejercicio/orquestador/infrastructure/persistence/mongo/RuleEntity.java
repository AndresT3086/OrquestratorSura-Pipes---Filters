package com.ejercicio.orquestador.infrastructure.persistence.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("rules")
public class RuleEntity {
    @Id private String id;
    private String code;
    private String description;
    private String templateCode;
    private boolean active;
}

