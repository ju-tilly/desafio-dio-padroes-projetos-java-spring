package com.github.juceduarte.projetospring.service.impl;

import com.github.juceduarte.projetospring.model.Cliente;
import com.github.juceduarte.projetospring.model.ClienteRepository;
import com.github.juceduarte.projetospring.model.Endereco;
import com.github.juceduarte.projetospring.model.EnderecoRepository;
import com.github.juceduarte.projetospring.service.ClienteService;
import com.github.juceduarte.projetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
*Implementação da Strategy ClienteService, a qual pode ser
* injetada pelo Spring via @Autowired. Com isso, como essa classe é um Service,
* ela será tratada como um Singleton.
*/

@Service
public class ClienteServiceImpl implements ClienteService {

    //Singleton: injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    //Strategy: implementar os métodos definidos na interface.
    //Facade: abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() { //Buscar todos os clientes

        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) { //Buscar cliente por ID
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteECep(cliente);

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Buscar Cliente pelo ID, caso exista
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        //Verificar se Endereco já existe (pelo CEP)
        if(clienteBd.isPresent()){
        //Caso não exista, integrar com ViaCEP e persistir o retorno
        //Alterar Cliente, vinculando o Endereco (novo ou existente)
            salvarClienteECep(cliente);
        }
    }

    @Override
    public void deletar(Long id) { //Deletar Cliente por ID
        clienteRepository.deleteById(id);
    }

    private void salvarClienteECep(Cliente cliente) {
        //Verificar se o endereço do cliente já existe (pelo CEP)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep); //Caso não exista, integrar com o ViaCEP e persistir o retorno
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //Inserir Cliente, vinculando o Endereco (novo ou existente)
        clienteRepository.save(cliente);
    }
}
