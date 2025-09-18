package com.ejercicio.orquestador.infrastructure.persistence.mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TemplateMongoRepository extends MongoRepository<TemplateEntity, String> {
    Optional<TemplateEntity> findByCode(String code);
}

