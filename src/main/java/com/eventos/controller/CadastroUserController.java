package com.eventos.controller;

import com.eventos.model.UserModel;
import com.eventos.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CadastroUserController {

    @Autowired
    private IUserService user_serv;

    @RequestMapping(value = "/cadastre-se", method = RequestMethod.GET)
    public String registrationPg(Model model) {
        UserModel nUser = new UserModel();
        model.addAttribute("usr", nUser);
        return "form_cadastro_user";
    }

    @RequestMapping(value = "/concluir-cadastro", method = RequestMethod.POST)
    public String userRegistration(@ModelAttribute("usr") @Valid UserModel nUser, BindingResult result) {
        UserModel existente = user_serv.findByEmail(nUser.getEmailUsr());
        if (existente != null) {
            result.rejectValue("emailUsr", null, "Email já está em uso");
        }
        if(result.hasErrors()) {
            return "form_cadastro_user";
        }
        user_serv.saveNewUser(nUser);
        return "redirect:/login";
    }

}
