package com.eventos.service;

import com.eventos.model.UsuarioModel;
import com.eventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends UserDetailsService {

    UsuarioModel findByEmail(String emailUsr);

    UsuarioModel saveNovoUsuario(UsuarioModel usr);

}
