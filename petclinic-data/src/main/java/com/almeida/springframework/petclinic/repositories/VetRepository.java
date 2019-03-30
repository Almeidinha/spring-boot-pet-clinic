package com.almeida.springframework.petclinic.repositories;

import com.almeida.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
