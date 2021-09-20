package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class MeusEventosController {

    @Autowired
    IEventoService evt_serv;

    @RequestMapping(value = "/meus-eventos", method = RequestMethod.GET)
    public String myEventsPg(Model model) {
        String name = getUsernameLogged(model);
        model.addAttribute("evt", evt_serv.getEventosByUserName(name)) ;
        return "meus_eventos";
    }

    private String getUsernameLogged(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @GetMapping("/excluir-evento/{idEvt}")
    public String deleteEvent(@PathVariable(value = "idEvt") int idEvt) {
        this.evt_serv.deleteEvento(idEvt);
        return "redirect:/eventos";
    }

    @RequestMapping(value = "/editar-evento/{idEvt}", method = RequestMethod.GET)
    public String updateEvent(@PathVariable(value = "idEvt") int idEvt, Model model) {
        Optional<EventoModel> evento = evt_serv.getEventoById(idEvt);
        model.addAttribute("evento", evento);
        return "form_update_evento";
    }

}
