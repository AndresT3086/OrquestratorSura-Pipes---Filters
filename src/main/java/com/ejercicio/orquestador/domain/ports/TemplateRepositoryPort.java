package com.ejercicio.orquestador.domain.ports;

import com.ejercicio.orquestador.domain.model.Template;
import java.util.Optional;
import java.util.List;

public interface TemplateRepositoryPort {
    Optional<Template> findByCode(String code);
    Template save(Template template);
    List<Template> findAll();
    void deleteByCode(String code);
}
