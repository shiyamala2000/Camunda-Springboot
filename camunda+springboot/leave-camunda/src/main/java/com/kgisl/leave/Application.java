package com.kgisl.leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan("com.kgisl.leave.model") 
//@EnableJpaRepositories("com.kgisl.leave.repository")
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}