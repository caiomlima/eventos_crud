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

    // Mostra apenas eventos feitos por "x" usuário
    @Override
    public List<EventoModel> getEventosByUserName(String nomeUsr) {
        return evt_repo.findByUsrEvt(nomeUsr);
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
    public void addEvento(String nomeEvt, String descEvt, String categoriaEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt, String localEvt, String cepEvt, String complEvt, Date dataInicioEvt, Date dataFimEvt, String orgEvt, String descOrgEvt, String usrEvt) {
        evt_repo.save(new EventoModel(nomeEvt, descEvt, categoriaEvt, qtdPessEvt, regiaoEvt, endrcEvt, localEvt, cepEvt, complEvt, dataInicioEvt, dataFimEvt, orgEvt, descOrgEvt, usrEvt));
    }

    @Override
    public void deleteEvento(int idEvt) { evt_repo.deleteById(idEvt); }

    @Override
    public void saveEvento(EventoModel evt) {
        evt_repo.save(evt);
    }

}
