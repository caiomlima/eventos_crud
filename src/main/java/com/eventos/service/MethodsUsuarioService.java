package com.eventos.service;

import com.eventos.model.RoleModel;
import com.eventos.model.UsuarioModel;
import com.eventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MethodsUsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usr_Repo;

    @Lazy
    @Autowired
    private BCryptPasswordEncoder passEncoder;


    public UsuarioModel findByEmail(String emailUsr) {
        return usr_Repo.findByEmailUsr(emailUsr);
    }

    public UsuarioModel saveNovoUsuario(UsuarioModel usr) {
        UsuarioModel user = new UsuarioModel();
        user.setNomeUsr(usr.getNomeUsr());
        user.setEmailUsr(usr.getEmailUsr());
        user.setSenhaUsr(passEncoder.encode(usr.getSenhaUsr()));
        user.setRole(Arrays.asList(new RoleModel("USER")));
        return usr_Repo.save(user);
    }

    // Dá a um usuário recentemente criado a role "USER"
    // @Override
    public UserDetails loadUserByUsername(String emailUsr) throws UsernameNotFoundException {
        UsuarioModel user = usr_Repo.findByEmailUsr(emailUsr);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmailUsr(), user.getSenhaUsr(), mapRolesToAuthorities(user.getRole()));
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleModel> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNomeRole())).collect(Collectors.toList());
    }
}
