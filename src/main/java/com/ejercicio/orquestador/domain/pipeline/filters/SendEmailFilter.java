package com.ejercicio.orquestador.domain.pipeline.filters;

import com.ejercicio.orquestador.domain.pipeline.Filter;
import com.ejercicio.orquestador.domain.pipeline.PipelineContext;
import com.ejercicio.orquestador.domain.ports.EmailSenderPort;
import com.ejercicio.orquestador.domain.ports.WhitelistPort;

public class SendEmailFilter implements Filter<PipelineContext> {
    private final EmailSenderPort email;
    private final WhitelistPort whitelist;

    public SendEmailFilter(EmailSenderPort email, WhitelistPort whitelist) {
        this.email = email; this.whitelist = whitelist;
    }

    @Override
    public PipelineContext apply(PipelineContext ctx) {
        if (!whitelist.isAllowed(ctx.getTo()))
            throw new IllegalArgumentException("Recipient not allowed: " + ctx.getTo());
        var res = email.send(ctx.getTo(), ctx.getSubject(), ctx.getBody());
        if (!res.ok()) throw new IllegalStateException("Email failed: " + res.error());
        return ctx;
    }
}
