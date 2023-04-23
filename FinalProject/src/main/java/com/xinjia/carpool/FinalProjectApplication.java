package com.xinjia.carpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.xinjia.carpool.repository")
@EntityScan("com.xinjia.carpool.model")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FinalProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(FinalProjectApplication.class, args);
  }

}
