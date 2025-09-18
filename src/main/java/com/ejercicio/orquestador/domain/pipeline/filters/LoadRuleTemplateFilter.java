package com.ejercicio.orquestador.domain.pipeline.filters;

import com.ejercicio.orquestador.domain.pipeline.Filter;
import com.ejercicio.orquestador.domain.pipeline.PipelineContext;
import com.ejercicio.orquestador.domain.ports.RuleRepositoryPort;
import com.ejercicio.orquestador.domain.ports.TemplateRepositoryPort;

public class LoadRuleTemplateFilter implements Filter<PipelineContext> {
    private final RuleRepositoryPort ruleRepo;
    private final TemplateRepositoryPort tplRepo;

    public LoadRuleTemplateFilter(RuleRepositoryPort r, TemplateRepositoryPort t){
        this.ruleRepo=r; this.tplRepo=t;
    }

    @Override
    public PipelineContext apply(PipelineContext ctx) {
        var rule = ruleRepo.findByCode(ctx.getRuleCode())
                .orElseThrow(() -> new IllegalArgumentException("Rule not found: "+ctx.getRuleCode()));
        var tpl = tplRepo.findByCode(rule.getTemplateCode())
                .orElseThrow(() -> new IllegalArgumentException("Template not found: "+rule.getTemplateCode()));
        if (!rule.isActive()) throw new IllegalStateException("Rule disabled");
        if (!tpl.isActive()) throw new IllegalStateException("Template disabled");
        ctx.setRule(rule);
        ctx.setTemplate(tpl);
        ctx.setSubject(tpl.getSubject());
        ctx.setBody(tpl.getBody());
        return ctx;
    }
}
