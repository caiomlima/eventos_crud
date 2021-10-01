package com.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoriasEventosController {

    @RequestMapping("/categorias")
    public String categoryPg(Model model) {
        return "categorias_eventos";
    }

}