package com.github.juceduarte.projetospring.controller;

import com.github.juceduarte.projetospring.model.Cliente;
import com.github.juceduarte.projetospring.service.ClienteService;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteRestControllerIT extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        RestAssured.port = randomPort;
    }

    @Test
    void whenbuscarTodosThenCheckResult() {
        RestAssured.given()
                .auth()
                .basic("user", "dio")
                .when()
                .get("/clientes")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void buscarPorId() {
    }

    @Test
    void inserir() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void deletar() {
    }
}