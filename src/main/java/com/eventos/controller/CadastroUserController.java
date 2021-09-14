package com.eventos.controller;

import com.eventos.model.UsuarioModel;
import com.eventos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroUserController {

    @Autowired
    private IUsuarioService user_serv;

    @RequestMapping(value = "/cadastre-se/usuario", method = RequestMethod.GET)
    public String cadastroPg(Model model) {
        UsuarioModel nUsr = new UsuarioModel();
        model.addAttribute("usuario", nUsr);
        return "cadastro_user";
    }

    @RequestMapping(value = "/concluir-cadastro/usuario", method = RequestMethod.POST)
    public String cadastrarUsuario(@ModelAttribute("usuario") UsuarioModel nUsr, BindingResult result) {
        UsuarioModel existente = user_serv.findByEmail(nUsr.getEmailUsr());
        if (existente != null) {
            result.rejectValue("emailUsr", null, "Email já está em uso");
        }
        if(result.hasErrors()) {
            return "cadastro_user";
        }

        user_serv.saveNovoUsuario(nUsr);
        return "redirect:/login";
    }


}
