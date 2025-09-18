package com.ejercicio.orquestador.domain.pipeline.filters;

import com.ejercicio.orquestador.domain.model.NotificationLog;
import com.ejercicio.orquestador.domain.pipeline.Filter;
import com.ejercicio.orquestador.domain.pipeline.PipelineContext;
import com.ejercicio.orquestador.domain.ports.NotificationLogRepositoryPort;

import java.time.Instant;
import java.util.UUID;

public class PersistLogFilter implements Filter<PipelineContext> {
    private final NotificationLogRepositoryPort repo;

    public PersistLogFilter(NotificationLogRepositoryPort repo){ this.repo = repo; }

    @Override
    public PipelineContext apply(PipelineContext ctx) {
        NotificationLog log = NotificationLog.builder()
                .notificationId(UUID.randomUUID().toString())
                .status("OK")
                .channel("EMAIL")
                .to(ctx.getTo())
                .createdAt(Instant.now())
                .build();

        NotificationLog saved = repo.save(log);
        ctx.setLogId(saved.getId());
        return ctx;
    }
}
