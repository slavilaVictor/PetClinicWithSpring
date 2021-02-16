package victor.springframework.SpringPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import victor.springframework.SpringPetClinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
