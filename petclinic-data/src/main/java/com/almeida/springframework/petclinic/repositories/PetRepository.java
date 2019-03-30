package com.almeida.springframework.petclinic.repositories;

import com.almeida.springframework.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
