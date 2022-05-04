package br.senai.service;

import br.senai.model.Cliente;
import br.senai.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll(Sort.by("nome"));
    }

    @Override
    public Cliente findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public Cliente save(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e){
            throw e;
        }
    }
}
