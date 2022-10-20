package com.github.juceduarte.projetospring;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
	@Bean
	public OpenAPI OpenAPI (){

		return new OpenAPI().info(new Info()
				.title("API de cadastro de clientes e CEP")
				.version("1.0.1")
				.description("API que cadastra clientes e busca endereço completo com apenas o CEP.")
				.termsOfService("http://example.com/terms/")
				.license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html")));
	}

}
