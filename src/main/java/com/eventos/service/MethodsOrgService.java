package com.eventos.service;

import com.eventos.model.OrgModel;
import com.eventos.model.RoleModel;
import com.eventos.repository.OrgRepository;
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
public class MethodsOrgService implements IOrgService {

    @Autowired
    private OrgRepository org_repo;

    @Autowired
    private BCryptPasswordEncoder passEncoder;


    public OrgModel findByEmail(String emailOrg) {
        return org_repo.findByEmailOrg(emailOrg);
    }

    public OrgModel saveNovoOrg(OrgModel org) {
        OrgModel nOrg = new OrgModel();
        nOrg.setNomeOrg(org.getNomeOrg());
        nOrg.setEmailOrg(org.getEmailOrg());
        nOrg.setSenhaOrg(passEncoder.encode(org.getSenhaOrg()));
        nOrg.setDescOrg((org.getDescOrg()));
        nOrg.setRole(Arrays.asList(new RoleModel("ORG")));
        return org_repo.save(nOrg);
    }

    @Override
    public UserDetails loadUserByUsername(String emailOrg) throws UsernameNotFoundException {
        OrgModel org = org_repo.findByEmailOrg(emailOrg);
        if (org == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(org.getEmailOrg(), org.getSenhaOrg(), mapRolesToAuthorities(org.getRole()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleModel> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNomeRole())).collect(Collectors.toList());
    }

}
