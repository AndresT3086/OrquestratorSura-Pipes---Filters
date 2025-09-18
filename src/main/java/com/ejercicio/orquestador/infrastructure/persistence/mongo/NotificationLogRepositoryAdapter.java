package com.ejercicio.orquestador.infrastructure.persistence.mongo;

import com.ejercicio.orquestador.domain.model.NotificationLog;
import com.ejercicio.orquestador.domain.ports.NotificationLogRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotificationLogRepositoryAdapter implements NotificationLogRepositoryPort {

    private final NotificationLogMongoRepository repo;

    @Override
    public NotificationLog save(NotificationLog log) {
        var e = new NotificationLogEntity();
        e.setId(log.getId());
        e.setNotificationId(log.getNotificationId());
        e.setStatus(log.getStatus());
        e.setChannel(log.getChannel());
        e.setTo(log.getTo());
        e.setCreatedAt(log.getCreatedAt());
        var saved = repo.save(e);
        log.setId(saved.getId());
        return log;
    }

    @Override
    public Optional<NotificationLog> findById(String id) {
        return repo.findById(id).map(e -> {
            var l = new NotificationLog();
            l.setId(e.getId());
            l.setNotificationId(e.getNotificationId());
            l.setStatus(e.getStatus());
            l.setChannel(e.getChannel());
            l.setTo(e.getTo());
            l.setCreatedAt(e.getCreatedAt());
            return l;
        });
    }
}

