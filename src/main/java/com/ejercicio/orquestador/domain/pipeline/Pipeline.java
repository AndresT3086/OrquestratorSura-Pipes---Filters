package com.ejercicio.orquestador.domain.pipeline;

import java.util.ArrayList;
import java.util.List;

public class Pipeline<I> {
    private final List<Filter<I>> filters;

    private Pipeline(List<Filter<I>> filters) { this.filters = filters; }

    public I execute(I input) {
        I ctx = input;
        for (Filter<I> f : filters) ctx = f.apply(ctx);
        return ctx;
    }

    public static <I> Builder<I> builder() { return new Builder<>(); }

    public static final class Builder<I> {
        private final List<Filter<I>> fs = new ArrayList<>();
        public Builder<I> add(Filter<I> f) { fs.add(f); return this; }
        public Pipeline<I> build() { return new Pipeline<>(fs); }
    }
}
