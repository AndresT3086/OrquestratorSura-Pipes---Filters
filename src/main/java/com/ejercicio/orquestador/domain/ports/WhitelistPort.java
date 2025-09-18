package com.ejercicio.orquestador.domain.ports;

public interface WhitelistPort {
    boolean isAllowed(String email);
}
