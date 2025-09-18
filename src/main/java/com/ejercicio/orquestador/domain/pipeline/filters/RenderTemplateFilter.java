package com.ejercicio.orquestador.domain.pipeline.filters;

import com.ejercicio.orquestador.domain.pipeline.Filter;
import com.ejercicio.orquestador.domain.pipeline.PipelineContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RenderTemplateFilter implements Filter<PipelineContext> {
    private static final Pattern P = Pattern.compile("\\{\\{\\s*([\\w.]+)\\s*}}");

    @Override
    public PipelineContext apply(PipelineContext ctx) {
        ctx.setSubject(render(ctx.getSubject(), ctx));
        ctx.setBody(render(ctx.getBody(), ctx));
        ctx.setChannel("EMAIL");
        return ctx;
    }

    private String render(String text, PipelineContext ctx) {
        if (text == null) return "";
        Matcher m = P.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String key = m.group(1);
            Object val = switch (key) {
                case "name" -> ctx.getClient().getName();
                case "email" -> ctx.getClient().getEmail();
                default -> ctx.getVars() == null ? null : ctx.getVars().get(key);
            };
            m.appendReplacement(sb, Matcher.quoteReplacement(val == null ? "" : String.valueOf(val)));
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
