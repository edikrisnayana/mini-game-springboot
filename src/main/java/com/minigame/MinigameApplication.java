package com.minigame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MinigameApplication {
  private static final Map<String, Object> properties = new HashMap<>();

  public static void main(String[] args) {
    try {
      SpringApplication app = new SpringApplication(MinigameApplication.class);
      generateDefaultProperties();
      app.setDefaultProperties(properties);
      app.run(args);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }

  private static void generateDefaultProperties() {
    properties.put("server.port", "8001");
    properties.put("spring.data.mongodb.database", "mini-game");
  }
}
