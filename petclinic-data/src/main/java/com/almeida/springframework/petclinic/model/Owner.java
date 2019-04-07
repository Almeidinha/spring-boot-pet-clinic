package com.almeida.springframework.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String phone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        if (pets != null) {
            this.pets = pets;
        }
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public void addPet(Pet pet) {
        if (pet.isNew()) {
            this.getPets().add(pet);
        }
        pet.setOwner(this);
    }

    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /*public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        final String pp = name.toLowerCase();

        return pets.stream()
                .filter(pet -> (!ignoreNew || !pet.isNew()) && pet.getName().equals(pp))
                .findAny().orElse(null);

    }*/
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                if (pet.getName().toLowerCase().equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }

}
