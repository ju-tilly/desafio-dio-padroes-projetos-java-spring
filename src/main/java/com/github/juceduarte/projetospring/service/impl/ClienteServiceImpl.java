package com.github.juceduarte.projetospring.service.impl;

import com.github.juceduarte.projetospring.model.Cliente;
import com.github.juceduarte.projetospring.service.ClienteService;
import org.springframework.stereotype.Service;

/*
*Implementação da Strategy ClienteService, a qual pode ser
* injetada pelo Spring via @Autowired. Com isso, como essa classe é um Service,
* ela será tratada como um Singleton.
*/

@Service
public class ClienteServiceImpl implements ClienteService {
    //Singleton: injetar os componentes do Spring com @Autowired.
    //Strategy: implementar os métodos definidos na interface.
    //Facade: abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
