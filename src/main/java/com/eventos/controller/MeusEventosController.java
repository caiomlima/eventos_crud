package com.eventos.controller;

import com.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeusEventosController {

//    @Autowired
//    IEventoService evt_serv;
//
//    @RequestMapping("/meus-eventos")
//    public String meusEventosPg(Model model) {
//        String name = getUsernameLogged(model);
//        model.addAttribute("evt", evt_serv.getEventosByUsername(username)) ;
//
//        return "meus_eventos";
//    }
//
//    private String getUsernameLogged(Model model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        }
//
//        return principal.toString();
//    }

}
