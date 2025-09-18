package com.ejercicio.orquestador.infrastructure.persistence.mongo;

import com.ejercicio.orquestador.domain.model.Template;
import com.ejercicio.orquestador.domain.ports.TemplateRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TemplateRepositoryAdapter implements TemplateRepositoryPort {

    private final TemplateMongoRepository repo;

    @Override
    public Optional<Template> findByCode(String code) {
        return repo.findByCode(code).map(e -> {
            var t = new Template();
            t.setId(e.getId());
            t.setCode(e.getCode());
            t.setSubject(e.getSubject());
            t.setBody(e.getBody());
            t.setActive(e.isActive());
            return t;
        });
    }

    @Override
    public Template save(Template template) {
        var entity = new TemplateEntity();
        entity.setId(template.getId());
        entity.setCode(template.getCode());
        entity.setSubject(template.getSubject());
        entity.setBody(template.getBody());
        entity.setActive(template.isActive());
        var saved = repo.save(entity);
        template.setId(saved.getId());
        return template;
    }

    @Override
    public java.util.List<Template> findAll() {
        var entities = repo.findAll();
        var templates = new java.util.ArrayList<Template>();
        for (var e : entities) {
            var t = new Template();
            t.setId(e.getId());
            t.setCode(e.getCode());
            t.setSubject(e.getSubject());
            t.setBody(e.getBody());
            t.setActive(e.isActive());
            templates.add(t);
        }
        return templates;
    }

    @Override
    public void deleteByCode(String code) {
        repo.findByCode(code).ifPresent(e -> repo.deleteById(e.getId()));
    }
}
