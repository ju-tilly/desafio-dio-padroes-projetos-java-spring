package com.github.juceduarte.projetospring.service;
import com.github.juceduarte.projetospring.model.Cliente;

/*
* Interface que define o padrão Strategy no domínio de cliente.
* Podendo ter multiplas implementações dessa mesma interface.
*/

public interface ClienteService {
    //operações de CRUD
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id,Cliente cliente);
    void deletar(Long id);
    //void exit(Long id);
}
