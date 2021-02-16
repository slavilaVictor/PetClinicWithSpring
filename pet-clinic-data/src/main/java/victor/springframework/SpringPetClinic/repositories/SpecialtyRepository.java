package victor.springframework.SpringPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import victor.springframework.SpringPetClinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
