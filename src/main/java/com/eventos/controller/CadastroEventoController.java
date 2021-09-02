package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.repository.EventoRepository;
import com.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class CadastroEventoController {

    private EventoModel evtM;
    @Autowired
    private EventoRepository evt_repo;
    @Autowired
    private IEventoService Ievt;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/novo-evento", method = RequestMethod.GET)
    public String criarEvtPg(Model model) {
        EventoModel nevt = new EventoModel();
        model.addAttribute("evento", nevt);
        return "cadastro_evento";
    }

    @RequestMapping(value = "/salvar-evento", method = RequestMethod.POST)
    public String addEvento(@ModelAttribute("evento") EventoModel nevt) {
        Ievt.saveEvento(nevt);
        return "redirect:/eventos";
    }

    // Função para pegar o nome do User que fez o evento
//    private String getUsernameLogged(Model model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        }
//
//        return principal.toString();
//    }

    // Função que faz o novo evento e associa ao user que fez ele
//    @RequestMapping(value = "/novo-evento", method = RequestMethod.POST)
//    public String addEvento(Model model, EventoModel evt, BindingResult result) {
//        if (result.hasErrors()) {
//            return "cadastro_evento";
//        }
//
//        evt.setUserName(getUsernameLogged(model));
//        Ievt.saveEvento(evt);
//        return "redirect:/eventos";
//    }

}
