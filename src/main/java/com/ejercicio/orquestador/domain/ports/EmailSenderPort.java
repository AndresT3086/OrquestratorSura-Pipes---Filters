package com.ejercicio.orquestador.domain.ports;

public interface EmailSenderPort {
    SendResult send(String to, String subject, String body);
    record SendResult(boolean ok, String providerId, String error) {}
}
