package com.eventos.service;

import com.eventos.model.EventoModel;
import com.eventos.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MethodsEventoService implements IEventoService{

    @Autowired
    private EventoRepository evt_repo;

//    @Override
//    public List<EventoModel> getEventosById(int id_evt) {
//        return evt_repo.findById(id_evt);
//    }

    @Override
    public List<EventoModel> getEventos(){
        return evt_repo.findAll();
    }

//    Opcional: Puxar evento pelo nome do user (Precisa estar em um repository)
//    @Override
//    public List<EventoModel> getEventosByUsername(String username) {
//        return evt_repo.findByUsername(String username);
//    }

    @Override
    public void updateEvento(EventoModel evt) {
        evt_repo.save(evt);
    }

    @Override
    public void addEvento(String nome_evt, String desc_evt, Date data_evt, String qtd_pessoas_evt, String regiao_evt, String endereco_evt) {
        evt_repo.save(new EventoModel(nome_evt, desc_evt, data_evt, qtd_pessoas_evt, regiao_evt, endereco_evt));
    }

    @Override
    public void deleteEvento(int id_evt) { evt_repo.deleteById(id_evt); }

    @Override
    public void saveEvento(EventoModel evt) {
        evt_repo.save(evt);
    }


//    Antigos metodos

//    public List<EventoModel> listAll() {
//        return evt_repo.findAll();
//    }
//
//    public void save(EventoModel evt) {
//        evt_repo.save(evt);
//    }
//
//    public EventoModel getEventos(Integer id_evt) {
//        return evt_repo.findById(id_evt).get();
//    }
//
//    public void delete(Integer id_evt) {
//        evt_repo.deleteById(id_evt);
//    }
}
