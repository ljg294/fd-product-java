package com.fitdine.product.domain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan(value = {"com.fitdine.product.domain.entity"})
@EnableJpaRepositories(value = {"com.fitdine.product.domain"})
@ComponentScan(basePackages = {"com.fitdine.product.common", "com.fitdine.product.domain"})
public class DomainConfig {

}
