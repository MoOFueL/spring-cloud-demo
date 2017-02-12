package ru.atc;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Дмитрий on 12.02.2017.
 */
@Configuration
public class ZipkinConfig {

    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }
}
