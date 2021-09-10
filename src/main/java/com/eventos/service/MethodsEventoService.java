package com.eventos.service;

import com.eventos.model.EventoModel;
import com.eventos.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MethodsEventoService implements IEventoService{

    @Autowired
    private EventoRepository evt_repo;

//    @Override
//    public List<EventoModel> getEventosById(int idEvt) {
//        return evt_repo.findById(idEvt);
//    }

    @Override
    public List<EventoModel> getEventos(){
        return evt_repo.findAll();
    }

    @Override
    public EventoModel getEventoById(int idEvt) {
        Optional<EventoModel> opt = evt_repo.findById(idEvt);
        EventoModel evento = null;
        if (opt.isPresent()) {
            evento = opt.get();
        } else {
            throw new RuntimeException("Evento não encontrado pelo id " + idEvt);
        }
        return evento;
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
    public void addEvento(String nomeEvt, String descEvt, Date dataEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt) {
        evt_repo.save(new EventoModel(nomeEvt, descEvt, dataEvt, qtdPessEvt, regiaoEvt, endrcEvt));
    }

    @Override
    public void deleteEvento(int idEvt) { evt_repo.deleteById(idEvt); }

    @Override
    public void saveEvento(EventoModel evt) {
        evt_repo.save(evt);
    }
}
