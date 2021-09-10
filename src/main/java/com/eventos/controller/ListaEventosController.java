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

@Controller
public class ListaEventosController {

    private EventoModel evt_model;
    private EventoRepository evt_repo;

    @Autowired
    private IEventoService Ievt;

    @RequestMapping("/eventos")
    public String eventosPg(Model model) {
        model.addAttribute("evt", Ievt.getEventos());
        return "lista_eventos";
    }

    @GetMapping("/excluir-evento/{idEvt}")
    public String deleteEvento(@PathVariable(value = "idEvt") int idEvt) {
        this.Ievt.deleteEvento(idEvt);
        return "redirect:/eventos";
    }

    @RequestMapping(value = "/editar-evento/{idEvt}", method = RequestMethod.GET)
    public String updateEvento(@PathVariable(value = "idEvt") int idEvt, Model model) {
        EventoModel evento = Ievt.getEventoById(idEvt);

        model.addAttribute("evento", evento);

        return "update_evento";
    }

}
