package br.senai.service;

import br.senai.model.Evento;

import java.util.List;

public interface EventoService {
    public List<Evento> findAll();
    public Evento findById(Long id);
    public Evento save(Evento evento);
    public void deleteById(Long id);
}
