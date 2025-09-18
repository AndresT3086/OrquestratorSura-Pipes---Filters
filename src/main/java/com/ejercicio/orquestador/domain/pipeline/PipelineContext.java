package com.ejercicio.orquestador.domain.pipeline;

import com.ejercicio.orquestador.domain.model.*;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class PipelineContext {
    private String ruleCode;
    private ClientRef client;
    private Map<String,Object> vars;

    private Rule rule;
    private Template template;

    private String subject;
    private String body;
    private String channel; // EMAIL
    private String to;
    private String logId;
}

