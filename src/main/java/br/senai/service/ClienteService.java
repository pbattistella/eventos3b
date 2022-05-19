package br.senai.service;

import br.senai.model.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente findByNome(String nome);
    public Cliente save(Cliente cliente);
    public void deleteById(Long id);
}
