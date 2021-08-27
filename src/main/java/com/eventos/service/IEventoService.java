package com.eventos.service;

import com.eventos.model.EventoModel;

import java.util.Date;
import java.util.List;

public interface IEventoService {

    List<EventoModel> getEventosById(int id_evt);

    //    Optional<EventoModel> getEventosByUsername(String username);

    void updateEvento(EventoModel evt);

    void addEvento(String nome_evt, String desc_evt, Date data_evt, String qtd_pessoas_evt, String regiao_evt, String endereco_evt);

    void deleteEvento(int id_evt);

    void saveEvento(EventoModel evt);
}
