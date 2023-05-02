package com.incomeandexpensemonitoringsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IncomeAndExpenseMonitoringSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncomeAndExpenseMonitoringSystemApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){  return new ModelMapper(); }
}
