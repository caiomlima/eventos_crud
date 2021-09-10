package com.eventos.service;

import com.eventos.model.EventoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEventoService {

    List<EventoModel> getEventos();

//    List<EventoModel> getEventosByUsername(String username);

//    Optional<EventoModel> getEventosById(int idEvt);

    EventoModel getEventoById(int idEvt);

    void updateEvento(EventoModel evt);

    void addEvento(String nomeEvt, String descEvt, Date dataEvt, String qtdPessEvt, String regiaoEvt, String endrcEvt);

    void deleteEvento(int idEvt);

    void saveEvento(EventoModel evt);
}
