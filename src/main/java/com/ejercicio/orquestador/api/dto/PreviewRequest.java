package com.ejercicio.orquestador.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.Map;

public record PreviewRequest(
        @NotBlank String ruleCode,
        @Valid ClientDto client,
        Map<String, Object> variables
) {}
