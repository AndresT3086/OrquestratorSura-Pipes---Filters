package com.ejercicio.orquestador.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientDto(
        @NotBlank String id,
        @NotBlank String name,
        @Email @NotBlank String email
) {}

