package com.almeida.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class vetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.hml"})
    public String listVets() {
        return "vets/index";
    }
}
