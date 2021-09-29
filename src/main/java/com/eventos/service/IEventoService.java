package com.eventos.service;

import com.eventos.model.EventoModel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEventoService {

    // Lista todos os eventos, independente de quem fez
    List<EventoModel> getEventos();

    // Lista os eventos de um organizador
    List<EventoModel> getEventosByUserName(String nomeUsr);

    Optional<EventoModel> getEventoById(int idEvt);

    // CRUD
    void updateEvento(EventoModel evt);
    void addEvento(String nomeEvt, String descEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt,
                   String localEvt, String cepEvt, String complEvt, Date dataInicioEvt, Date dataFimEvt,
                   String orgEvt, String descOrgEvt, String usrEvt);
    void deleteEvento(int idEvt);
    void saveEvento(EventoModel evt);
}
