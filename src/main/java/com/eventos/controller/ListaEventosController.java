package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.repository.EventoRepository;
import com.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListaEventosController {

    private EventoModel evtM;
    private EventoRepository evtRepo;

    @Autowired
    private IEventoService evtS;

    @RequestMapping("/eventos")
    public String eventos(Model model) {
        model.addAttribute("evt", evtS.getEventos());
        return "lista_eventos";
    }

}
