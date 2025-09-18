package com.ejercicio.orquestador.infrastructure.persistence.mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RuleMongoRepository extends MongoRepository<RuleEntity, String> {
    Optional<RuleEntity> findByCode(String code);
}

