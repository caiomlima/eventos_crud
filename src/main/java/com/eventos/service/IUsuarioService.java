package com.eventos.service;

import com.eventos.model.UsuarioModel;
import com.eventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface IUsuarioService{

    UsuarioModel findByEmail(String emailUsr);

    UsuarioModel saveNovoUsuario(UsuarioModel usr);

}
