package com.github.juceduarte.projetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
* Projeto Spring Boot via Spring Initializr
* Para o desafio de projetos do Bootcamp Québec Java
* - Dependencias usadas:
* - Spring Data JPA;
* - Spring Web
* - H2 Database
* - Postgresql Database
* - OpenFeign
* @author Venilton
* @author Juce Duarte - alterações
* */
@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
