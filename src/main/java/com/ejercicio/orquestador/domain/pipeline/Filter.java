package com.ejercicio.orquestador.domain.pipeline;

@FunctionalInterface
public interface Filter<I> {
    I apply(I input);
}
