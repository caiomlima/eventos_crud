package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.service.IEventoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListaEventosController {

    private EventoModel evtM;
    private IEventoService evtS;

    @RequestMapping("/eventos")
    public String eventos() {
        return "eventos.html";
    }

//   @RequestMapping(value = "/eventos", method = RequestMethod.GET)
//    public String listarEventos() {
//
//   }

}
