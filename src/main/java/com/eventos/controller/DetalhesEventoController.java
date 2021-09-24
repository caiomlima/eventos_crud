package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class DetalhesEventoController {

    @Autowired
    private IEventoService evt_serv;

    @GetMapping("/evento/{idEvt}")
    public String updateEvent(@PathVariable(value = "idEvt") int idEvt, Model model) {
//        Optional<EventoModel> event = evt_serv.getEventoById(idEvt);
//        model.addAttribute("evento", event);
        evt_serv.getEventoById(idEvt).ifPresent(o -> model.addAttribute("evento", o));
        return "detalhes_evento";
    }

}
