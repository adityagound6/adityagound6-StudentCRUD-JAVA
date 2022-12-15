package com.example.ApiDemo.Students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig
{
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {

      return args -> {
          Student acidity = new Student("Aditya","Gound",23,"Adityagp@gmail.com");
          Student acidity2 = new Student("Aditya2","Gound",13,"Aditya2gp@gmail.com");
          repository.saveAll(List.of(acidity,acidity2));
      }  ;
    };
}
