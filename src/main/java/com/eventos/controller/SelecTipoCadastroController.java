package com.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelecTipoCadastroController {

    @RequestMapping("cadastre-se")
    public String selecTipoCadastroPag() {
        return "tipo_cadastro";
    }

}
