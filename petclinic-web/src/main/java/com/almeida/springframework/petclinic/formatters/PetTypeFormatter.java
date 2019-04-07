package com.almeida.springframework.petclinic.formatters;

import com.almeida.springframework.petclinic.model.PetType;
import com.almeida.springframework.petclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTyPetService;

    public PetTypeFormatter(PetTypeService petTyPetService) {
        this.petTyPetService = petTyPetService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        // Change this to find by the pet type name;
        Collection<PetType> petTypes = petTyPetService.findAll();
        for (PetType petType : petTypes) {
            if (petType.getName().equals(text)) {
                return  petType;
            }
        }
        throw new ParseException("Type not found: " + text, 0);
    }

}
