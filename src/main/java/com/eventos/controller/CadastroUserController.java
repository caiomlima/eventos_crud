package com.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroUserController {

    @RequestMapping("/cadastro")
    public String cadastroUserPg() {
        return "cadastro_user.html";
    }

}
