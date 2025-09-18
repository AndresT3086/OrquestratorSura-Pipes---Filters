package com.ejercicio.orquestador.domain.pipeline.filters;

import com.ejercicio.orquestador.domain.pipeline.Filter;
import com.ejercicio.orquestador.domain.pipeline.PipelineContext;

public class ValidateInputFilter implements Filter<PipelineContext> {
    @Override
    public PipelineContext apply(PipelineContext ctx) {
        if (ctx.getClient()==null || ctx.getClient().getEmail()==null || ctx.getClient().getEmail().isBlank())
            throw new IllegalArgumentException("client.email is required");
        ctx.setTo(ctx.getClient().getEmail());
        return ctx;
    }
}
