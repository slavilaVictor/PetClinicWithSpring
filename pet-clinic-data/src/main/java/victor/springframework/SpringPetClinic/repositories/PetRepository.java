package victor.springframework.SpringPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import victor.springframework.SpringPetClinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
