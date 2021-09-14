package com.eventos.service;

import com.eventos.model.AdmModel;
import com.eventos.model.RoleModel;
import com.eventos.repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MethodsAdmService implements IAdmService{

    @Autowired
    private AdmRepository adm_repo;

    @Autowired
    private BCryptPasswordEncoder passEncoder;


    public AdmModel findByEmail(String emailAdm) {
        return adm_repo.findByEmailAdm(emailAdm);
    }

    public AdmModel saveNovoAdm(AdmModel adm) {
        AdmModel nAdm = new AdmModel();
        nAdm.setNomeAdm(adm.getNomeAdm());
        nAdm.setEmailAdm(adm.getEmailAdm());
        nAdm.setSenhaAdm(passEncoder.encode(adm.getSenhaAdm()));
        nAdm.setDescAdm((adm.getDescAdm()));
        nAdm.setRole(Arrays.asList(new RoleModel("ADM")));
        return adm_repo.save(nAdm);
    }

    // Dá a um adm recentemente criado a role "ADM"
    //    @Override
    public UserDetails loadUserByUsername(String emailAdm) throws UsernameNotFoundException {
        AdmModel nAdm = adm_repo.findByEmailAdm(emailAdm);
        if (nAdm == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(nAdm.getEmailAdm(), nAdm.getSenhaAdm(), mapRolesToAuthorities(nAdm.getRole()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleModel> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNomeRole())).collect(Collectors.toList());
    }

}
