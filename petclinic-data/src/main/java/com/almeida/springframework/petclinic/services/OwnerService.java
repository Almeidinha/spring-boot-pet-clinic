package com.almeida.springframework.petclinic.services;

import com.almeida.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
