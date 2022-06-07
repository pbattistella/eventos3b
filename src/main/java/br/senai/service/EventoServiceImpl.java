package br.senai.service;

import br.senai.model.Evento;
import br.senai.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento findById(Long id){
        Evento findEvento = eventoRepository.findById(id).get();
        if (findEvento != null){
            return findEvento;
        } else {
            return new Evento();
        }
    }

    @Override
    public Evento save(Evento evento) {
        try{
            return eventoRepository.save(evento);
        }catch (Exception e){
            throw (e);
        }
    }

    @Override
    public void deleteById(Long id){
        try{
            eventoRepository.deleteById(id);
        }catch (Exception e){
            throw  e;
        }
    }
}
