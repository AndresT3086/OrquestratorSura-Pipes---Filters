package com.ejercicio.orquestador.infrastructure.persistence.mongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationLogMongoRepository extends MongoRepository<NotificationLogEntity, String> {}

