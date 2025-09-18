package com.ejercicio.orquestador.domain.ports;

import com.ejercicio.orquestador.domain.model.Rule;
import java.util.Optional;

public interface RuleRepositoryPort {
    Optional<Rule> findByCode(String code);
    Rule save(Rule rule);
}
