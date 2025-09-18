package com.ejercicio.orquestador.infrastructure.config;

import com.ejercicio.orquestador.infrastructure.persistence.mongo.RuleEntity;
import com.ejercicio.orquestador.infrastructure.persistence.mongo.RuleMongoRepository;
import com.ejercicio.orquestador.infrastructure.persistence.mongo.TemplateEntity;
import com.ejercicio.orquestador.infrastructure.persistence.mongo.TemplateMongoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final TemplateMongoRepository tplRepo;
    private final RuleMongoRepository ruleRepo;

    @PostConstruct
    public void seed(){
        tplRepo.findByCode("MORA_10").orElseGet(() -> {
            var t = new TemplateEntity();
            t.setCode("MORA_10");
            t.setSubject("Recordatorio de pago para {{name}}");
            t.setBody("Hola {{name}}, tienes un saldo pendiente de {{amount}}. Por favor regulariza.");
            t.setActive(true);
            return tplRepo.save(t);
        });

        ruleRepo.findByCode("MORA_10").orElseGet(() -> {
            var r = new RuleEntity();
            r.setCode("MORA_10");
            r.setDescription("Mora a 10 días");
            r.setTemplateCode("MORA_10");
            r.setActive(true);
            return ruleRepo.save(r);
        });
    }
}

