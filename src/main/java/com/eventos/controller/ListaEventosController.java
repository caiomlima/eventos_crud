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

    private EventoModel evtM;
    private EventoRepository evtRepo;

    @Autowired
    private IEventoService Ievt;

    @RequestMapping("/eventos")
    public String eventos(Model model) {
        model.addAttribute("evt", Ievt.getEventos());
        return "lista_eventos";
    }

    @GetMapping("/excluir-evento/{id_evt}")
    public String deleteEvento(@PathVariable(value = "id_evt") int id_evt) {
        this.Ievt.deleteEvento(id_evt);
        return "redirect:/eventos";
    }

    @RequestMapping(value = "/editar-evento/{id_evt}", method = RequestMethod.GET)
    public String updateEvento(@PathVariable(value = "id_evt") int id_evt, Model model) {
        EventoModel evento = Ievt.getEventoById(id_evt);

        model.addAttribute("evento", evento);

        return "update_evento";
    }

}
