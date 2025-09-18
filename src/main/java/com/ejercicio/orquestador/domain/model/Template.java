package com.ejercicio.orquestador.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Template {
    private String id;
    private String code;
    private String subject;
    private String body;
    private boolean active;
}
