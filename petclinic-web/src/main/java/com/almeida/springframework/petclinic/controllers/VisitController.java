package com.almeida.springframework.petclinic.controllers;

import com.almeida.springframework.petclinic.model.Pet;
import com.almeida.springframework.petclinic.model.Visit;
import com.almeida.springframework.petclinic.services.PetService;
import com.almeida.springframework.petclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    // Spring MVC calls this method before each @RequestMapping
    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return "/pets/createOrUpdateVisitForm";
        } else {
            visit.setPet(pet);
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}