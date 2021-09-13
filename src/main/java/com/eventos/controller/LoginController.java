package com.eventos.controller;

import com.eventos.model.UsuarioModel;
import com.eventos.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private IUsuarioService user_sev;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPg(Model model) {
        return "login.html";
    }

//    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
//    public String loginAction(Model model) {
//        return null;
//    }



}
