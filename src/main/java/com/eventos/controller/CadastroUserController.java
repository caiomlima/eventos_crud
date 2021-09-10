package com.eventos.controller;

import com.eventos.model.EventoModel;
import com.eventos.model.UsuarioModel;
import com.eventos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/cadastre-se")
public class CadastroUserController {

//    @RequestMapping("/cadastro")
//    public String cadastroUserPg() {
//        return "cadastro_user.html";
//    }

    @Autowired
    private IUsuarioService user_serv;

//    @ModelAttribute("usuario")
//    public UsuarioModel cadastroUsuario() {
//        return new UsuarioModel();
//    }
//
//    @GetMapping
//    public String formCadastro(Model model) {
//        return "cadastro_user";
//    }

//    @PostMapping
//    public String cadastrarUser(@ModelAttribute("usuario") UsuarioModel usr, BindingResult result) {
//        UsuarioModel existente = userServ.findByEmail(usr.getEmailUsr());
//        if (existente != null) {
//            result.rejectValue("emailUsr", null, "Email já está em uso");
//        }
//
//        if(result.hasErrors()) {
//            return "cadastro_user.html";
//        }
//
//        userServ.saveNovoUsuario(usr);
//        return "redirect:/";
//    }

    @RequestMapping(value = "/cadastre-se", method = RequestMethod.GET)
    public String cadastroPg(Model model) {
        UsuarioModel nUsr = new UsuarioModel();
        model.addAttribute("usuario", nUsr);
        return "cadastro_user";
    }

    @RequestMapping(value = "/concluir-cadastro", method = RequestMethod.POST)
    public String cadastrarUsuario(@ModelAttribute("usuario") UsuarioModel nUsr) {
        user_serv.saveNovoUsuario(nUsr);
        return "redirect:/";
    }



}
