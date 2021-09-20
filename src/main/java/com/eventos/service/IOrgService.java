package com.eventos.service;

import com.eventos.model.OrgModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IOrgService extends UserDetailsService {

    OrgModel findByEmail(String emailOrg);

    OrgModel saveNovoOrg(OrgModel org);

}
