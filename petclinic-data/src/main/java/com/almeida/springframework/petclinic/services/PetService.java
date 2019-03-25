package com.almeida.springframework.petclinic.services;

import com.almeida.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
