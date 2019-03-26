package com.almeida.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class vetController {

    @RequestMapping({"", "/", "/index", "/index.hml"})
    public String listVets() {
        return "vets/index";
    }
}
