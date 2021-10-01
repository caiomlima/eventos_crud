package com.eventos.service;

import com.eventos.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    UserModel findByEmail(String emailUsr);

    UserModel saveNewUser(UserModel usr);

}