package com.eventos.service;

import com.eventos.model.EventoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEventoService {

    // Lista todos os eventos, independente de quem fez
    List<EventoModel> getEventos();

    // Lista os eventos de um ADM
    List<EventoModel> getEventosByAdmName(String nomeAdm);

    // Pega e mostra um evento por id "x"
    Optional <EventoModel> getEventoById(int idEvt);

    // CRUD
    void updateEvento(EventoModel evt);
    void addEvento(String nomeEvt, String descEvt, Date dataEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt, String admEvt);
    void deleteEvento(int idEvt);
    void saveEvento(EventoModel evt);
}
