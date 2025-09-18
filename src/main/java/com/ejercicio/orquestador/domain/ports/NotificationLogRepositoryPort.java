package com.ejercicio.orquestador.domain.ports;

import com.ejercicio.orquestador.domain.model.NotificationLog;
import java.util.Optional;

public interface NotificationLogRepositoryPort {
    NotificationLog save(NotificationLog log);
    Optional<NotificationLog> findById(String id);
}
