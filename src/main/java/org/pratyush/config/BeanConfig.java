package org.pratyush.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BeanConfig {

    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }
}
