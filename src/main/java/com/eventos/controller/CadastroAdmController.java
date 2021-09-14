package com.eventos.controller;

import com.eventos.model.AdmModel;
import com.eventos.service.IAdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroAdmController {

    @Autowired
    private IAdmService adm_serv;

    @RequestMapping(value = "/cadastre-se/adm", method = RequestMethod.GET)
    public String cadastroPg(Model model) {
        AdmModel nAdm = new AdmModel();
        model.addAttribute("adm", nAdm);
        return "cadastro_adm";
    }

    @RequestMapping(value = "/concluir-cadastro/adm", method = RequestMethod.POST)
    public String cadastrarUsuario(@ModelAttribute("adm") AdmModel nAdm, BindingResult result) {
        AdmModel existente = adm_serv.findByEmail(nAdm.getEmailAdm());
        if (existente != null) {
            result.rejectValue("emailAdm", null, "Email já está em uso");
        }
        if(result.hasErrors()) {
            return "cadastro_adm";
        }

        adm_serv.saveNovoAdm(nAdm);
        return "redirect:/login";
    }

}
