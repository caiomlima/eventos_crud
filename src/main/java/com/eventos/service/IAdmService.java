package com.eventos.service;

import com.eventos.model.AdmModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAdmService extends UserDetailsService {

    AdmModel findByEmail(String emailAdm);

    AdmModel saveNovoAdm(AdmModel amd);

}
