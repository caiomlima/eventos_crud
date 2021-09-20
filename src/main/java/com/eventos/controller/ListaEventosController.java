package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.repository.EventoRepository;
import com.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ListaEventosController {

    @Autowired
    private IEventoService evt_serv;

    @RequestMapping("/eventos")
    public String eventsPg(Model model) {
        model.addAttribute("evt", evt_serv.getEventos());
        return "lista_eventos";
    }

}
