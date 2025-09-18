package com.ejercicio.orquestador.domain.model;

import lombok.*;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    private String id;
    private String code;
    private String description;
    private Map<String, Object> params;
    private boolean active;
    private String templateCode;
}
