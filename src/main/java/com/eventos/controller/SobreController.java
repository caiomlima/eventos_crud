package com.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SobreController {

    @RequestMapping("/sobre")
    public String sobrePag() {
        return "sobre";
    }

}
