package com.seshagiri.ps.controller;

import com.seshagiri.optl.OpenTelemetrySpan;
import io.opentelemetry.api.OpenTelemetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.seshagiri.optl.config.OpentelemetryConfiguration;

@Configuration
public class ProductConfig {


    public  OpenTelemetry openTelemetry() {
        OpentelemetryConfiguration config = new OpentelemetryConfiguration();
        return config.openTelemetry();
    }

    @Bean()
    public OpenTelemetrySpan getOpenTelemetrySpan() {
      return new OpenTelemetrySpan(openTelemetry());
    }

}
