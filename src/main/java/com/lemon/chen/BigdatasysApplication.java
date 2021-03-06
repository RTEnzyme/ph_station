package com.lemon.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *  引导类
 * @name  BigdatasysApplication
 * @author  nlby
 * @date  2020/6/22
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.lemon.admin.RT_Enzyme.repositories"})
@EnableScheduling
public class BigdatasysApplication {
    public static void main(String[] args) {
        SpringApplication.run(BigdatasysApplication.class, args);
    }
}
