package com.eventos.controller;

import com.eventos.model.OrgModel;
import com.eventos.service.IOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CadastroOrgController {

    @Autowired
    private IOrgService org_serv;

    @RequestMapping(value = "/cadastre-se/org", method = RequestMethod.GET)
    public String cadastroPg(Model model) {
        OrgModel nOrg = new OrgModel();
        model.addAttribute("org", nOrg);
        return "cadastro_org";
    }

    @RequestMapping(value = "/concluir-cadastro/org", method = RequestMethod.POST)
    public String cadastrarOrg(@ModelAttribute("org") @Valid OrgModel nOrg, BindingResult result) {
        OrgModel existente = org_serv.findByEmail(nOrg.getEmailOrg());
        if (existente != null) {
            result.rejectValue("emailOrg", null, "Email já está em uso");
        }
        if(result.hasErrors()) {
            return "cadastro_org";
        }

        org_serv.saveNovoOrg(nOrg);
        return "redirect:/login";
    }

}
