package com.eventos.service;

import com.eventos.model.UserModel;
import com.eventos.model.RoleModel;
import com.eventos.repository.UserRepository;
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
public class MethodsUserService implements IUserService {

    @Autowired
    private UserRepository user_repo;

    @Autowired
    private BCryptPasswordEncoder passEncoder;


    public UserModel findByEmail(String emailUsr) {
        return user_repo.findByEmailUsr(emailUsr);
    }

    public UserModel saveNewUser(UserModel usr) {
        UserModel nUser = new UserModel();
        nUser.setNomeUsr(usr.getNomeUsr());
        nUser.setEmailUsr(usr.getEmailUsr());
        nUser.setSenhaUsr(passEncoder.encode(usr.getSenhaUsr()));
        nUser.setRole(Arrays.asList(new RoleModel("USER")));
        return user_repo.save(nUser);
    }

    @Override
    public UserDetails loadUserByUsername(String emailUsr) throws UsernameNotFoundException {
        UserModel nUser = user_repo.findByEmailUsr(emailUsr);
        if (nUser == null) {
            throw new UsernameNotFoundException("Email ou senha inválidos");
        }
        return new org.springframework.security.core.userdetails.User(nUser.getEmailUsr(), nUser.getSenhaUsr(), mapRolesToAuthorities(nUser.getRole()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleModel> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNomeRole())).collect(Collectors.toList());
    }

}
