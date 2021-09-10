package com.eventos.repository;

import com.eventos.model.EventoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Integer> {
//    @Autowired
//    List<EventoModel> findById(int idEvt);

//    @Autowired
//    List<EventoModel> findByUsername(String username);
}
