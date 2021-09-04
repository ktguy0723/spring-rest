package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
  
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student marian = new Student(
        "Marian",
        "marian.jamal@gmail.com",
        LocalDate.of(2000, Month.JANUARY, 5),
        21
      );

      Student alex = new Student(
        "Alex",
        "alex@gmail.com",
        LocalDate.of(2010, Month.JULY, 22),
        11
      );

      repository.saveAll(
        List.of(marian, alex)
      );
    };
  }
}
