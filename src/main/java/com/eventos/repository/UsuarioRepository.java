package com.eventos.repository;

import com.eventos.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    @Autowired
    UsuarioModel findByEmailUsr(String emailUsr);
}
