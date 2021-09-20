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

    // Mostra Todos os eventos
    @Override
    public List<EventoModel> getEventos(){
        return evt_repo.findAll();
    }

    // Mostra apenas eventos feitos por "x" organizador
    @Override
    public List<EventoModel> getEventosByOrgName(String nomeOrg) {
        return evt_repo.findByOrgEvt(nomeOrg);
    }

    // Mostra um evento por "x" id
    @Override
    public Optional<EventoModel> getEventoById(int idEvt) {
        return evt_repo.findById(idEvt);
    }


    // Metodos CRUD

    @Override
    public void updateEvento(EventoModel evt) {
        evt_repo.save(evt);
    }

    @Override
    public void addEvento(String nomeEvt, String descEvt, Date dataEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt, String orgEvt) {
        evt_repo.save(new EventoModel(nomeEvt, descEvt, dataEvt, qtdPessEvt, regiaoEvt, endrcEvt, orgEvt));
    }

    @Override
    public void deleteEvento(int idEvt) { evt_repo.deleteById(idEvt); }

    @Override
    public void saveEvento(EventoModel evt) {
        evt_repo.save(evt);
    }
}
