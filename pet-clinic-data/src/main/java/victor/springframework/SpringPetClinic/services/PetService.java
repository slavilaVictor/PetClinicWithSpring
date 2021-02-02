package victor.springframework.SpringPetClinic.services;

import victor.springframework.SpringPetClinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
