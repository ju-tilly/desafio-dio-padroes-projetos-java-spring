package com.github.juceduarte.projetospring.controller;

import com.github.juceduarte.projetospring.model.Cliente;
import com.github.juceduarte.projetospring.service.ClienteService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Esse RestController representa nossa Facade, pois abstrai toda a
* complexidade de integrações (Banco de dados e API do ViaCEP) em uma
* interface simples e coesa (API REST)
*/

@RestController
@RequestMapping("clientes")
@Tag(name = "Cliente Controller")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Buscar todos os clientes")
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar clientes por ID")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Inserir clientes")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dados de clientes")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cliente por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
