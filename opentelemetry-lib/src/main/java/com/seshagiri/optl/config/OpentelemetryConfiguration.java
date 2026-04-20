package com.seshagiri.optl.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;



//@Configuration
public class  OpentelemetryConfiguration {

    //@Value("${spring.service.name}")
    private String serviceName = "OpenTelemetry - library";

    //@Bean()
    public OpenTelemetry openTelemetry(){

        Resource resource = Resource.getDefault().toBuilder()
                .put(ResourceAttributes.SERVICE_NAME,serviceName)
                .put(ResourceAttributes.SERVICE_VERSION,"1.0.0").build();

        SdkTracerProvider provider = SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.
                        create(LoggingSpanExporter.create()))
                .setResource(resource).build();

        OpenTelemetry openTelemetry = OpenTelemetrySdk.builder()
                .setTracerProvider(provider).build();
        return openTelemetry;

    }



}