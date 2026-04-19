package com.seshagiri.optl;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.springframework.stereotype.Component;

@Component
public class OpenTelemetrySpan {

    private OpenTelemetry openTelemetry;
    private Span span;

    public OpenTelemetrySpan(OpenTelemetry  openTelemetrypenTelemetry){
        this.openTelemetry = openTelemetry;


    }

    public Span startSpan(String className, String methodName, String httpMethod,String userAgent){
        this.span = this.openTelemetry.getTracer(className).spanBuilder(methodName)
                .startSpan();
        this.span.setAttribute("http-method",httpMethod);
        this.span.setAttribute("user-agent",userAgent);
        return this.span;
    }

    public void stopSpan(){
        this.span.end();
    }

    public Scope getScopeContext(){
        return this.span.makeCurrent();
    }
}
