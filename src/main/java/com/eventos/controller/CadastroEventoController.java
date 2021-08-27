package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.repository.EventoRepository;
import com.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = "/novo-evento", method = RequestMethod.GET)
    public String criarEvtPg(ModelMap model) {
        model.addAttribute("evento", new EventoModel());
        return "cadastro_evento";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

//    @PostMapping
//    @RequestMapping(value = "/novo-evento", method = RequestMethod.POST)
//    public void add(@RequestBody EventoModel evt) {
//        evtS.save(evt);
//    }

    @RequestMapping(value = "/novo-evento", method = RequestMethod.POST)
    public String addEvento(EventoModel evt) {

//        if (result.hasErrors()) {
//            return "cadastro_evento";
//        }

        Ievt.saveEvento(evt);
        return "redirect:/";
    }

}
