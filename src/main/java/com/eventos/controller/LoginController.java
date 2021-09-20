package com.eventos.controller;

import com.eventos.model.UsuarioModel;
import com.eventos.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private IUsuarioService user_sev;

    @GetMapping("/login")
    public String loginPg(Model model) {
        return "login";
    }

}
