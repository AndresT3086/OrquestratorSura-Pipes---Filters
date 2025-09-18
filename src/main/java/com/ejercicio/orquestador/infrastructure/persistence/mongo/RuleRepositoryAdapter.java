package com.ejercicio.orquestador.infrastructure.persistence.mongo;

import com.ejercicio.orquestador.domain.model.Rule;
import com.ejercicio.orquestador.domain.ports.RuleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RuleRepositoryAdapter implements RuleRepositoryPort {

    private final RuleMongoRepository repo;

    @Override
    public Optional<Rule> findByCode(String code) {
        return repo.findByCode(code).map(e -> {
            var r = new Rule();
            r.setId(e.getId());
            r.setCode(e.getCode());
            r.setDescription(e.getDescription());
            r.setTemplateCode(e.getTemplateCode());
            r.setActive(e.isActive());
            return r;
        });
    }

    @Override
    public Rule save(Rule rule) {
        var entity = new RuleEntity();
        entity.setId(rule.getId());
        entity.setCode(rule.getCode());
        entity.setDescription(rule.getDescription());
        entity.setTemplateCode(rule.getTemplateCode());
        entity.setActive(rule.isActive());
        var saved = repo.save(entity);
        rule.setId(saved.getId());
        return rule;
    }
}
