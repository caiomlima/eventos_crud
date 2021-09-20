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

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class CadastroEventoController {

    @Autowired
    private EventoRepository evt_repo;
    @Autowired
    private IEventoService evt_serv;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/novo-evento")
    public String criarEvtPg(Model model) {
        EventoModel nEvt = new EventoModel();
        model.addAttribute("evento", nEvt);
        return "cadastro_evento";
    }


    // Antigo metodo de criar eventos (qq um sem auth pode fazer um evento)
//    @RequestMapping(value = "/salvar-evento", method = RequestMethod.POST)
//    public String addEvento(@ModelAttribute("evento") EventoModel nevt) {
//        evt_serv.saveEvento(nevt);
//        return "redirect:/eventos";
//    }


//     Função para pegar o nome do organizador que fez o evento
    private String getUsernameLogged(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @PostMapping("/salvar-evento")
    public String addEvento(@ModelAttribute("evento") @Valid EventoModel evt, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastro_evento";
        }
        evt.setOrgEvt(getUsernameLogged(model));
        evt_serv.saveEvento(evt);
        return "redirect:/meus-eventos";
    }

}
