package com.eventos.service;

import com.eventos.model.EventoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEventoService {

    List<EventoModel> getEventos();

//    List<EventoModel> getEventosByUsername(String username);

//    Optional<EventoModel> getEventosById(int id_evt);

    EventoModel getEventoById(int id_evt);

    void updateEvento(EventoModel evt);

    void addEvento(String nome_evt, String desc_evt, Date data_evt, String qtd_pessoas_evt, String regiao_evt, String endereco_evt);

    void deleteEvento(int id_evt);

    void saveEvento(EventoModel evt);
}
