package com.ejercicio.orquestador.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRef {
    private String id;
    private String email;
    private String name;
}
